package com.example.endevinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    public static ArrayList<Usuaris> usuarisRecord2 = MainActivity.usuarisRecord;;
    private String recordsUs="Nom\n";
    private String recordsNum = "Intents\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Button button2 = findViewById(R.id.button2);
        Intent intent = getIntent();
        TextView viewRecord = (TextView)findViewById(R.id.textView3);
        TextView viewRecordN = (TextView)findViewById(R.id.textView6);
        int count=1;
        for (Usuaris u: usuarisRecord2){
            recordsUs=recordsUs+"\n"+count+". "+u.getNom();
            recordsNum=recordsNum+"\n"+u.getIntents();
            count++;
        }
        viewRecord.setMovementMethod(new ScrollingMovementMethod());
        viewRecordN.setMovementMethod(new ScrollingMovementMethod());
        viewRecord.setText(recordsUs);
        viewRecordN.setText(recordsNum);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}