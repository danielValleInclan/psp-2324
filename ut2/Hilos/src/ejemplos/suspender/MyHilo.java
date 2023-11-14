package ejemplos.suspender;

public class MyHilo extends Thread{
    private SolicitaSuspender suspender = new SolicitaSuspender();

    public void Suspender() {suspender.set(true);}

    public void Reanuda() {suspender.set(false);}

    public void run(){
        try {
            while (true){ // haya trabajo por hacer
                suspender.esperandoParaReanudar(); // comprobar
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
