package com.example.paulo.tcc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.paulo.tcc.adapter.TabsAdapter;
import com.example.paulo.tcc.fragments.HomeFragment;
import com.example.paulo.tcc.recursos.SlidingTabLayout;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;


import bolts.Task;


public class activity_principal extends AppCompatActivity {

    private Toolbar toolbar_superio;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //configuração Toolbar
        toolbar_superio = (Toolbar) findViewById(R.id.tolkbar);
        toolbar_superio.setLogo(R.mipmap.icon_logo_oficial_2);
        setSupportActionBar(toolbar_superio);
        //Configuração viewPager
        slidingTabLayout =(SlidingTabLayout) findViewById(R.id.Sliding_Tab_Main);
        viewPager = (ViewPager) findViewById(R.id.View_pager);
        //configuração do adapter
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(tabsAdapter);
        slidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.text_tab_view);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.cinzaescuro));
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sair:
                deslogar();
                return true;
            case R.id.action_settings:
                return true;
            case  R.id.action_termodeuso:
                teladetermodeuso();
                return true;
            case R.id.action_camera:
                compartilha();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    //compartilha foto
    private void compartilha(){
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //testando retorno de dados

        if (requestCode==1 && resultCode==RESULT_OK && data!=null){

            Uri localimagem = data.getData();
            try {
                Bitmap images = MediaStore.Images.Media.getBitmap( getContentResolver(), localimagem);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                images.compress(Bitmap.CompressFormat.PNG,75,stream);
                byte[] byteArray =stream.toByteArray();

                SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmaaaahhmmss");
                String nomeimagem = dateFormat.format(new Date());
                nome=nomeimagem;
                ParseFile arquivospase = new ParseFile(nomeimagem+"images.png",byteArray);
                ParseObject parseObject = new ParseObject("Images");
                parseObject.put("username",ParseUser.getCurrentUser().getUsername());
                parseObject.put ("images", arquivospase);
                parseObject.saveInBackground( new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Toast.makeText(getApplicationContext(), "Sua imagem nao pode ser compartilhada", Toast.LENGTH_LONG).show();
                        } else {
                            TabsAdapter adapter= (TabsAdapter)viewPager.getAdapter();
                            HomeFragment homeFragmentnovo= (HomeFragment) adapter.getFragment(0);
                            homeFragmentnovo.atualizarpostagem();
                            //Toast.makeText(getApplicationContext(), "Sua imagem foi compartilhada", Toast.LENGTH_LONG).show();
                        }


                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Tela_TipodeCompartilhamento();

    }

    private void Tela_TipodeCompartilhamento(){
        
        Intent intent = new Intent(this, Activity_TipoCompartilhamento.class);
        intent.putExtra("nome", nome);
        startActivity(intent);
        finish();

    }

    //deslogar usuario
    private void deslogar(){
        ParseUser.logOut();
        Intent intent = new Intent(this,activity_login.class);
        startActivity(intent);
    }

    //chama tela de termo de uso
    private void teladetermodeuso() {
        Intent intent = new Intent(activity_principal.this,Activity_termodeuso.class);
        startActivity(intent);
        finish();
    }
}
