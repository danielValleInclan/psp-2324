package ejemplos.bolqueo_hilos;

public class Main {
    public static void main(String[] args) {
        ObjetoCompartido objetoCompartido = new ObjetoCompartido();
        HiloCadena a = new HiloCadena(objetoCompartido, "A");
        HiloCadena b = new HiloCadena(objetoCompartido, "B");
        a.start();
        b.start();
    }
}
