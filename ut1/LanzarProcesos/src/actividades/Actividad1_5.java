package actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad1_5 {
    public static void main(String[] args) throws IOException {
        Process process = new ProcessBuilder("psr").start();
        try {
            InputStream inputStream = process.getInputStream();
            InputStream inputStream1 = process.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String linea;
            while ((linea = reader.readLine()) != null) {
                // Imprimir cada línea del resultado (nombre de archivo o directorio)
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
