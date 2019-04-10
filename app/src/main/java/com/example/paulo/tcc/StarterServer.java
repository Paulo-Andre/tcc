/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.example.paulo.tcc;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class StarterServer extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Habilite armazenamento local.
    Parse.enableLocalDatastore(this);

    // Codigo de configuração do App
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId(getString(R.string.back4app_app_id))
            .clientKey(getString(R.string.back4app_client_key))
            .server(getString(R.string.back4app_server_url))
    .build()
    );
/*

      // Teste de configuração do App
      ParseObject pontuacao = new ParseObject("Pontuacao");
      pontuacao.put("pontos", 100);
      pontuacao.saveInBackground(new SaveCallback() {
          public void done(ParseException e) {
              if (e == null) {
                  Log.i("TesteExecucao", "Salvo com sucesso!!!");
              } else {
                  Log.i("TesteExecucao", "Falha ao salvar os dados!!!");
              }
          }
      });

*/
      ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    //Optionally enable public read access.
    defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
