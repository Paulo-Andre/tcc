package com.example.paulo.tcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class activity_dados_postagem extends AppCompatActivity {

    private EditText raca_edit;
    private EditText idade_edit;
    private EditText cidade_edit;
    private EditText bairro_edit;
    private EditText telefone_edit;
    private EditText estado_edit;
    private EditText observacao_edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_postagem);

        raca_edit = (EditText) findViewById(R.id.edit_Raca_dados);
        idade_edit =(EditText) findViewById(R.id.edit_idade_dados);
        cidade_edit =(EditText) findViewById(R.id.edit_cidade_dados);
        bairro_edit =(EditText) findViewById(R.id.edit_bairro_dados);
        telefone_edit =(EditText) findViewById(R.id.edit_telefone_dados);
        estado_edit =(EditText) findViewById(R.id.edit_estado_dados);
        observacao_edit =(EditText) findViewById(R.id.edit_observacao_dados);
    }
}
