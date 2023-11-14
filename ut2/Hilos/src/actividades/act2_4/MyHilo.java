package actividades.act2_4;

import java.util.Scanner;

public class MyHilo extends Thread{
    private int cont = 0;
    private boolean comprobacion = false;
    private SolicitaSuspender suspender = new SolicitaSuspender();

    public void Suspender() {suspender.set(true);}

    public void Reanuda() {suspender.set(false);}

    public void stopHilo(){
        comprobacion = true;
    }

    public int getCont(){
        return cont;
    }

    public void run(){
        try {
            while (!comprobacion){ // haya trabajo por hacer
                System.out.println(cont);
                cont++;
                sleep(1000);
                suspender.esperandoParaReanudar(); // comprobar
            }
            System.out.println("Fin del bucle");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean b = false;
        String op;
        MyHilo h = new MyHilo();
        while (!b){
            System.out.println("Introduce la cadena (S/R) (* salir)");
            op = sc.next();
            if (op.equals("s")){
                h.Suspender();
            } else if (op.equals("r")) {
                h.Reanuda();
            } else if (op.equals("*")) {
                b = true;
                h.stopHilo();
            }
        }
    }
}
