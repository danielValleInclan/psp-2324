package compruebatuaprendizaje.act6;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe lo que sea:   ");
        String frase = sc.nextLine();
        ProcessBuilder pb = new ProcessBuilder("java", "compruebatuaprendizaje.act6.Repetidor", frase);
        File directory = new File("out/production/LanzarProcesos/");
        File oF = new File("outPutAct6.txt");
        pb.directory(directory);
        pb.redirectOutput(oF);
        Process p = pb.start();
    }
}
