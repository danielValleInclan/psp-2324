package actividades.nproc_ncon;

public class Cola {
    private int numero;
    private int turnos;
    private int auxTurno = 1;
    private boolean disponible = false;

    public synchronized void get(int n){
        while (!disponible || auxTurno !=n){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (auxTurno == turnos) auxTurno = 1;
        else auxTurno++;
        disponible = false;
        System.out.println("\t" + auxTurno + "=> Consumidor: " + n + ", consume: " + numero);
        notifyAll();
    }
    public synchronized void put(int valor, int n){
        while (disponible || auxTurno != n){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        numero = valor;
        disponible = true;
        System.out.println(auxTurno + "=> Productor: " + n + ", produce: " + valor);
        notifyAll();
    }

    public void setTurnos(int turnos){
        this.turnos = turnos;
    }
}
