package compruebatuaprendizaje.act10;

import java.io.File;

public class Act10_ca {
    public static void main(String[] args) {
        File file = new File("ca_10.txt");
        Cola cola = new Cola();
        Productor p = new Productor(cola, file);
        Consumidor c = new Consumidor(cola);
        p.start();
        c.start();
    }
}
