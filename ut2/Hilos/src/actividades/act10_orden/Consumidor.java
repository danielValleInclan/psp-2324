package actividades.act10_orden;

public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola cola, int n) {
        this.cola = cola;
        this.n = n;
    }

    @Override
    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(n);
            //System.out.println("\t" +i + "=> Consumidor: " + n + ", consume: " + valor);
        }
    }
}
