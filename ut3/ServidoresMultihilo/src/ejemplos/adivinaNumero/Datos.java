package ejemplos.adivinaNumero;

import java.io.Serializable;

class Datos implements Serializable {
    private String cadena; // cadena que se intercambia con el servidor
    private int intentos, identificador;
    private boolean gana, juega;

    Datos(String cadena, int intentos, int identificador) {
        this.cadena = cadena;
        this.intentos = intentos;
        this.identificador = identificador;
        this.gana = false;
        this.juega = true;
    }
    Datos(){
        super();
    }

    String getCadena() {
        return cadena;
    }

    void setCadena(String cadena) {
        this.cadena = cadena;
    }

    int getIntentos() {
        return intentos;
    }

    void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    int getIdentificador() {
        return identificador;
    }

    void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    boolean isGana() {
        return gana;
    }

    void setGana(boolean gana) {
        this.gana = gana;
    }

    boolean isJuega() {
        return juega;
    }

    void setJuega(boolean juega) {
        this.juega = juega;
    }
}
