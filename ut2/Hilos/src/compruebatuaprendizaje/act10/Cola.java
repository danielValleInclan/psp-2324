package compruebatuaprendizaje.act10;

public class Cola {
    private String cad;
    private boolean disponible = false;

    public synchronized String get(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false;
        notifyAll();
        return cad;
    }
    public synchronized void put(String cad){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.cad = cad;
        disponible = true;
        notifyAll();
    }
}
