package actividades.act10;

public class Cola {
    private int numero;
    private boolean disponible = false;

    public synchronized void get(int n){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false;
        System.out.println("\t" +numero + "=> Consumidor: " + n + ", consume: " + numero);
        notifyAll();
    }
    public synchronized void put(int valor, int n){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        numero = valor;
        disponible = true;
        System.out.println(numero + "=> Productor: " + n + ", produce: " + valor);
        notifyAll();
    }
}
