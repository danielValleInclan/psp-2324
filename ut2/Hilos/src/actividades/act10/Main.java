package actividades.act10;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);
        p.start();
        c2.start();
        c.start();
    }
}
