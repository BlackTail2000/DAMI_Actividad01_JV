package com.cibertec.dami_actividad01_jv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuscarProductosActivity extends AppCompatActivity {

    private EditText edTxtIdProd;
    private TextView txtNomProd, txtCategoria, txtPrecio, txtStock, txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_productos);

        edTxtIdProd = findViewById(R.id.edTxtIdProdBP);
        txtNomProd = findViewById(R.id.txtNomProdBP);
        txtCategoria = findViewById(R.id.txtCategoriaBP);
        txtPrecio = findViewById(R.id.txtPrecioBP);
        txtStock = findViewById(R.id.txtStockBP);
        txtEstado = findViewById(R.id.txtEstado);
    }

    public void buscar(View view) {
        try {
            int idProd = Integer.parseInt(edTxtIdProd.getText().toString());
            if(idProd >= 1) {
                if (idProd == 1) {
                    cargarDatosProducto("Rompecabezas", "Juguetes", 49.50, 100, "Activo");
                } else if (idProd == 2) {
                    cargarDatosProducto("Leche Gloria", "Lactéos", 100.99, 20, "Activo");
                } else if (idProd == 3) {
                    cargarDatosProducto("Polo Manga Larga", "Ropa", 20.50, 10, "Inactivo");
                } else {
                    Toast.makeText(this, "No se encontró el producto", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Ingresar ID de producto válido", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ingresar ID de producto válido", Toast.LENGTH_LONG).show();
        }
    }

    public void volver(View view) {
        finish();
    }

    public void cargarDatosProducto(String nombre, String categoria, double precio, int stock, String estado) {
        txtNomProd.setText("Nombre: " + nombre);
        txtCategoria.setText("Categoría: " + categoria);
        txtPrecio.setText("Precio: S/." + precio);
        txtStock.setText("Stock: " + stock);
        txtEstado.setText("Estado: " + estado);
    }
}