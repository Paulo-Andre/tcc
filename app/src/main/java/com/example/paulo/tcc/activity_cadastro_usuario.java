package com.example.paulo.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.example.paulo.tcc.recursos.erros_de_cadastro;

import static com.example.paulo.tcc.R.*;

public class activity_cadastro_usuario extends AppCompatActivity {

    private EditText usuariocadastro;
    private EditText emailcadastro;
    private EditText senhacadastro;
    private Button   Botaocadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_cadastro_usuario);

        usuariocadastro = (EditText) findViewById(id.usuarioText);
        emailcadastro = (EditText) findViewById(id.emailText);
        senhacadastro = (EditText) findViewById(id.senhaText);
        Botaocadastrar = (Button) findViewById(id.cadastroUsuario);

        Botaocadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarCadastrodeusuario(null);
            }
        });
    }
    private void realizarCadastrodeusuario(View v){
        //criando objeto usuario
        ParseUser usuario = new ParseUser();
        usuario.setUsername(usuariocadastro.getText().toString());
        usuario.setEmail(emailcadastro.getText().toString());
        usuario.setPassword(senhacadastro.getText().toString());

        //salvando dados
        usuario.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {//dados salvos
                    Toast.makeText(activity_cadastro_usuario.this,getString(string.cadastro_realizado) , Toast.LENGTH_LONG).show();
                    Teladelogin(null);
                } else {//erro ao salva
                    erros_de_cadastro messagem_erro = new erros_de_cadastro();
                    String erro = messagem_erro.getErro(e.getCode());
                    Toast.makeText(activity_cadastro_usuario.this, erro, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void Teladelogin(View v){
        Intent intent = new Intent(activity_cadastro_usuario.this,activity_login.class);
        startActivity(intent);
        finish();

    }
    public void Teladetermodeuso(View v){
        Intent intent = new Intent(activity_cadastro_usuario.this,Activity_termodeuso.class);
        startActivity(intent);
        finish();

    }
    public void vazio_usuariocadastro(View view) {
        usuariocadastro.setText("");
    }
    public void vazio_senhacadastro(View view) {
        senhacadastro.setText("");
    }
    public void vazio_emailcadastro(View view) {
        emailcadastro.setText("");
    }

}

