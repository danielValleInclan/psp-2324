package actividades.cta.act5;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe lo que sea:   ");
        String frase = sc.nextLine();
        ProcessBuilder pb = new ProcessBuilder("java", "actividades.cta.act5.Repetidor", frase);
        File directory = new File("out/production/LanzarProcesos/");
        pb.directory(directory);
        Process p = pb.start();
        try {
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            int exitCode = p.waitFor();
            System.out.println("Código de salida: " + exitCode);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
