package actividades.act1Comp;

public class Main {
    public static void main(String[] args) {
        ObjCompartido objCompartido = new ObjCompartido();
        Hilo tic = new Hilo(objCompartido, "TIC");
        Hilo tac = new Hilo(objCompartido, "TAC");
        tic.start();
        tac.start();
    }
}
