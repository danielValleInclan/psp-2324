package compruebatuaprendizaje.act7;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File directory = new File("out/production/LanzarProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "compruebatuaprendizaje.act7.Leer");
        pb.directory(directory);
        Process p = pb.start();
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        OutputStream os = p.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        System.out.println("Escribe algo para enviar a Leer: ");
        String input; // Lee desde la entrada estándar

        while (!(input = br.readLine()) .equals("*")){
            writer.write(input); // Escribe en el proceso secundario
            writer.newLine(); // Añade un salto de línea al final
            writer.flush(); // Asegúrate de que los datos se envíen
        }

        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        int exitVal = p.waitFor();
        System.out.println("Codigo de salida: " + exitVal);
    }
}
