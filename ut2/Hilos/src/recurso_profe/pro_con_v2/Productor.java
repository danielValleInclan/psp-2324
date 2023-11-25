package recurso_profe.pro_con_v2;

public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el n�mero

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) { }
        }
        System.out.println("Fin productor...");
    }
}
