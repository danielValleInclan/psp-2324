package ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Ejemplo5 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/LanzarProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "ejemplos.EjemploLectura");

        pb.directory(directorio);

        Process p=pb.start();
        OutputStream os = p.getOutputStream();
        os.write("Hola Daniel\n".getBytes());
        os.flush();
    }
}
