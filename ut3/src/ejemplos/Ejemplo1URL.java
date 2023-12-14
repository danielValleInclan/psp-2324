package ejemplos;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejemplo1URL {
    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL");
            url = new URL("http://docs.oracle.com");
            visualizar(url);

            System.out.println("Const. para protocolo + URL + direcctorio:");
            url = new URL("http", "docs.oracle.com", "/javase/10");
            visualizar(url);

            System.out.println("Const. para protocolo + URL + puerto + direcctorio:");
            url = new URL("http", "localhost", 8084, "/WebApp/Controlador?accion=modificar");
            visualizar(url);

            System.out.println("Const. para un objeto URL en un contexto:");
            URL urlBase = new URL("http://docs.oracle.com/");
            url = new URL(urlBase, "/javase/10/docs/api/java/net/URL.html");
            visualizar(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void visualizar(URL url){
        System.out.println("\t URL completa: "+ url.toString());
        System.out.println("\t getProtocol(): "+ url.getProtocol());
        System.out.println("\t getHost(): "+ url.getHost());
        System.out.println("\t URL getPort(): "+ url.getPort());
        System.out.println("\t getFile(): "+ url.getFile());
        System.out.println("\t getUserInfo(): "+ url.getUserInfo());
        System.out.println("\t getPath(): "+ url.getPath());
        System.out.println("\t getAuthority(): "+ url.getAuthority());
        System.out.println("\t getQuery: "+ url.getQuery());
        System.out.println("\t getDefautlPort(): "+ url.getDefaultPort());
    }
}
