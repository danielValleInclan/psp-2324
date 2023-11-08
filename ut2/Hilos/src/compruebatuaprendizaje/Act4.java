package compruebatuaprendizaje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Act4 extends Thread{
    private File file;

    public Act4(File file){
        this.file = file;
    }
    public void run(){
        long initialTime = System.currentTimeMillis();
        int cont = 0;
        try (BufferedReader br = new BufferedReader (new FileReader(file));) {
            String s;
            while ((s = br.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(s);
                int numTokens = tokens.countTokens();
                cont += numTokens;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Número de palabras " + cont + " Tiempo consimido: " + (System.currentTimeMillis() - initialTime)
                + " milesimas de segundo");
    }

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            files.add(new File(args[i]));
        }
        // Obtener array de ficheros
        for (int i = 0; i < files.size(); i++) {
            new Act4(files.get(i)).start();
        }
    }
}
