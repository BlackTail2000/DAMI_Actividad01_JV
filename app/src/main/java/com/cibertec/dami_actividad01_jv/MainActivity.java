package com.cibertec.dami_actividad01_jv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edTxtUsuario, edTxtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTxtUsuario = findViewById(R.id.edTxtUsuarioMain);
        edTxtPassword = findViewById(R.id.edTxtPasswordMain);
    }

    public void ingresar(View view) {
        String usuario = edTxtUsuario.getText().toString();
        String password = edTxtPassword.getText().toString();

        if(usuario.equals("Admin") && password.equals("admin12345")) {
            Intent intent = new Intent(this, MantenimientoProductosActivity.class);
            startActivity(intent);
            edTxtUsuario.setText("");
            edTxtPassword.setText("");
        } else {
            Toast.makeText(this,
                    "Usuario y/o contraseñas incorrectos",
                    Toast.LENGTH_SHORT).show();
        }
    }
}