package ejemplos;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "ejemplos.Ejemplo2");
        //processBuilder.directory(new File("ut1/LanzarProcesos/out/production/LanzarProcesos/ejemplos"));
        Process process = processBuilder.start();
        try {
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String linea;
            while ((linea = reader.readLine()) != null) {
                // Imprimir cada línea del resultado de Ejemplo2
                System.out.println("Salida de Ejemplo2: " + linea);
            }
            int exitCode = process.waitFor();
            System.out.println("Ejemplo2 ha terminado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
