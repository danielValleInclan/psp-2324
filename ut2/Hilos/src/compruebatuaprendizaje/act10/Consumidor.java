package compruebatuaprendizaje.act10;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }
    @Override
    public void run() {
        String s;
        while ((s = cola.get()) != null){
            System.out.println(s);
        }
        System.out.println("\nFin consumidor");
    }
}
