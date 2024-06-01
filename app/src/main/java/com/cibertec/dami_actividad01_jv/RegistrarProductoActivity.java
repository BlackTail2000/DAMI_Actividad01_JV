package com.cibertec.dami_actividad01_jv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarProductoActivity extends AppCompatActivity {

    private EditText edTxtNomProd, edTxtPrecio, edTxtStock;
    private Spinner spCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        edTxtNomProd = findViewById(R.id.edTxtNomProdRP);
        edTxtPrecio = findViewById(R.id.edTxtPrecioRP);
        edTxtStock = findViewById(R.id.edTxtStockRP);
        spCategorias = findViewById(R.id.spnCategoriasRP);

        String[] categorias = {"Seleccionar opción", "Ropa", "Juguetes", "Lactéos"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categorias);
        spCategorias.setAdapter(adapter);
    }

    public void guardarProducto(View view) {
        String nomProd = edTxtNomProd.getText().toString().trim();
        if(!nomProd.equals("")) {
            int categItem = spCategorias.getSelectedItemPosition();
            if(categItem != 0) {
                try {
                    double precio = Double.parseDouble(edTxtPrecio.getText().toString());
                    if(precio > 0) {
                        try {
                            int stock = Integer.parseInt(edTxtStock.getText().toString());
                            if(stock >= 0) {
                                Toast.makeText(this, "Producto registrado", Toast.LENGTH_LONG).show();
                                edTxtNomProd.setText("");
                                spCategorias.setSelection(0);
                                edTxtPrecio.setText("");
                                edTxtStock.setText("");
                            } else {
                                Toast.makeText(this, "Ingresar un stock válido", Toast.LENGTH_LONG).show();
                            }
                        } catch(Exception e) {
                            Toast.makeText(this, "Ingresar un stock válido", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "Ingresar un precio válido", Toast.LENGTH_LONG).show();
                    }
                } catch(Exception e) {
                    Toast.makeText(this, "Ingresar un precio válido", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Seleccionar una categoría", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Ingresar nombre de producto", Toast.LENGTH_LONG).show();
        }
    }

    public void toastError(String msj) {
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
    }
}