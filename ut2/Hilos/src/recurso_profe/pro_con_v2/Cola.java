package recurso_profe.pro_con_v2;

public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized int get(int n) {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        System.out.println("Consumidor: " + n + "   consume: " + numero);
        disponible = false;
        notify();
        return numero;
    }


    public synchronized void put(int valor) {
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        numero = valor;
        disponible = true;
        System.out.println("Se produce: " + numero);
        notify();
    }



}
