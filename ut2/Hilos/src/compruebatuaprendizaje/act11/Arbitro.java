package compruebatuaprendizaje.act11;

public class Arbitro {
    private int num;
    private int totalJugadores;
    private int turno;
    private boolean finJuego = false;

    public Arbitro(int jugadores){
        num = 1+ (int) (10*Math.random());
        System.out.println("Número ha adivinar : " + num);
        this.totalJugadores = jugadores;
        turno = 1;
    }

    public int getTurno(){
        return this.turno;
    }

    public boolean isFinJuego(){
        return this.finJuego;
    }

    public synchronized void realizarJugada(int idJugador, int jugada){
        while (turno != idJugador && !finJuego){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!finJuego){
            if (turno == totalJugadores){
                turno = 1;
            } else {
                turno++;
            }
            System.out.println("Jugador " + idJugador + " dice: " + jugada);
            if (jugada == num){
                System.out.println("Jugador " + idJugador + " gana, adivinó el número!!!");
                finJuego = true;
            } else {
                System.out.println("\tLe toca ha jugador " + turno);
            }
            notifyAll();
        }
    }


}
