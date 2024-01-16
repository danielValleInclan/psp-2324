package ejemplos.adivinaNumero;

class ObjetoCompartido {
    private int numero, ganador; // número a adivinar y ganador
    private boolean acabo; // se puede o no jugar

    ObjetoCompartido(int numero){
        this.numero = numero;
        this.acabo = false;
    }

    boolean haTerminado() {return acabo;}
    int getGanador() {return ganador;}

    synchronized String nuevaJugada(int jugador, int suNumero) {
        String cad = "";
        if (!haTerminado()){
            if (suNumero > numero) {
                cad = "Número demasiado grande";
            } else if (suNumero < numero) {
                cad = "Número demasiado pequeño";
            } else {
                cad = "Jugador " + jugador + " gana, adivinó el número: " + numero;
                acabo = true;
                ganador = jugador;
            }
        } else {
            cad = "Jugador " + ganador + " adivinó el número: " + numero;
        }
        return cad;
    }

}
