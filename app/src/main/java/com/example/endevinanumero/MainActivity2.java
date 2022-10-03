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


        int count=1;
        for (Usuaris u: usuarisRecord2){
            recordsUs=recordsUs+"\n"+count+". "+u.getNom();
            recordsNum=recordsNum+"\n"+u.getIntents();
            count++;
        }
        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableLayout tbl=(TableLayout) findViewById(R.id.tableLayoutId);

            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);

            //setting the text
            txt1.setText(recordsUs);
            txt2.setText(recordsNum);
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);

            row.setLayoutParams(params2);
            tbl.addView(row);

        button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent2);
            }
        });
    }
}