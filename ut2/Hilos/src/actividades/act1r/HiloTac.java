package actividades.act1r;

import static java.lang.Thread.sleep;

public class HiloTac implements Runnable{
    public void run(){
        while (true){
            System.out.println("TAC");
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
