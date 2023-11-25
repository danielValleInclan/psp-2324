package compruebatuaprendizaje.act10;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(cola.get());
        }
    }

}
