package compruebatuaprendizaje;

import java.io.*;

public class Actividad1_5 {
    public static void main(String[] args) throws IOException {
        File directory = new File("out/production/LanzarProcesos/");
        ProcessBuilder pb = new ProcessBuilder("java", "actividades.noExiste");
        pb.directory(directory);
        System.out.printf("Directorio de trabajo: %s", pb.directory());
        System.out.println();
        Process p = pb.start();
        try {
            InputStream is = p.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println("Error >" + line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
