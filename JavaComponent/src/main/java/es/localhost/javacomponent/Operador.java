package es.localhost.javacomponent;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
public class Operador {
    public Operador(){}
    public String post(String url,String consulta){
        String retornador = "";
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);

            StringEntity requestBody = new StringEntity(consulta);
            request.setEntity(requestBody);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {retornador = httpClient.execute(request).toString(); }
            finally {response = null; httpClient.close();return  retornador;}

        }catch(Exception e){return "Ocurrio un error";}
    }
    public String put(String url,String consulta){
        String retornador = "";
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut request = new HttpPut(url);

            StringEntity requestBody = new StringEntity(consulta);
            request.setEntity(requestBody);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {retornador = httpClient.execute(request).toString();}
            finally {response = null;httpClient.close();return  retornador;}

        }catch(Exception e){return "Ocurrio un error";}
    }
}
