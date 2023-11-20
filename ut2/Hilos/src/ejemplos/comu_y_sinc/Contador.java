package ejemplos.comu_y_sinc;

public class Contador {
    private int c;

    public Contador(int c){this.c = c;}

    public void incrementar(){c++;}
    public void decrementar(){c--;}

    public int valor (){return this.c;}

}
