package ejemplos.join;

public class HiloJoin extends Thread{
    private int n;
    public HiloJoin(String nom, int n){
        super(nom);
        this.n = n;
    }

    public void run(){
        for (int i = 0; i < n; i++) {
            System.out.println(getName() + ": "+i);
            try {
                sleep(1000);
            } catch (InterruptedException ignore) {}
        }
        System.out.println("Fin del bucle "+getName());
    }
}
