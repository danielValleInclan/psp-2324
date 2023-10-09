import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String command = "ls";
        Process p = null;
        try {
            p = r.exec(command);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
            br.close();
        } catch (Exception e){
            System.out.println("Error en: " + command);
            e.printStackTrace();
        }
        //COMPROBACIÓN DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
