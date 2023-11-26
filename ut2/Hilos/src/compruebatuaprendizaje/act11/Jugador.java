package compruebatuaprendizaje.act11;

public class Jugador extends Thread {
    Arbitro arbitro;
    int id;

    public Jugador(int id, Arbitro arbitro){
        this.arbitro = arbitro;
        this.id = id;
    }

    @Override
    public void run() {
        while (!arbitro.isFinJuego()){
            int num = 1+ (int) (10*Math.random());
            arbitro.realizarJugada(id, num);
        }
    }
}
