package actividades.act1r;

public class Main {
    public static void main(String[] args) {
        new Thread(new HiloTac()).start();
        new Thread(new HiloTic()).start();
    }
}
