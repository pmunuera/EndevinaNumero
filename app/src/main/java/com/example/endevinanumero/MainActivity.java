package com.example.endevinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText variable = (EditText)findViewById(R.id.editTextNumber);
                number = Integer.parseInt(variable.getText().toString());
                Context context = getApplicationContext();
                CharSequence text="";
                if (number<random){
                   text = "El numero es mes gran que aquest";
                    contador++;
                }
                else if(number>random){
                    text = "El numero es mes petit que aquest";
                    contador++;
                }
                else if(number==random){
                    text = "Muy bien, aquest es el numero.\nIntentos: "+contador;
                    contador=0;
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                toast.show();

            }
        });

    }
}