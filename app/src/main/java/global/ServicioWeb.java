package global;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import modelo.Cliente;


/**
 * Created by carlos.morales on 24/09/2016.
 */
public  class ServicioWeb {

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    private static final String LOG_TAG = "Error";
    public final static  String NAMESPACE = "http://tempuri.org/";
    public final static  String URL="http://192.168.0.12:61731/WebService1.asmx";
    public final static String METHOD_NAME = "";
    public final static  String SOAP_ACTION = "http://tempuri.org/";

public void serviceConexionGet ()
{
    NetworkOperationAsyncTask getTarea = new  NetworkOperationAsyncTask();
    getTarea.execute();
}

    public void serviceConexionPut ()
    {
        webServicesPut pruebaPut =  new webServicesPut();

        pruebaPut.execute();
    }

//public void isConectado ()
//{
//    ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//
//    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//
//    if(networkInfo != null && networkInfo.isConnected()) {
//        // Operaciones http
//    } else {
//        // Mostrar errores
//    }
//}

    public void conexion() throws IOException {
        URL url = new URL("http://monstalkers.hostoi.com/data/get_all_comments.php");
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            // Acciones a realizar con el flujo de datos
        }
            finally{
                urlConnection.disconnect();
            }



    }


private class NetworkOperationAsyncTask extends AsyncTask<Void, Void, String> {

    private Cliente[] listaClientes;

    @Override
    protected String doInBackground(Void... params) {
        boolean resul = true;

        final String NAMESPACE = "http://tempuri.org/";
        final String URL="http://192.168.0.13:61731/WebService1.asmx";
        final String METHOD_NAME = "getCliente";
        final String SOAP_ACTION = "http://tempuri.org/getCliente";

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        SoapSerializationEnvelope envelope =
                new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE transporte = new HttpTransportSE(URL);

        try
        {
            transporte.call(SOAP_ACTION, envelope);

            SoapObject resSoap =(SoapObject)envelope.getResponse();

            listaClientes = new Cliente[resSoap.getPropertyCount()];



                Cliente cli = new Cliente();
//                cli.idCliente = Integer.parseInt(resSoap.getProperty(0).toString());
//                cli.primerNombre = resSoap.getProperty(1).toString();
//                cli.segundoNombre = resSoap.getProperty(2).toString();
//            cli.primerApellido = resSoap.getProperty(3).toString();
//            cli.segundoApellido = resSoap.getProperty(4).toString();
//            cli.cuenta = resSoap.getProperty(5).toString();
//            cli.contrasena = resSoap.getProperty(6).toString();
//            cli.nombreCompleto= resSoap.getProperty(7).toString();
//            cli.correo= resSoap.getProperty(8).toString();




        }
        catch (Exception e)
        {
            resul = false;
        }



        return  "";
    }
}

    private class webServicesPut extends AsyncTask<String,Integer,Boolean> {

        private Cliente[] listaClientes;

        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            final String NAMESPACE = "http://tempuri.org/";
            final String URL="http://192.168.0.13:61731/WebService1.asmx";
            final String METHOD_NAME = "setCliente";
            final String SOAP_ACTION = "http://tempuri.org/setCliente";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            Cliente cli = new Cliente();
//            cli.idCliente = 123;
//            cli.primerNombre = "monica";
//            cli.segundoNombre= "maria";
//            cli.primerApellido = "morales";
//            cli.segundoApellido = "prueba";
//            cli.cuenta = "moni";
//            cli.contrasena = "pass";
//            cli.nombreCompleto = "maria sala";
//            cli.correo = "sflaldls@prueba";

            PropertyInfo pi = new PropertyInfo();
            pi.setName("cliente");
            pi.setValue(cli);
            pi.setType(cli.getClass());

            request.addProperty(pi);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

          envelope.addMapping(NAMESPACE, "Cliente", cli.getClass());

          HttpTransportSE transporte = new HttpTransportSE(URL);

            try
            {
                transporte.call(SOAP_ACTION, envelope);

                SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
                String res = resultado_xml.toString();

                if(!res.equals("1"))
                    resul = false;
            }
            catch (Exception e)
            {
                resul = false;
            }

            return resul;
        }

        protected void onPostExecute(Boolean result) {
            String resultado ;
            if (result)
                resultado ="Insertado OK";
            else
            resultado ="Error!";
        }
    }

}