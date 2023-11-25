package actividades.pro_com_vers3;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Productor p2 = new Productor(cola, 2);
        Consumidor c = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);
        p.start();
        p2.start();
        c.start();
        c2.start();
    }
}
