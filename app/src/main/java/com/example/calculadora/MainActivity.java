package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText et1, et2;
    private TextView resultado;
    private CheckBox verde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById( R.id.spinner);
        et1 = findViewById( R.id.editText1);
        et2 = findViewById( R.id.editText2);
        resultado = findViewById( R.id.textViewResultado);
        verde = findViewById( R.id.checkBox);

        String[] op = {"soma", "resta", "multiplicação" , "divisão"};
//criar adaptador de lista
        ArrayAdapter<String> adapter = new ArrayAdapter< String>(this,
                R.layout.support_simple_spinner_dropdown_item, op);
        //adiciona adaptador a lista
        spinner.setAdapter(adapter);
    }

    public void Calcular(View view) {
        int Valor1 = Integer.parseInt(et1.getText().toString());
        int Valor2 = Integer.parseInt(et2.getText().toString());
        int result = 0;
        String selection = spinner.getSelectedItem().toString();
        switch (selection) {
            case "soma":
                result = Valor1 + Valor2;
                break;
            case "resta":
                result = Valor1 - Valor2;
                break;
            case "multiplicação":
                result = Valor1 * Valor2;
                break;
            case "divisão":
                if(Valor2==0)
                    Toast.makeText(this," O divisor não pode ser zero",Toast.LENGTH_LONG).show(); //metodo estatico
                else result = Valor1 / Valor2;
                break;
        }
        resultado.setText(String.valueOf(result));
        et1.setText("");
        et2.setText("");
    }

    public void mudarCor(View view){
        if(verde.isChecked()) {
            resultado.setTextColor(Color.GREEN);
        }
        else
            resultado.setTextColor(Color.BLACK);
    }

    public void abrirToast(View view){
        ImageView imagen = new ImageView(getApplicationContext());
        imagen.setImageResource(R.drawable.ic_launcher_background);
        TextView texto= new TextView(getApplicationContext());
        texto.setText("Olá Toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagen);
        //toast.setView(texto);
        toast.show();
    }


}