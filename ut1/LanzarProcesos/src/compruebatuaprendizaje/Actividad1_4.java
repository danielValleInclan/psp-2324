package compruebatuaprendizaje;

public class Actividad1_4 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Se requiere al menos un argumento.");
            System.exit(1); // Salir con código 1 indica que hubo un error
        }

        String nombre = args[0];
        System.out.println("El nombre ingresado es: " + nombre);

        // ... otro código aquí ...

        // Salir con código -1 indicando que el programa finalizó con una condición especial
        System.exit(-1);
    }
}
