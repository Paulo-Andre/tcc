package com.example.paulo.tcc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulo.tcc.R;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter<ParseObject> {
    private  Context context;
    private ArrayList<ParseObject> postagem;


    public HomeAdapter(Context c, ArrayList<ParseObject> objects){
        super(c,0,objects);
        this.context=c;
        this.postagem=objects;
    }


    @Override
    public View getView(int position , View convertView,ViewGroup parent){

        View view =convertView;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.lista_postagem,parent,false);
        }
        if (postagem.size()>0){
            ImageView imagepostagem =(ImageView) view.findViewById(R.id.image_list_postagem);
            //TextView usuriopostagem=(TextView)   view.findViewById(R.id.usuariopostagem);
            ParseObject parseObject = postagem.get(position);
            //parseObject.getParseFile("");
            Picasso.with(context)
                    .load(parseObject.getParseFile("images").getUrl())
                    .fit()
                    .into(imagepostagem);
        }
        return view;
    }
}
