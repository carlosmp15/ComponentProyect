package es.localhost.javacomponent;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Operador {
    /**
     * @param url Ruta HTTP para hacer operación de insercción
     * @param consulta Consulta en formato JSON para insertar los datos
     * @return Mensaje de insercción de la casa
     */
    public String post(String url, String consulta) {
        String retornador = "";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);

            StringEntity requestBody = new StringEntity(consulta);
            request.setEntity(requestBody);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {
                response = httpClient.execute(request);
                retornador = EntityUtils.toString(response.getEntity());
            } finally {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
                httpClient.close();
                return retornador;
            }

        } catch (Exception e) {
            return "Ocurrió un error";
        }
    }

    /**
     * @param url Ruta HTTP para hacer operación de obtener todos los datos
     * @return Datos de la base de datos en formato JSON
     */
    public String get(String url) {
        String retornador = "";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {
                response = httpClient.execute(request);
                retornador = EntityUtils.toString(response.getEntity());
            } finally {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
                httpClient.close();
                return retornador;
            }

        } catch (Exception e) {
            return "Ocurrió un error";
        }
    }

    /**
     * @param url Ruta HTTP para hacer operación de borrado a partir del id casa
     * @return Mensaje de eliminación de la casa
     */
    public String delete(String url) {
        StringBuilder retornador = new StringBuilder();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(url);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {
                response = httpClient.execute(request);
                int statusCode = response.getStatusLine().getStatusCode();
                retornador.append("Status Code: ").append(statusCode).append("\n");

                String responseBody = EntityUtils.toString(response.getEntity());
                retornador.append("Response: ").append(responseBody).append("\n");
            } finally {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
                httpClient.close();
                return retornador.toString();
            }
        } catch (Exception e) {
            return "Ocurrió un error";
        }
    }

    /**
     * @param url Ruta HTTP para hacer
     * operación de actualización a partir del id casa
     * @return Mensaje de actualización datos
     */
    public String put(String url, String consulta) {
        String retornador = "";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut request = new HttpPut(url);

            StringEntity requestBody = new StringEntity(consulta);
            request.setEntity(requestBody);
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;
            try {
                response = httpClient.execute(request);
                retornador = EntityUtils.toString(response.getEntity());
            } finally {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
                httpClient.close();
                return retornador;
            }

        } catch (Exception e) {
            return "Ocurrió un error";
        }
    }
}
