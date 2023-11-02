package ejemplos;

public class UsaHilo {
    public static void main(String[] args) {
        HiloSimple hiloSimple = new HiloSimple();
        hiloSimple.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Fuera del hilo...");
        }
    }
}
