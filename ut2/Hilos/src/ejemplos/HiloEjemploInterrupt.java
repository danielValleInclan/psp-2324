package ejemplos;

public class HiloEjemploInterrupt extends Thread{
    public void run(){
        try {
            while (!isInterrupted()){
                System.out.println("En el hilo");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un erro");
        }
        System.out.println("Fin del Hilo");
    }

    public void interrumpir(){
        interrupt();
    }

    public static void main(String[] args) {
        HiloEjemploInterrupt h = new HiloEjemploInterrupt();
        h.start();
        for (int i = 0; i < 1000000; i++) {}
        h.interrumpir();
    }
}
