import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException {

        Process process = new ProcessBuilder("ls", "-l").start();
        try {
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String linea;
            while ((linea = reader.readLine()) != null) {
                // Imprimir cada línea del resultado (nombre de archivo o directorio)
                System.out.println(linea);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("El proceso ha terminado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
