package com.cibertec.dami_actividad01_jv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActualizarProductoActivity extends AppCompatActivity {

    private EditText edTxtIdProd, edTxtNomProd, edTxtPrecio, edTxtStock;
    private Spinner spCategorias, spEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_producto);

        edTxtIdProd = findViewById(R.id.edTxtIdProdAP);
        edTxtNomProd = findViewById(R.id.edTxtNomProdAP);
        edTxtPrecio = findViewById(R.id.edTxtPrecioAP);
        edTxtStock = findViewById(R.id.edTxtStockAP);
        spCategorias = findViewById(R.id.spnCategoriasAP);
        spEstados = findViewById(R.id.spnEstadosAP);

        String[] categorias = {"Seleccionar opción", "Ropa", "Juguetes", "Lactéos"};
        ArrayAdapter<String> adapterCategorias =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categorias);
        spCategorias.setAdapter(adapterCategorias);

        String[] estados = {"Seleccionar opción", "Activo", "Inactivo"};
        ArrayAdapter<String> adapterEstados =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        estados);
        spEstados.setAdapter(adapterEstados);
    }

    public void buscar(View view) {
        try {
            int idProd = Integer.parseInt(edTxtIdProd.getText().toString());
            if(idProd >= 1) {
                if (idProd == 1) {
                    cargarDatosProducto("Rompecabezas", 2, 49.50, 100, 1);
                } else if (idProd == 2) {
                    cargarDatosProducto("Leche Gloria", 3, 100.99, 20, 1);
                } else if (idProd == 3) {
                    cargarDatosProducto("Polo Manga Larga", 1, 20.50, 10, 2);
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

    public void cargarDatosProducto(String nombre, int categItem, double precio, int stock, int estadoItem) {
        edTxtNomProd.setText(nombre);
        spCategorias.setSelection(categItem);
        edTxtPrecio.setText(precio + "");
        edTxtStock.setText(stock + "");
        spEstados.setSelection(estadoItem);
    }
}