package ejemplos;

public class HiloEjemploDead extends Thread{
    private boolean stopHilo = false;

    public void pararHilo(){
        stopHilo = true;
    }

    public void run(){
        while (!stopHilo){
            System.out.println("En el hilo");
        }
    }

    public static void main(String[] args) {
        HiloEjemploDead h = new HiloEjemploDead();
        h.start();
        for (int i = 0; i < 1000000; i++) {

        }
        h.pararHilo();
    }
}
