package actividades.nproc_ncon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int turnos = 0;

        Scanner sc = new Scanner(System.in);
        Cola cola = new Cola();
        System.out.print("Número de productores y consumidores: ");
        turnos = sc.nextInt();

        cola.setTurnos(turnos);
        for (int i = 1; i <= turnos;i++) {
            new Productor(cola, i).start();
            new Consumidor(cola, i).start();
        }
    }
}
