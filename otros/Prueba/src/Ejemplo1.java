import java.io.InputStream;

public class Ejemplo1 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String command = "gedit";
        Process p = null;
        try {
            p = r.exec(command);
        } catch (Exception e){
            System.out.println("Error en: " + command);
            e.printStackTrace();
        }
    }
}
