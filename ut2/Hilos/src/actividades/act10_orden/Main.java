package actividades.act10_orden;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Productor p2 = new Productor(cola, 2);
        Consumidor c = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);
        p.start();
        c.start();
        p2.start();
        c2.start();
    }
}
