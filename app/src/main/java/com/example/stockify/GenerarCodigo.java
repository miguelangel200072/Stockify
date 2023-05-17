package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.print.PrintHelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerarCodigo extends AppCompatActivity {
    ImageView imgCodigo;
    EditText etCodigo;
    TextView tvUser;
    Button btnGenerar, btnImprimir, btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_codigo);
        etCodigo = findViewById(R.id.etCodigo);
        btnGenerar = findViewById(R.id.btnGenerar);
        imgCodigo = findViewById(R.id.imgCodigo);
        btnImprimir = findViewById(R.id.btnImprimir);
        tvUser = findViewById(R.id.tvUser);
        btnScan = findViewById(R.id.btnScan);
        String username = getIntent().getStringExtra("username");
        tvUser.setText(username);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(etCodigo.getText().toString(), BarcodeFormat.CODE_128, 750, 300);
                    imgCodigo.setImageBitmap(bitmap);
                } catch (Exception e){
                    e.printStackTrace();
                }
                btnImprimir.setVisibility(View.VISIBLE);
            }
        });
        btnImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprimirCodigos();
            }
        });
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrador = new IntentIntegrator(GenerarCodigo.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Stockify");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });
    }

    private void imprimirCodigos() {
        try {
            // Obtener las imágenes de los códigos de barras y los textos correspondientes
            Bitmap bitmap1 = ((BitmapDrawable) imgCodigo.getDrawable()).getBitmap();
            String codigo1 = etCodigo.getText().toString();

            // Configurar la impresora
            PrintHelper printHelper = new PrintHelper(GenerarCodigo.this);
            printHelper.setScaleMode(PrintHelper.SCALE_MODE_FIT);
            printHelper.setColorMode(PrintHelper.COLOR_MODE_MONOCHROME);

            // Crear el canvas para dibujar el primer código de barras y su texto
            Bitmap combinedBitmap1 = Bitmap.createBitmap(bitmap1.getWidth() + 800, bitmap1.getHeight() + 200, Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(combinedBitmap1);
            canvas1.drawBitmap(bitmap1, 0, 50, null);
            Paint paint = new Paint();
            Paint paint2 = new Paint();
            paint.setTextSize(60);

            paint.setColor(Color.BLACK);
            canvas1.drawText(codigo1, 50, bitmap1.getHeight() + 100, paint);

            // Imprimir el bitmap final
            printHelper.printBitmap("codigos", combinedBitmap1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                etCodigo.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}