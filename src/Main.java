import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String apiKey = ArmadoUrl.ArmadodeURLyAPI();

        try {
            // Obtener todas las tasas de cambio (asumiendo que USD es la base por defecto)
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");

            int codigoRespuesta = request.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(new InputStreamReader(request.getInputStream()), JsonObject.class);
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

                // Mostrar monedas disponibles
                System.out.println("Monedas disponibles:");
                for (String codigoMoneda : conversionRates.keySet()) {
                    System.out.print(codigoMoneda + ", ");
                }
                System.out.println(); // Salto de línea para mejor legibilidad
            } else {
                System.err.println("Error al obtener las tasas de cambio. Código de respuesta: " + codigoRespuesta);
                return; // Salir si no se pueden obtener las tasas
            }
        } catch (Exception e) {
            e.printStackTrace();
            return; // Salir si hay un error en la solicitud
        }

        // Solicitar al usuario las monedas base y objetivo
        System.out.print("Ingrese el código de la moneda base (por ejemplo, USD): ");
        String codigoMonedaBase = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el código de la moneda objetivo: ");
        String codigoMonedaObjetivo = scanner.nextLine().toUpperCase();

        // Realizar una nueva solicitud a la API con la moneda base especificada
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + codigoMonedaBase + "/" + codigoMonedaObjetivo;
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");

            int codigoRespuesta = request.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(new InputStreamReader(request.getInputStream()), JsonObject.class);

                // Obtener la tasa de cambio directamente del objeto JSON
                double tasaCambio = jsonObject.get("conversion_rate").getAsDouble();

                System.out.println("Tasa de cambio de " + codigoMonedaBase + " a " + codigoMonedaObjetivo + ": " + tasaCambio);
            } else {
                System.err.println("Error al obtener la tasa de cambio. Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
