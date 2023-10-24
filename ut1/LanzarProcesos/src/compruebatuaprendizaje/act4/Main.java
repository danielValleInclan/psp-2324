package compruebatuaprendizaje.act4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        File directory = new File("out/production/LanzarProcesos/actividades/cta/");
        ProcessBuilder pb = new ProcessBuilder("java", "act4.Argumentos", "-4");
        pb.directory(directory);
        Process p = pb.start();
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }

        int exitCode = p.waitFor();
        System.out.println("El proceso ha terminado con código de salida: " + exitCode);
    }
}
