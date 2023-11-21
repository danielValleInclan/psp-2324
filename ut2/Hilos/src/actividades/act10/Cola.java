package actividades.act10;

public class Cola {
    private int numero;
    private boolean disponible = false;

    public synchronized int get(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false;
        notifyAll();
        return numero;
    }
    public synchronized void put(int valor){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        numero = valor;
        disponible = true;
        notifyAll();
    }
}
