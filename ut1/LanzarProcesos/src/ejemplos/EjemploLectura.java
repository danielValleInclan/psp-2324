package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLectura {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String texto;
        try {
            System.out.println("Introduce una cadena ...");
            texto = br.readLine();
            System.out.println("cadena escrita: " + texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
