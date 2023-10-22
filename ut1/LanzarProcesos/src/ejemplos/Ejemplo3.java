package ejemplos;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) throws IOException {
        File directory = new File("out/production/LanzarProcesos/");
        ProcessBuilder pb = new ProcessBuilder("java", "ejemplos.Ejemplo2");
        pb.directory(directory);
        System.out.printf("Directorio de trabajo: %s", pb.directory());
        System.out.println();
        Process p = pb.start();
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1){
                System.out.print((char) c);
            }
            is.close();
            int exitCode = p.waitFor();
            System.out.println("El proceso ha terminado con código de salida: " + exitCode);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
