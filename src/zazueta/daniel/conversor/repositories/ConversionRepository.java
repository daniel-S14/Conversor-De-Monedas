package zazueta.daniel.conversor.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zazueta.daniel.conversor.models.Conversion;
import zazueta.daniel.conversor.util.ConfigLoader;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionRepository {

    public Conversion obtenerConversion(String base_code, String target_code, double amount) {

        ConfigLoader configLoader = new ConfigLoader();
        String apiKey = configLoader.getProperty("API_KEY");

        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" +
                base_code + "/" + target_code + "/" + amount;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Conversion conversion = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            conversion = gson.fromJson(json, Conversion.class);

        } catch (NumberFormatException e) {
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la direccion.");
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return conversion;

    }

}
