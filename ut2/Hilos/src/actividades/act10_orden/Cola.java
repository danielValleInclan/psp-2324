package actividades.act10_orden;

public class Cola {
    private int numero;
    private boolean disponible = false;
    private boolean turno = true;

    public synchronized int get(int n){
        while (!disponible ||  !turno){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\t" + numero + "=> Consumidor: " + n + ", consume: " + numero);
        disponible = false;
        if (turno){
            turno = false;
        } else {
            turno = true;
        }
        notifyAll();
        return numero;
    }
    public synchronized void put(int valor, int n){
        while (disponible || !turno){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(valor + "=> Productor: " + n + ", produce: " + valor);
        numero = valor;
        disponible = true;
        notifyAll();
    }
}
