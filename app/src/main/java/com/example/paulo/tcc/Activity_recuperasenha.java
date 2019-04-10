package com.example.paulo.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_recuperasenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperasenha);
    }
    public void Teladelogin(View v){
        Intent intent = new Intent(Activity_recuperasenha.this,activity_login.class);
        startActivity(intent);

    }
}
