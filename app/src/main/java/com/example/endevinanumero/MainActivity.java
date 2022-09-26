package com.example.endevinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
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
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText variable = (EditText)findViewById(R.id.editTextNumber);
                number = Integer.parseInt(variable.getText().toString());
                TextView viewIntents = (TextView)findViewById(R.id.textView);
                Context context = getApplicationContext();
                CharSequence text="";
                int duration = Toast.LENGTH_SHORT;
                if (number<random){
                   text = "El numero es mes gran que aquest";
                    contador++;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(number>random){
                    text = "El numero es mes petit que aquest";
                    contador++;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(number==random){
                    text = "Molt be, aquest es el numero.\nIntentos: "+contador;
                    random = (int) (Math.random()*10-1);
                    StartGameDialogFragment dialog = new StartGameDialogFragment(contador);
                    //dialog.show(getSupportFragmentManager(),"Felicitats");
                    contador=0;
                    viewIntents.setText("Intents: 0");
                }
                viewIntents.setText("Intents: "+contador);

            }
        });

    }
    public class StartGameDialogFragment extends DialogFragment {
        int intents;
        public StartGameDialogFragment(int intents){
            this.intents=intents;

        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            String ok = "OK";
            String dialog_win_game = "Felicitats, has guanyat en "+intents+" intents";
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.dialog_win_game)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}