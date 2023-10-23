package actividades.act10_3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        File directory = new File("out/production/LanzarProcesos");

        for (int i = 0; i < 5; i++) {
            String inicio = String.valueOf((int) (Math.random() * 10));
            String fin = String.valueOf((int) (Math.random() * 10 + 10));
            ProcessBuilder pb = new ProcessBuilder("java", "actividades.act10_3.Sumador", inicio, fin).directory(directory);
            File out = new File("out" + i + ".txt");
            File err = new File("error" + i + ".txt");
            pb.redirectOutput(out);
            pb.redirectError(err);
            pb.start().waitFor();
        }
    }
}
