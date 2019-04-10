package com.example.paulo.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_TipoCompartilhamento extends AppCompatActivity {
    public String Nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tipo_compartilhamento);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        Nome=nome;
    }

    public void doacao(View view) {
        Intent intent = new Intent(Activity_TipoCompartilhamento.this,Activity_Doacao.class);
        intent.putExtra("nome", Nome);
        startActivity(intent);
        finish();
    }

    public void perdido(View view) {
        Intent intent = new Intent(Activity_TipoCompartilhamento.this,Activity_Perdido.class);
        intent.putExtra("nome", Nome);
        startActivity(intent);
        finish();
    }

    public void visto(View view) {
        Intent intent = new Intent(Activity_TipoCompartilhamento.this,Activity_visto.class);
        intent.putExtra("nome", Nome);
        startActivity(intent);
        finish();
    }
}
