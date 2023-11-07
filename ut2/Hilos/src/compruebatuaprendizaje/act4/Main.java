package compruebatuaprendizaje.act4;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        LeerFichero leerFichero = new LeerFichero(new File("caAct4-1.txt"));
        System.out.println(leerFichero.numCaracteres());
    }
}
