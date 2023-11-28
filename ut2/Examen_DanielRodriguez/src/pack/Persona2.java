package pack;

public class Persona2 extends Thread{ // esta persona solo puede retirar

    private CuentaBancaria cuentaBancaria; // La cuenta bancaria es el objeto compartido por todas las personas
    private String nombre; // el nombre sirve como id

    public Persona2(String nombre, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int reintegro = ((int) (Math.random()*500+1)); // se genera un reintegro aleatorio
            cuentaBancaria.reintegro(nombre, reintegro); // se realiza el reintegro
        }
    }
}
