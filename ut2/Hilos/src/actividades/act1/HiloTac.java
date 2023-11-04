package actividades.act1;

public class HiloTac extends Thread{
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
