import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) throws IOException {
        Process process = new ProcessBuilder("gedit").start();
    }
}
