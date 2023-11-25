package compruebatuaprendizaje.act10;

import java.io.*;

public class Productor extends Thread {
    private Cola cola;

    private File file;

    public Productor(Cola cola, File file) {
        this.cola = cola;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String s;
            while (!((s = bf.readLine()) == null)){
                cola.put(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
