package global;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;



/**
 * Created by carlos.morales on 24/09/2016.
 */
public class ServicioWeb {

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;

   public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }

    //METODO PARA ESTABLECER CONEXIÓN
    public String makeServiceCall(String url, int method, List<String> params) {
        //try {
            //HTTP CLIENT
          //  DefaultHttpClient httpClient = new DefaultHttpClient();
          HttpEntity httpEntity = null;
           HttpResponse httpResponse = null;

         /*   // AÑADIMOS PARAMETROS AL METODO POST
            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);
                // adding post params
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }
                httpResponse = httpClient.execute(httpPost);
            } else if (method == GET) {
                // AÑADIMOS PARAMETROS AL METODO GET
                if (params != null) {
                    String paramString = URLEncodedUtils.format(params, "utf-8");
                    url += "?" + paramString;
                }
                //METODO GET
                HttpGet httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);
            //EXCEPCIONES
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        //DEVOLVEMOS RESPUESTA
        return response;

    }


}
