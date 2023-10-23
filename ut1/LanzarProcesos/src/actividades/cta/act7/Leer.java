package actividades.cta.act7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder result = new StringBuilder();
        System.out.println("Escribe algo (Ingresa * para terminar): ");
        while ((input = br.readLine()) != null){
            if (input.contains("*")) break;
            result.append("\n").append(input);
        }
        System.out.println("Has escrito: " + input);
    }
}
