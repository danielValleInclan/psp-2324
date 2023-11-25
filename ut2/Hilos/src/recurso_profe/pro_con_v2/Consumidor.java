package recurso_profe.pro_con_v2;

public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i<5 ; i++) {
            // System.out.println("\t"+i+"=>"+" Consumidor: "+n+ ", consume "+ cola.get());
            cola.get(n); // Comunicamos el número de consumidor
        }
    }//
}
