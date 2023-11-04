package ejemplos.primerhilor;

public class UsaPrimerHiloR {
    public static void main(String[] args) {
        PrimerHiloR hilo1 = new PrimerHiloR();
        new Thread(hilo1).start();

        PrimerHiloR hilo2 = new PrimerHiloR();
        new Thread(hilo2).start();

        new Thread(new PrimerHiloR()).start();
    }
}
