package compruebatuaprendizaje;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Act3 extends Thread {

    private File file;

    public Act3(File file){
        this.file = file;
    }
    public void run(){
        long initialTime = System.currentTimeMillis();
        int cont = 0;
        try (FileReader fr = new FileReader(file);) {
            int c = 0;
            while ((c = fr.read()) != -1){
                if (!Character.isWhitespace(c)){
                    cont++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Número de caracteres " + cont + " Tiempo consimido: " + (System.currentTimeMillis() - initialTime)
                + " milesimas de segundo");
    }
    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            files.add(new File(args[i]));
        }
        // Obtener array de ficheros
        for (int i = 0; i < files.size(); i++) {
            new Act3(files.get(i)).start();
        }
    }
}
