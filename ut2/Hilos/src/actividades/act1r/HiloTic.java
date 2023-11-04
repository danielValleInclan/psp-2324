package actividades.act1r;

import static java.lang.Thread.sleep;

public class HiloTic implements Runnable {
    public void run(){
        while (true){
            System.out.println("TIC");
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
