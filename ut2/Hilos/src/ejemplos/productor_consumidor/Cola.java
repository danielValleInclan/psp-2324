package ejemplos.productor_consumidor;

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
        System.out.println(numero + "=> Consumidor: " + n + ", consume: " + numero);
        notify();
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
        notify();
    }
}
