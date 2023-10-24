package actividades.act10_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcesadorFichero {

    // Dado un fichero de entrada y una letra contamos cuantas veces aparece dicha letra
    // y dejamos el recuento en un fichero de salida

    /**Comentario:
     *
     * @param fichEntrada  Fichero con el texto a procesar
     * @param letra   Vocal de la que se va a hacer el recuento.
     * @param fichSalida   Fichero con el total de fepeticiones de la vocal
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void hacerRecuento(String fichEntrada, String letra, String fichSalida) throws FileNotFoundException, IOException {
        // Flujo al fichero de entrada, es decir, al fichero donde contar la vocal
        BufferedReader br;
        br = UtilidadesFicheros.getBufferedReader(fichEntrada);

        // Flujo al fichero de salida, es decir, donde se escribe el recuento de la vocal
        PrintWriter pw;
        pw = UtilidadesFicheros.getPrintWriter(fichSalida);

        // Procesamos el fichero de entrada, línea a línea, y vamos sumando las letras que sean la vocal recigida
        // como argumento. Convetimos a mayúsculas para que lea tanto las mayúculas como las minúsculas de una vocal.
        String lineaLeida;
        lineaLeida = br.readLine().toUpperCase();
        int totalVocales = 0;
        //Mientras no queden líneas....
        while (lineaLeida != null) {
            //...recorremos la linea...
            for (int i = 0; i < lineaLeida.length(); i++) {
                char letraLeida = lineaLeida.charAt(i);
                char letraPasada = letra.charAt(0);
                // incrementamos el contador
                if (letraLeida == letraPasada) {
                    totalVocales++;
                }
            //Fin del if
            }
            //Fin del for
            // Pasamos a la siguiente linea
            lineaLeida = br.readLine();
        }
        //Escribimos el total de vocales
        //en el fichero de salida
        pw.println(totalVocales);
        pw.flush();
        //Y cerramos los ficheros
        pw.close();
        br.close();
    //Fin del método hacerRecuento
    }

    /**
	 * Dado un fichero pasado como argumento, contará cuantas
	 * apariciones hay de una cierta vocal (pasada como argumento)
	 * y dejará la cantidad en otro fichero (también pasado como
	 * argumento)
	 * @throws IOException 
	 * @throws FileNotFoundException  */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Recoge los argumentos
        String nombreFicheroEntrada = args[0];
        String letra = args[1];
        String nombreFicheroResultado = args[2];

        // cuenta la frecuencia de la letra
        hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);
    //Fin del main
    }
}
