package com.example.stockify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockify.db.RegistroNuevoDB;
import com.example.stockify.db.UserDB;
import com.example.stockify.entidades.User;

public class Registro extends AppCompatActivity {
    EditText etUser, etPass;
    Button btnRegistro;
    RegistroNuevoDB dbContactos;
    UserDB userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnRegistro = findViewById(R.id.btnRegistro);

        dbContactos = new RegistroNuevoDB(Registro.this);
        userDB = new UserDB(dbContactos.getReadableDatabase());

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUser.getText().toString();
                String password = etPass.getText().toString();

                if (!username.equals("") && !password.equals("")) {
                    User existingUser = userDB.getUser(username, password);
                    if (existingUser != null) {
                        Toast.makeText(Registro.this, "El usuario ya existe", Toast.LENGTH_LONG).show();
                    } else {
                        boolean isUsernameTaken = userDB.checkUsernameExists(username);
                        if (isUsernameTaken) {
                            Toast.makeText(Registro.this, "El nombre de usuario ya está en uso", Toast.LENGTH_LONG).show();
                        } else {
                            long id = dbContactos.insertarContacto(username, password);

                            if (id > 0) {
                                Toast.makeText(Registro.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                                limpiar();
                            } else {
                                Toast.makeText(Registro.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                } else {
                    Toast.makeText(Registro.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
        etUser.setText("");
        etPass.setText("");
    }
}