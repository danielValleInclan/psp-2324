package actividades;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Act_3_1 {
    public static void main(String[] args) {
        try {
            pruebaMetodos(InetAddress.getByName(args[0]));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
    private static void pruebaMetodos(InetAddress dir){
        System.out.println("\t Método getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\t Método getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        //Usamos métodos de la clase
        System.out.println("\t Método getHostName(): " + dir.getHostName());
        System.out.println("\t Método getHostAddress(): " + dir.getHostAddress());
        System.out.println("\t Método toString(): " + dir.toString());
        System.out.println("\t Método getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}
