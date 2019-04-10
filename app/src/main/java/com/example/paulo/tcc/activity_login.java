package com.example.paulo.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulo.tcc.recursos.erros_de_cadastro;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class activity_login extends AppCompatActivity {
    private EditText edit_usuario;
    private EditText edit_senha;
    private Button   button_entra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_usuario = (EditText) findViewById(R.id.edit_usuario);
        edit_senha   = (EditText) findViewById(R.id.edit_senha);
        button_entra = (Button)   findViewById(R.id.button_entra);
        //validar_cliente_logado(null);


        button_entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = edit_usuario.getText().toString();
                String senha   = edit_senha.getText().toString();

                verificar_dados( usuario, senha);

            }
        });
    }
    //verificar se senha e usuarios digitados estao corretos
    private void verificar_dados(String usuario , String senha){
        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {//dados salvos
                    Toast.makeText(activity_login.this,getString(R.string.Login_realizado) , Toast.LENGTH_LONG).show();
                    Telaprincipal(null);
                } else {//erro ao salva
                    erros_de_cadastro messagem_erro = new erros_de_cadastro();
                    String erro = messagem_erro.getErro(e.getCode());
                    Toast.makeText(activity_login.this, erro, Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    //abri tela cadastro e fecha a tela de login
    public void Teladecadastro(View v){
        Intent intent = new Intent(activity_login.this,activity_cadastro_usuario.class);
        startActivity(intent);
        finish();

    //abri tela recupera senha e fecha a tela de login
    }public void Teladerecuperasenha(View v){
        Intent intent = new Intent(activity_login.this,Activity_recuperasenha.class);
        startActivity(intent);
        finish();

    }
    //verificar se usuario ta logado
    private void validar_cliente_logado(View v){
        if(ParseUser.getCurrentUser()!=null){
            Telaprincipal(null);


        }
    }
    //abri tela principal e fecha a tela de login
    public void Telaprincipal(View v) {
        Intent intent = new Intent(activity_login.this,activity_principal.class);
        startActivity(intent);
        finish();
    }

    public void vazio_senha(View view){
        edit_senha.setText("");
    }

    public void vazio_usuario(View view) {
        edit_usuario.setText("");
    }
}
