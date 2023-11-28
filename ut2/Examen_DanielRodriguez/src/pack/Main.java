package pack;

/**
 * Clase main, donde se instancias todas las demas clases
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria(700, 300); // se inicializa la cuenta
        // se inicializan las persnas
        Persona1 jose = new Persona1("jose", cuentaBancaria);
        Persona2 maria = new Persona2("maria", cuentaBancaria);
        // se ejecutan ambos hilos
        jose.start();
        maria.start();
    }
}
