package com.example.endevinanumero;

import android.text.Editable;

import java.util.Comparator;

public class Usuaris{
    private Editable nom;
    private int intents;

    public Usuaris(Editable nom, int intents){
        this.nom=nom;
        this.intents=intents;
    }
    public Editable getNom(){
        return this.nom;
    }
    public int getIntents(){
        return this.intents;
    }

}
