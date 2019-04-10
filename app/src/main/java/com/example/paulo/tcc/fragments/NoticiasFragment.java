package com.example.paulo.tcc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.paulo.tcc.R;
import com.example.paulo.tcc.adapter.NoticiasAdapter;
import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {

    private ListView listView;
    private ArrayList<ParseObject> postagem;
    private ArrayAdapter<ParseObject>adapter;


    public NoticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_noticias, container, false);
       postagem = new ArrayList<>();

       listView = (ListView) view.findViewById(R.id.postagem_listnoticias);

       adapter = new NoticiasAdapter(getActivity(),postagem);
       listView.setAdapter(adapter);

       return view;
    }

}
