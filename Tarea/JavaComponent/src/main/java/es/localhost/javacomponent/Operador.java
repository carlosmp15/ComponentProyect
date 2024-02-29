package es.localhost.javacomponent;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
    public String get(String url){
        try{
            String retornador = "";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                retornador = result.toString();
                retornador = retornador.replace("},","}\n");
            } finally {response.close();return  retornador;}
        }catch(Exception e){return "Ocurrio un error";}
    }
    public String delete(String url){
        try{
            String retornador = "";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(url);

            try {retornador = httpClient.execute(request).toString();}
            finally {httpClient.close();return retornador;}

        }catch(Exception e){return "Ocurrio un error";}
    }
}
