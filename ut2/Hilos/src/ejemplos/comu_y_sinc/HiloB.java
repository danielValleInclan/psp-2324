package ejemplos.comu_y_sinc;

public class HiloB extends Thread{
    private Contador contador;
    public HiloB (String n, Contador contador){
        setName(n);
        this.contador = contador;
    }

    public void run(){
        synchronized (contador){
            for (int i = 0; i < 300; i++) {
                contador.decrementar();
                //sleep(100);
            }
            System.out.println(getName() + ": Contador vale " + contador.valor());
        }
    }
}
