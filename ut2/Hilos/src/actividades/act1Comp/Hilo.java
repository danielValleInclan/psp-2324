package actividades.act1Comp;

public class Hilo extends Thread {
    private ObjCompartido objCompartido;
    private String cad;

    public Hilo(ObjCompartido objCompartido, String cad){
        this.objCompartido = objCompartido;
        this.cad = cad;
    }

    public void run(){
        synchronized (objCompartido){
            while (true){
                objCompartido.pintarCad(cad);
                objCompartido.notify();
                try {
                    sleep(500);
                    objCompartido.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
