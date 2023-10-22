package ejemplos;

import java.io.*;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException {

        Process process = new ProcessBuilder("ls", "-la").start();
        try {
            InputStream inputStream = process.getInputStream();
            int c;
            while ((c = inputStream.read()) != -1){
                System.out.print((char) c);
            }
            inputStream.close();
            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("El proceso ha terminado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
