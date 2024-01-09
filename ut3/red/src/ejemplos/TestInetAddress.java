package ejemplos;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("=========================================================");
        System.out.println("SALIDA PARA LOCALHOST");
        try {
            //LocalHost
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            //URL www.google.es
            System.out.println("=========================================================");
            System.out.println("SALIDA PARA URL");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            //Array de tipo InetAddress con todas las direcciones IP
            //asignadas a google.es
            System.out.println("DIRECCIONES IP PARA " + dir.getHostAddress());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t" + direcciones[i].toString());
            }
            System.out.println("=========================================================");
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
