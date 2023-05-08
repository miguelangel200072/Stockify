package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockify.db.DatabaseHelper;
import com.example.stockify.db.UserDAO;
import com.example.stockify.entidades.User;

public class Login extends AppCompatActivity {


    private SQLiteDatabase mDatabase;
    private EditText etUser;
    private EditText etPass;
    private UserDAO mUserDAO;
    private Button btnLogin;
    private Button btnRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        mDatabase = dbHelper.getWritableDatabase();
        mUserDAO = new UserDAO(mDatabase);
        btnLogin = findViewById(R.id.btnInsertar);
        btnRegistro = findViewById(R.id.btnRegistro);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUser.getText().toString();
                String password = etPass.getText().toString();
                User user = mUserDAO.getUser(username, password);
                if (user != null) {
                    // Login successful
                    Toast.makeText(Login.this, "Bienvenido "+ etUser.getText().toString(), Toast.LENGTH_SHORT).show();
                    etUser.setText("");
                    etPass.setText("");
                    Intent intent = new Intent(Login.this, MenuAPP.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    // Login failed
                    Toast.makeText(Login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    etUser.setText("");
                    etPass.setText("");
                }
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
            }
        });
    }
}