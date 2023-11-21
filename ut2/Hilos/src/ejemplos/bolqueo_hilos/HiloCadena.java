package ejemplos.bolqueo_hilos;

public class HiloCadena extends Thread{
    private ObjetoCompartido objetoCompartido;
    private String cad;

    public HiloCadena(ObjetoCompartido objetoCompartido, String cad){
        this.objetoCompartido = objetoCompartido;
        this.cad = cad;
    }

    @Override
    public void run() {
        synchronized (objetoCompartido){
            for (int i = 0; i < 10; i++) {
                objetoCompartido.PintaCadena(cad);
                objetoCompartido.notify();
                try {
                    objetoCompartido.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            objetoCompartido.notify();
        }
        System.out.println("\n" + cad + " finalizado");
    }
}
