package com.example.paulo.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulo.tcc.recursos.erros_de_cadastro;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.sql.Time;
import java.util.Date;

public class Activity_visto extends AppCompatActivity {
    private EditText rua_edit;
    private EditText bairro_edit;
    private EditText cidade_edit;
    private EditText     horario_edit;
    private EditText    date_edit;
    private Button   confirma_button;
    private String Nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__visto);
        rua_edit = (EditText) findViewById(R.id.edit_Rua);
        bairro_edit = (EditText) findViewById(R.id.edit_bairro_visto);
        cidade_edit = (EditText) findViewById(R.id.edit_cidade_visto);
        horario_edit = (EditText) findViewById(R.id.hora);
        date_edit = (EditText) findViewById(R.id.data);
        confirma_button= (Button) findViewById(R.id.button_Confirma_visto);
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        Nome=nome;
        confirma_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gravarinformacao(null);
            }
        });
    }
    private void gravarinformacao(View v){
        //criando objeto usuario
        ParseObject animal= new ParseObject("Animal");
        animal.put("Rua",rua_edit.getText().toString());
        animal.put("horario",horario_edit.getText().toString());
        animal.put("Bairro",bairro_edit.getText().toString());
        animal.put("cidade",cidade_edit.getText().toString());
        animal.put("Data",date_edit.getText().toString());
        animal.put("tipo","visto");
        animal.put("id",Nome);

        //salvando dados
        animal.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {//dados salvos
                    Toast.makeText(Activity_visto.this,getString(R.string.dados_salvo) , Toast.LENGTH_LONG).show();
                    Telaprincipal(null);
                } else {//erro ao salva
                    erros_de_cadastro messagem_erro = new erros_de_cadastro();
                    String erro = messagem_erro.getErro(e.getCode());
                    Toast.makeText(Activity_visto.this, erro, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void Telaprincipal(View v) {
        Intent intent = new Intent(Activity_visto.this,activity_principal.class);
        startActivity(intent);
        finish();
    }

    public void vazio_bairrovisto(View view) {bairro_edit.setText("");}
    public void vazio_ruavisto(View view) {rua_edit.setText("");}
    public void vazio_cidadevisto(View view) {cidade_edit.setText("");}
    public void vazio_horavisto(View view) {horario_edit.setText("");}
    public void vazio_datavisto(View view) {date_edit.setText("");}
}
