package com.cibertec.dami_actividad01_jv;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActualizarProductoActivity extends AppCompatActivity {

    private EditText edTxtIdProd, edTxtNomProd, edTxtPrecio, edTxtStock;
    private Spinner spCategorias, spEstados;
    private Button btnGuardar;
    private int idProducto;

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

        btnGuardar = findViewById(R.id.btnGuardarAP);

        idProducto = 0;

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
                    cargarDatosProducto(1, "Rompecabezas", 2, 49.50, 100, 1);
                    alterarBoton(btnGuardar, true, "#3F51B5");
                } else if (idProd == 2) {
                    cargarDatosProducto(2, "Leche Gloria", 3, 100.99, 20, 1);
                    alterarBoton(btnGuardar, true, "#3F51B5");
                } else if (idProd == 3) {
                    cargarDatosProducto(3, "Polo Manga Larga", 1, 20.50, 10, 2);
                    alterarBoton(btnGuardar, true, "#3F51B5");
                } else {
                    Toast.makeText(this, "No se encontró el producto", Toast.LENGTH_LONG).show();
                    limpiarFormulario();
                    alterarBoton(btnGuardar, false, "#6A6B71");
                }
            } else {
                Toast.makeText(this, "Ingresar ID de producto válido", Toast.LENGTH_LONG).show();
                limpiarFormulario();
                alterarBoton(btnGuardar, false, "#6A6B71");
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ingresar ID de producto válido", Toast.LENGTH_LONG).show();
            limpiarFormulario();
            alterarBoton(btnGuardar, false, "#6A6B71");
        }
    }

    public void guardar(View view) {
        if(idProducto > 0) {
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
                                    int estadoItem = spEstados.getSelectedItemPosition();
                                    if(estadoItem != 0) {
                                        Toast.makeText(this, "Producto actualizado", Toast.LENGTH_LONG).show();
                                        limpiarFormulario();
                                    } else {
                                        Toast.makeText(this, "Seleccionar un estado", Toast.LENGTH_LONG).show();
                                    }
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
        } else {
            Toast.makeText(this, "Buscar producto", Toast.LENGTH_LONG).show();
        }
    }

    public void volver(View view) {
        finish();
    }

    public void cargarDatosProducto(int idProd, String nombre, int categItem, double precio, int stock, int estadoItem) {
        idProducto = idProd;
        edTxtNomProd.setText(nombre);
        spCategorias.setSelection(categItem);
        edTxtPrecio.setText(precio + "");
        edTxtStock.setText(stock + "");
        spEstados.setSelection(estadoItem);
    }

    public void limpiarFormulario() {
        idProducto = 0;
        edTxtIdProd.setText("");
        edTxtNomProd.setText("");
        spCategorias.setSelection(0);
        edTxtPrecio.setText("");
        edTxtStock.setText("");
        spEstados.setSelection(0);
        alterarBoton(btnGuardar, false, "#6A6B71");
    }

    public void alterarBoton(Button btn, boolean enabled, String colorCode) {
        btn.setEnabled(enabled);
        btn.setBackgroundColor(Color.parseColor(colorCode));
    }
}