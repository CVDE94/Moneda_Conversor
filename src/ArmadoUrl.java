import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArmadoUrl {
    public static String ArmadodeURLyAPI(){
        // Leer API_KEY desde config.properties
        String apiKey = null;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            apiKey = prop.getProperty("API_KEY");
        } catch (IOException ex) {
            System.err.println("Error al leer config.properties: " + ex.getMessage());
            return null; // Salir si no se puede leer la API key
        }

        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("Error: API_KEY no encontrada o vacía en config.properties.");
            return null; // Salir si la API key es inválida
        }
        return apiKey;
    }

}
