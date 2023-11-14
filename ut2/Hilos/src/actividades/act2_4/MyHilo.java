package actividades.act2_4;

import java.util.Scanner;

public class MyHilo extends Thread{
    private int cont = 0;
    private boolean stopHilo = false;
    private SolicitaSuspender suspender = new SolicitaSuspender();

    public void Suspender() {suspender.set(true);}

    public void Reanuda() {suspender.set(false);}

    public void stopHilo(){
        stopHilo = true;
    }

    public int getCont(){
        return cont;
    }

    public void run(){
        try {
            while (!stopHilo){ // haya trabajo por hacer
                sleep(1000);
                cont++;
                suspender.esperandoParaReanudar(); // comprobar
            }
            System.out.println("Fin del bucle");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        MyHilo h = new MyHilo();
        h.start();
        while (h.isAlive()){
            System.out.println("Salida hilo: " + h.getCont());
            System.out.println("Introduce la cadena (Suspender S / Reanudar R) (* salir)");
            op = sc.next().toLowerCase();
            if (op.equals("s")){
                h.Suspender();
            } else if (op.equals("r")) {
                h.Reanuda();
            } else if (op.equals("*")) {
                h.stopHilo();
                break;
            }
        }
    }
}
