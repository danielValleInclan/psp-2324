package compruebatuaprendizaje.act10;

public class Cola {
    private String cad;
    private boolean disponible = false;
    private boolean finFichero = false;

    public synchronized String get(){
        while (!disponible && !finFichero){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (finFichero) return null;
        else {
            disponible = false;
            notifyAll();
            return cad;
        }
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
        if(cad == null) finFichero = true;
        disponible = true;
        notifyAll();
    }
}
