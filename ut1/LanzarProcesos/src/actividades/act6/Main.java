package actividades.act6;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "actividades.act6.Sumador", "1", "2");
        File directory = new File("out/production/LanzarProcesos");
        pb.directory(directory);
        Process p = pb.start();
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String linea;
        while ((linea = br.readLine()) != null){
            System.out.print(linea);
        }
        br.close();
    }
}
