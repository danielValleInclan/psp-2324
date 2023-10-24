package compruebatuaprendizaje.act4;

public class Argumentos {
    public static void main(String[] args) {
        if (args.length < 1){
            System.exit(1);
        }
        try {
            int numero = Integer.parseInt(args[0]);
            if (numero < 0){
                System.exit(3);
            }

        } catch (NumberFormatException e) {
            System.out.println("El primer argumento no es un número entero.");
            System.exit(2);
        }
        System.exit(0);
    }
}
