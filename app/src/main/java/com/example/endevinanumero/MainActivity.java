package com.example.endevinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    int contador=0;
    int random = (int) (Math.random()*100-1);
    int number = 0;
    public static ArrayList<Usuaris> usuarisRecord = new ArrayList<Usuaris>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final Button button3 = findViewById(R.id.button3);
        final String[] scrollText = {""};


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                EditText variable = (EditText)findViewById(R.id.editTextNumber);
                number = Integer.parseInt(variable.getText().toString());
                TextView viewIntents = (TextView)findViewById(R.id.textView);
                TextView textScrollView = (TextView)findViewById(R.id.textView4);
                textScrollView.setMovementMethod(new ScrollingMovementMethod());
                Context context = getApplicationContext();
                CharSequence text="";
                if (number<random){
                    contador++;
                    scrollText[0] = scrollText[0] +"\nEl numero es mes gran que: "+number;

                }
                else if(number>random){
                    contador++;
                    scrollText[0] = scrollText[0] +"\nEl numero es mes petit que: "+number;

                }
                else if(number==random){
                    text = "Molt be, aquest es el numero.\nIntentos: "+contador;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle("Felicitats");
                    alertDialogBuilder
                            .setMessage("Has encertat, era el numero "+random+". Vols guardar?")
                            .setCancelable(false)
                            .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    //Si la respuesta es afirmativa aquí agrega tu función a realizar.
                                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                    alert.setTitle("Guardar");
                                    alert.setMessage("Introdueix el nom de l'usuari");
                                    final EditText input = new EditText(MainActivity.this);
                                    alert.setView(input);
                                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            Editable value = input.getText();
                                            Usuaris usuari = new Usuaris(input.getText(),contador);
                                            usuarisRecord.add(usuari);
                                            Collections.sort(usuarisRecord, new Comparator<Usuaris>() {
                                                @Override
                                                public int compare(Usuaris u, Usuaris u1) {
                                                    return new Integer(u.getIntents()).compareTo(new Integer(u1.getIntents()));
                                                }
                                            });

                                            random = (int) (Math.random()*100-1);
                                            contador=0;
                                            viewIntents.setText("Intents: 0");
                                            scrollText[0]="";
                                            textScrollView.setText(scrollText[0]);
                                            // Do something with value!
                                        }
                                    });
                                    alert.create().show();
                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                    random = (int) (Math.random()*100-1);
                                    contador=0;
                                    viewIntents.setText("Intents: 0");
                                    scrollText[0]="";
                                    textScrollView.setText(scrollText[0]);
                                }
                            }).create().show();
                }
                textScrollView.setText(scrollText[0]);
                viewIntents.setText("Intents: "+contador);
                variable.setText("");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("usuarisRecord",usuarisRecord);
                startActivity(intent);
            }
        });

    }

}