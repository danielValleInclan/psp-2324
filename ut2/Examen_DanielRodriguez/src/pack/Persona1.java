package pack;

/**
 * La clase persona1 extiende la clase Thread.
 * Solo puede realizar ingresos
 */

public class Persona1 extends  Thread{ // esta persona solo puede ingresar
    private CuentaBancaria cuentaBancaria; // La cuenta bancaria es el objeto compartido por todas las personas
    private String nombre; // el nombre sirve como id

    /**
     * Constructro de persona1
     * @param nombre
     * @param cuentaBancaria
     */
    public Persona1(String nombre, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Este método realiza 3 operaciones de ingresos.
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int ingreso = ((int) (Math.random()*500+1)); // se genera un ingreso aleatorio
            cuentaBancaria.ingreso(nombre, ingreso); // se realiza el ingreso
        }
    }
}
