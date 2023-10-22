package actividades.act6;

import java.io.IOException;

public class Sumador {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Se requiere al menos dos argumentos.");
            System.exit(1); // Salir con código 1 indica que hubo un error
        }
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int result = num1 + num2;
            System.out.println("Resultado: " + result);
        } catch (NumberFormatException e){
            System.out.println("Los parámetros deben ser numéricos");
        }
    }
}
