package com.example.paulo.tcc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.paulo.tcc.R;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class UsuariosAdapter extends ArrayAdapter<ParseUser> {

    private Context context;
    private ArrayList<ParseUser> usuarios;

    public UsuariosAdapter(Context c, ArrayList<ParseUser> objects) {
        super(c, 0, objects);
        this.context =c;
        this.usuarios= objects;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        View view =convertView;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.lista_postagem,parent,false);
        }

        TextView username = (TextView) view.findViewById(R.id.list_usuarios);
        ParseUser parseUser = usuarios.get(position);
        username.setText(parseUser.getUsername());
        return view;
    }
}
