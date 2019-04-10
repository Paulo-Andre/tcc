package com.example.paulo.tcc.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;


public class NoticiasAdapter extends ArrayAdapter<ParseObject> {

    private  Context context;
    private ArrayList<ParseObject> postagem;

    public NoticiasAdapter( Context c,  ArrayList<ParseObject> objects) {
        super(c,0, objects);
        this.context = c;
        this.postagem = objects;
    }
}
