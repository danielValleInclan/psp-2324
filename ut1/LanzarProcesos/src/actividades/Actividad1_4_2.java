package actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad1_4_2 {
    public static void main(String[] args) throws IOException {
        String javaFilePath = "actividades.Actividad1_4_2";
        String name = "Daniel";
        //Process process = Runtime.getRuntime().exec("java -cp " + javaFilePath + " " + name);
        Process process = new ProcessBuilder("java " + javaFilePath + " " + name).start();
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
