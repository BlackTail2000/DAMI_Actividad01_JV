package com.cibertec.dami_actividad01_jv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MantenimientoProductosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento_productos);
    }

    public void irHaciaLayoutRegistrarProductos(View view) {
        Intent intent = new Intent(this, RegistrarProductoActivity.class);
        startActivity(intent);
    }

    public void irHaciaLayoutBuscarProductos(View view) {
        Intent intent = new Intent(this, BuscarProductosActivity.class);
        startActivity(intent);
    }

    public void irHaciaLayoutActualizarProductos(View view) {
        Intent intent = new Intent(this, ActualizarProductoActivity.class);
        startActivity(intent);
    }

    public void salir(View view) {
        System.exit(0);
    }
}