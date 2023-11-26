package compruebatuaprendizaje.act11;

public class Main {
    public static void main(String[] args) {
        Arbitro arbitro = new Arbitro(2);
        Jugador j1 = new Jugador(1, arbitro);
        Jugador j2 = new Jugador(2, arbitro);
        j1.start();
        j2.start();
    }
}
