package actividades.pro_com_vers3;

public class Cola {
    private int numero;
    private int turno = 1;
    private boolean disponible = false;

    public synchronized void get(int n){
        while (!disponible || turno!=n){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (turno == 1) turno = 2;
        else turno = 1;
        disponible = false;
        System.out.println("\t" +turno + "=> Consumidor: " + n + ", consume: " + numero);
        notifyAll();
    }
    public synchronized void put(int valor, int n){
        while (disponible || turno != n){
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
