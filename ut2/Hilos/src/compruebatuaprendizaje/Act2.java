package compruebatuaprendizaje;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Act2 implements Runnable{

    private String cadena;

    public Act2(String cadena){
        super();
        this.cadena = cadena;
    }

    @Override
    public void run() {
        try {
            sleep(currentThread().getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hola mundo: " + cadena + " " + currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Act2("Hilo " + i)).start();
        }
    }
}
