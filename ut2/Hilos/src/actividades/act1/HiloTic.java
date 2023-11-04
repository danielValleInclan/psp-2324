package actividades.act1;

public class HiloTic extends Thread {
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
