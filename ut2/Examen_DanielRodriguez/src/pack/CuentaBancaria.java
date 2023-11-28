package pack;

/**
 * Esta clase contiene información acerca del salario además de contener los métodos para realizar ingresos y reintegros
 */
public class CuentaBancaria {

    private boolean disponible = false; // flag necesaria para la sincronización concurrente
    private int saldoMax; // saldo máximo que se puede alcanzar
    private int saldo; // saldo real de la cuenta

    /**
     *
     * @param saldoMax
     * @param saldo
     *
     * El constructor de la clase.
     *
     */
    public CuentaBancaria(int saldoMax, int saldo) { // en el constructor se indican el saldo actual y maximo
        this.saldoMax = saldoMax;
        this.saldo = saldo;
    }


    /**
     *
     * @param nombre
     * @param reintegro
     *
     * Este método se encarga de realizar reintegros.
     */

    public synchronized void reintegro(String nombre, int reintegro){
        while (!disponible){ // si no puede realizar la operacion se bloquea el hilo
            try {
                wait(); // se bloquea el hilo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        // se muestra la información del reintegro
        System.out.println("REINTEGRO #########################################");
        System.out.println("\tSe va a retirar dinero (SALDO ACTUAL ES: " + saldo + ")");
        System.out.println("\tCantidad a retirar: " + reintegro);
        System.out.println("\tPersona: " + nombre);

        if ((saldo - reintegro) < 0){ // si el saldo resultante es negativo
            System.out.println("\t NO PUEDE RETIRAR. La cantidad " + reintegro + " EL SALDO RESULTANTE ES MENOR QUE 0");
        } else { // si no lo es
            this.saldo -= reintegro; // se decrementa el saldo
            System.out.println("\t SALDO ACTUALIZADO: " + saldo);
        }
        disponible = false; // cambia el valor para que no se vuelva a ejecutar de nuevo la función
        notify(); // una vez acabada la operación se llama al hilo bloqueado
    }


    /**
     *
     * @param nombre
     * @param ingreso
     *
     * Este método es el encargado de realizar los ingresos
     *
     */

    public synchronized void ingreso(String nombre, int ingreso){
        while (disponible){ // si no puede realizar la operacion se bloquea el hilo
            try {
                wait();  // se bloquea el hilo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // se muestra la información del ingreso
        System.out.println("INGRESO #########################################");
        System.out.println("\tSe va a ingresar dinero (SALDO ACTUAL ES: " + saldo + ")");
        System.out.println("\tCantidad a ingresar: " + ingreso);
        System.out.println("\tPersona: " + nombre);

        if ((saldo + ingreso) > saldoMax){ // si el saldo resultante es mayor al límite
            System.out.println("\t NO PUEDE INGRESAR. La cantidad " + ingreso + " SUPERA EL MAXIMO: " + saldoMax);
        } else { // si no lo es
            this.saldo += ingreso; // se incrementa el saldo
            System.out.println("\t SALDO ACTUALIZADO: " + saldo);
        }
        disponible = true; // cambia el valor para que no se vuelva a ejecutar de nuevo la función
        notify(); // una vez acabada la operación se llama al hilo bloqueado
    }
}
