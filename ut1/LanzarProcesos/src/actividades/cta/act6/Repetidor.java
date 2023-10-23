package actividades.cta.act6;

public class Repetidor {
    public static void main(String[] args) {
        if (args.length == 0) System.exit(1);
        String frase = args[0];

        for (int i = 0; i < 5; i++) {
            System.out.println(frase);
        }
    }
}
