package actividades.act1;

public class Main {
    public static void main(String[] args) {
        HiloTac hiloTac = new HiloTac();
        HiloTic hiloTic = new HiloTic();
        hiloTac.start();
        hiloTic.start();
    }
}
