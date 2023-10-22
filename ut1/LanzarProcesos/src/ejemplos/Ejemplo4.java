package ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo4 {
    public static void main(String[] args) throws IOException {
        File directory = new File("out/production/LanzarProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "ejemplos.EjemploLectura");
        pb.directory(directory);
        Process p = pb.start();
        InputStream is = p.getInputStream();

        OutputStream os = p.getOutputStream();
        os.write("Hola Manuel\n".getBytes());
        os.flush();

        int c;
        while ((c = is.read()) != -1){
            System.out.print((char) c);
        }
        is.close();
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
