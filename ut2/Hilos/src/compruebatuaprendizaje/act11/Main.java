package compruebatuaprendizaje.act11;

public class Main {
    public static void main(String[] args) {
        Arbitro arbitro = new Arbitro(4);
        Jugador j1 = new Jugador(1, arbitro);
        Jugador j2 = new Jugador(2, arbitro);
        Jugador j3 = new Jugador(3, arbitro);
        Jugador j4 = new Jugador(4, arbitro);
        j1.start();
        j2.start();
        j3.start();
        j4.start();
    }
}
