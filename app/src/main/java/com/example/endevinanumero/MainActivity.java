package com.example.endevinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int contador=0;
    int random = (int) (Math.random()*10-1);
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final String[] scrollText = {""};

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                EditText variable = (EditText)findViewById(R.id.editTextNumber);
                number = Integer.parseInt(variable.getText().toString());
                TextView viewIntents = (TextView)findViewById(R.id.textView);
                TextView textScrollView = (TextView)findViewById(R.id.textView4);
                Context context = getApplicationContext();
                CharSequence text="";
                int duration = Toast.LENGTH_SHORT;
                if (number<random){
                   text = "El numero es mes gran que aquest";
                    contador++;
                    scrollText[0] = scrollText[0] +"\nNumero: "+number;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(number>random){
                    text = "El numero es mes petit que aquest";
                    contador++;
                    scrollText[0] = scrollText[0] +"\nNumero: "+number;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(number==random){
                    text = "Molt be, aquest es el numero.\nIntentos: "+contador;
                    random = (int) (Math.random()*10-1);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                    alertDialogBuilder.setTitle("Felicitats");

                    alertDialogBuilder
                            .setMessage("Has encertat, era el numero "+random+". Vols guardar?")
                            .setCancelable(false)
                            .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {

                                    //Si la respuesta es afirmativa aquí agrega tu función a realizar.
                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            }).create().show();
                    contador=0;
                    viewIntents.setText("Intents: 0");
                    scrollText[0]="";
                    textScrollView.setText(scrollText[0]);
                }
                textScrollView.setText(scrollText[0]);
                viewIntents.setText("Intents: "+contador);
                variable.setText("");
            }
        });

    }

}