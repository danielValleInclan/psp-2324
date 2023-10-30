package compruebatuaprendizaje;

import java.io.*;

public class Actividad1_7 {
    public static void main(String[] args) throws IOException {

        String comando = "actividad1_7";
        ProcessBuilder pb = new ProcessBuilder("bash", comando);
        File direcotorio = new File(".");
        pb.directory(direcotorio);
        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.write("Pepito \n".getBytes());
        os.flush();

        /*
        ProcessBuilder pb = new ProcessBuilder("bash");
        pb.redirectInput(new File("actividad1_7.sh"));
        pb.redirectOutput(new File("resultActividad1_7.txt"));
        pb.redirectError(new File("errorActividad1_7"));
        Process p = pb.start();
         */
    }
}
