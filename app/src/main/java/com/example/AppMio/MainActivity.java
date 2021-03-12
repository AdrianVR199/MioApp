package com.example.AppMio;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;



import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precio, edad;

    private RadioButton ES, EN, MFS, MFN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Datos de Entrada
        edad = findViewById(R.id.txtInputEdad);
        precio = findViewById(R.id.txtInputPrecio);
        ES = findViewById(R.id.radioButtonES);
        EN = findViewById(R.id.radioButtonEN);
        MFS = findViewById(R.id.radioButtonMFS);
        MFN = findViewById(R.id.radioButtonMFN);



    }

    public void CalculatePrice (View view) {

        String value1 = edad.getText().toString();
        String value2 = precio.getText().toString();

        double precioapagar = 0;
        String porcentajeD = "";

        int age = Integer.parseInt(value1);
        int precio = Integer.parseInt(value2);


        if (age >= 4){
            if (MFN.isChecked()) {
                if (age >= 4 && age <= 7) {

                    precioapagar = (precio / 2);
                    porcentajeD = "50%";

                } else if (age >= 65) {

                    precioapagar = (precio * 0.4);
                    porcentajeD = "60%";

                } else {

                    if (ES.isChecked()) {

                        precioapagar = (precio * 0.6);
                        porcentajeD = "40%";

                    } else if (EN.isChecked()) {

                        precioapagar = precio;
                        porcentajeD = "0%";

                    }

                }
            } else if (MFS.isChecked()){

                precioapagar = (precio*0.3);
                porcentajeD = "70%";
            }
        } else {

            precioapagar = 0;
            porcentajeD = "100%";

        }

        String resultado = String.valueOf(precioapagar);

        resultado1("El Porcentaje de su descuento es: " + porcentajeD + "\n" + "El Precio de su pasaje es: " + resultado + "$");

    }

    public void resultado1 (String cadena) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage(cadena);
        dialogBuilder.setCancelable(true).setTitle("Resultado");
        dialogBuilder.create().show();

    }


}