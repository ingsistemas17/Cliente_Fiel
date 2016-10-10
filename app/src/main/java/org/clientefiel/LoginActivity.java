package org.clientefiel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import global.ServicioWeb;

/**
 * Created by carlos.morales on 23/09/2016.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    /**
     * lanza la ventana para que el usuario se registre
     * @param view
     */
    public void btn_onClick_Event (View view){
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);

    }



    /**
     * lanza la ventana para que el usuario se registre
     * @param view
     */
    public void btnLogin_Event (View view){
        ServicioWeb prueba = new ServicioWeb();
        prueba.serviceConexionGet();
        prueba.serviceConexionPut();



    }
}
