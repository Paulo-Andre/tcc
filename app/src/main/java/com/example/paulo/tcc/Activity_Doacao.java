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
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class Activity_Doacao extends AppCompatActivity {
    private EditText raca_edit;
    private EditText idade_edit;
    private EditText bairro_edit;
    private EditText cidade_edit;
    private EditText estado_edit;
    private EditText telefone_edit;
    private EditText observacao_edit;
    private Button   confirma_button;
    private String   Nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__doacao);
        raca_edit = (EditText)findViewById(R.id.edit_Raca);
        idade_edit = (EditText)findViewById(R.id.edit_idade);
        bairro_edit = (EditText)findViewById(R.id.edit_bairro);
        cidade_edit = (EditText)findViewById(R.id.edit_cidade);
        estado_edit = (EditText)findViewById(R.id.edit_estado);
        telefone_edit = (EditText)findViewById(R.id.edit_telefone);
        observacao_edit = (EditText)findViewById(R.id.edit_observacao);
        confirma_button = (Button)findViewById(R.id.button_Confirma);
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
        animal.put("Raca",raca_edit.getText().toString());
        animal.put("Idade",idade_edit.getText().toString());
        animal.put("Bairro",bairro_edit.getText().toString());
        animal.put("cidade",cidade_edit.getText().toString());
        animal.put("estado",estado_edit.getText().toString());
        animal.put("telefone",telefone_edit.getText().toString());
        animal.put("observacao",observacao_edit.getText().toString());
        animal.put("tipo","doar");
        animal.put("id",Nome);

        //salvando dados
        animal.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {//dados salvos
                    Toast.makeText(Activity_Doacao.this,getString(R.string.dados_salvo) , Toast.LENGTH_LONG).show();
                    Telaprincipal(null);
                } else {//erro ao salva
                    erros_de_cadastro messagem_erro = new erros_de_cadastro();
                    String erro = messagem_erro.getErro(e.getCode());
                    Toast.makeText(Activity_Doacao.this, erro, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void Telaprincipal(View v) {
        Intent intent = new Intent(Activity_Doacao.this,activity_principal.class);
        startActivity(intent);
        finish();
    }
    public void vazio_racaedit(View view) {raca_edit.setText(""); }
    public void vazio_idadeedit(View view) {
        idade_edit.setText("");
    }
    public void vazio_bairroedit(View view) { bairro_edit.setText(""); }
    public void vazio_cidadeedit(View view) {cidade_edit.setText(""); }
    public void vazio_estadoedit(View view) {
        estado_edit.setText("");
    }
    public void Vazio_telefoneedit(View view) {telefone_edit.setText(""); }
    public void vazio_observacaoedit(View view) {observacao_edit.setText("");}

}
