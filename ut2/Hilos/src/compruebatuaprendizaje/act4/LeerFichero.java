package compruebatuaprendizaje.act4;

import java.io.*;

public class LeerFichero {
    private File file;

    public LeerFichero(File file) {
        this.file = file;
    }

    public int numCaracteres(){
        int num = 0;
        try (FileReader fr = new FileReader(file)) {
            char c = 0;
            while (c != -1){
                c = (char) fr.read();
                num++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return num;
    }
}
