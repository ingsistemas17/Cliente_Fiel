package org.clientefiel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import controlador.CtrEmpresa;
import global.ServicioWeb;
import modelo.Cliente;
import modelo.Empresa;

/**
 * Created by carlos.morales on 24/09/2016.
 */
public class ListEmpresas extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_empresas);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        webServicesPut autenticaPut =  new webServicesPut();

        autenticaPut.execute("");


    }


    /**
     * carga las empresas que tiene asociado el cliente
     * @param result
     */
    private void CargaEmpresas(Empresa[] result) {

        ListView lista;
        AdapterItemEmpresa adaptador;

        lista = (ListView)findViewById(R.id.listView);

        adaptador = new AdapterItemEmpresa(this, CtrEmpresa.getInstance(result).getLeads());

        lista.setAdapter(adaptador);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private class webServicesPut extends AsyncTask<String,Integer,Empresa[]> {

        private String nameSpace ;
        private String url;
        private String method_Name ;
        private String soap_Action ;


        @Override
        protected void onPreExecute() {
            nameSpace= ServicioWeb.NAMESPACE;
            method_Name = "getMisEmpresas";
            soap_Action = ServicioWeb.SOAP_ACTION+method_Name;
            url = ServicioWeb.URL;

        }

        protected Empresa[] doInBackground(String... params) {

            Empresa[] resul = null;



            SoapObject request = new SoapObject(nameSpace, method_Name);


//            PropertyInfo pi = new PropertyInfo();
//            pi.setName("cliente");
//            pi.setValue(cli);
//            pi.setType(cli.getClass());
//
//            request.addProperty(pi);

            request.addProperty("idCliente", 1);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

          //  envelope.addMapping(nameSpace, "Cliente", cli.getClass());

            HttpTransportSE transporte = new HttpTransportSE(url);

            try
            {
                transporte.call(soap_Action, envelope);


                SoapObject resSoap =(SoapObject)envelope.getResponse();

                Empresa[] res= new Empresa[resSoap.getPropertyCount()];

                for (int i = 0; i < res.length; i++)
                {
                    SoapObject ic = (SoapObject)resSoap.getProperty(i);

                    Empresa emp = new Empresa();
                    emp.setIdEmpresa(Integer.parseInt(ic.getProperty(0).toString()));
                    emp.setNombreEmpresa(ic.getProperty(2).toString());
                    emp.setEstadoEmpresa(ic.getProperty(6).toString());

                    res[i] = emp;
                }

                //if(res.length != 0)
                    resul = res;
            }
            catch (Exception e)
            {
                resul = null;
            }

            return resul;
        }

        protected void onPostExecute(Empresa[] result) {

            if (result.equals(null)) {
                Toast.makeText(ListEmpresas.this, "Ocurrió un error con el servicio", Toast.LENGTH_LONG).show();
            }
            else
                CargaEmpresas(result);
        }
    }


}
