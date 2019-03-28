package com.example.calculadora_refuerzo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txvOperar;
    private Button botonBorrar;
    private String stringOpera;
    private  float resultado,num1,num2;
    private Toolbar miToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        miToolbar=findViewById(R.id.toolBar);
        setSupportActionBar(miToolbar);

        txvOperar = findViewById(R.id.txvOperar);
        botonBorrar=findViewById(R.id.btnBorrar);
        botonBorrar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    stringOpera = "";
                    txvOperar.setText(stringOpera);
                } catch (IndexOutOfBoundsException error) {
                    Log.d("Clear", "No se puede eliminar más ");
                }

                return false;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mAcerca:
                Intent informacion= new Intent(this,ActivityInformation.class);
                startActivity(informacion);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClick(View v)
    {
        int seleccion= v.getId();
        stringOpera= txvOperar.getText().toString();

        int n=stringOpera.length();

        switch (seleccion){
            case R.id.btnPunto:
                stringOpera+= ".";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn0:
                stringOpera+= "0";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn1:
                stringOpera+= "1";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn2:
                stringOpera+="2";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn3:
                stringOpera+= "3";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn4:
                stringOpera+="4";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn5:
                stringOpera+= "5";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn6:
                stringOpera+="6";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn7:
               stringOpera+= "7";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn8:
                stringOpera+="8";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btn9:
                stringOpera+= "9";
                txvOperar.setText(stringOpera);
                break;
            case R.id.BtnSuma:
                stringOpera+= "+";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnMultiplicacion:
                stringOpera+= "X";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnResta:
                stringOpera+= "-";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnDivision:
                stringOpera+= "/";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnBorrar:
                try
                {
                    stringOpera=stringOpera.substring(0,n-1);
                    txvOperar.setText(stringOpera);

                }catch ( IndexOutOfBoundsException error) {
                    Log.d("Clear", "No se puede eliminar más ");
                }
                break;
            case R.id.btnExp:
                stringOpera+= "e^(";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnLn:
                stringOpera+= "ln(";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnLog:
                stringOpera+= "Log(";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnSen:
                stringOpera+= "Sen(";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnCos:
                stringOpera+= "Cos(";
                txvOperar.setText(stringOpera);
                break;
            case R.id.btnTan:
                stringOpera+= "Tan(";
                txvOperar.setText(stringOpera);
                break;


        }

    }

    public void onClickResultado(View v) {

        String suma[]= stringOpera.split("\\+");
        String resta[] = String.valueOf(txvOperar.getText()).split("[-]");
        String multiplicacion[] = String.valueOf(txvOperar.getText()).split("X");
        String division[] = String.valueOf(txvOperar.getText()).split("[/]");
        String pot[]= String.valueOf(txvOperar.getText()).split("[-]");
        String trasendentes=String.valueOf(txvOperar.getText());


        char auxArray[];


        try {


            if (stringOpera.toCharArray()[0] != 'S' || stringOpera.toCharArray()[0] != 'C'
                    || stringOpera.toCharArray()[0] != 'T' || stringOpera.toCharArray()[0] != 'l'
                    || stringOpera.toCharArray()[0] != 'L' || stringOpera.toCharArray()[0] != 'e') {
                if (suma.length > 1) {
                    num1 = Float.parseFloat(suma[0]);
                    num2 = Float.parseFloat(suma[1]);
                    resultado = num1 + num2;
                    txvOperar.setText(String.valueOf(resultado));
                } else if (resta.length > 1) {
                    num1 = Float.parseFloat(resta[0]);
                    num2 = Float.parseFloat(resta[1]);
                    resultado = num1 - num2;
                    txvOperar.setText(String.valueOf(resultado));


                } else if (multiplicacion.length > 1) {
                    num1 = Float.parseFloat(multiplicacion[0]);
                    num2 = Float.parseFloat(multiplicacion[1]);
                    resultado = num1 * num2;
                    txvOperar.setText(String.valueOf(resultado));


                } else if (division.length > 1) {
                    num1 = Float.parseFloat(division[0]);
                    num2 = Float.parseFloat(division[1]);
                    resultado = num1 / num2;
                    txvOperar.setText(String.valueOf(resultado));


                } else if (suma.length == 1 || resta.length == 1 || multiplicacion.length == 1 || division.length == 1) {
                    txvOperar.setText(stringOpera);
                }

            }


            if (trasendentes.toCharArray()[0] == 'S') {

                auxArray = new char[trasendentes.length() - 4];
                trasendentes.getChars(4, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.sin(Math.toRadians((double) num2));

                txvOperar.setText(String.valueOf(resultado));
            } else if (trasendentes.toCharArray()[0] == 'C') {

                auxArray = new char[trasendentes.length() - 4];
                trasendentes.getChars(4, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.cos(Math.toRadians((double) num2));

                txvOperar.setText(String.valueOf(resultado));
            } else if (trasendentes.toCharArray()[0] == 'T') {

                auxArray = new char[trasendentes.length() - 4];
                trasendentes.getChars(4, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.tan(Math.toRadians((double) num2));

                txvOperar.setText(String.valueOf(resultado));
            } else if (trasendentes.toCharArray()[0] == 'e') {

                auxArray = new char[trasendentes.length() - 3];
                trasendentes.getChars(3, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.exp((double) num2);

                txvOperar.setText(String.valueOf(resultado));
            } else if (trasendentes.toCharArray()[0] == 'l') {

                auxArray = new char[trasendentes.length() - 3];
                trasendentes.getChars(3, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.log((double) num2);

                txvOperar.setText(String.valueOf(resultado));
            }
            else if (trasendentes.toCharArray()[0] == 'L') {

                auxArray = new char[trasendentes.length() - 4];
                trasendentes.getChars(4, trasendentes.length(), auxArray, 0);
                num2 = Float.parseFloat(String.copyValueOf(auxArray));

                resultado = (float) Math.log10((double) num2);

                txvOperar.setText(String.valueOf(resultado));
            }

        }catch(IndexOutOfBoundsException error)
        {
            Log.d("Resultado","Solo hace operaciones binarias");
        }
        catch (NumberFormatException error)
        {
            Log.d("Resultado","Error en el formato");
        }


    }

}
