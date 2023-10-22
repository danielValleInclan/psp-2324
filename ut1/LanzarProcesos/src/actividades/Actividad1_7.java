package actividades;

import java.io.*;

public class Actividad1_7 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("bash");
        pb.redirectInput(new File("actividad1_7.sh"));
        pb.redirectOutput(new File("resultActividad1_7.txt"));
        pb.redirectError(new File("errorActividad1_7"));
        Process p = pb.start();
    }
}
