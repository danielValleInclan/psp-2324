package ejemplos.comu_y_sinc;

public class CompartirInf1 {
    public static void main(String[] args) {
        Contador contador = new Contador(100);
        HiloA hiloA = new HiloA("HiloA", contador);
        HiloB hiloB = new HiloB("HiloB", contador);
        hiloA.start();
        hiloB.start();
    }
}
