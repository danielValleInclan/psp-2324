package actividades.act10_6;

import java.io.*;

public class Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {
        //argumentos:
        // Comprobación de los argumentos recibidos.
        for (int i=0;i<args.length;i++)
        {
            System.out.println("Argumento " + i + ":" + args[i]);

        }

        // Recogemos el nombre del fichero a procesar
        String ficheroEntrada;
        ficheroEntrada = args[0];

        // Declaramos un array con las vocales.
        String[] vocales = { "A", "E", "I", "O", "U" };

        // Recogemos el classpath que hemos recibido desde los argumentos del proceso Lanzador.
        String classPath;
        classPath = args[1];
        System.out.println("Usando classpath:" + classPath);


        /* Se lanzan los procesos*/
        for (int i = 0; i < vocales.length; i++) {
            // Creamos el nombre de cada fichero de error; hay uno por cada letra.
            String fichErrores = "Errores_" + vocales[i] + ".txt";

            // Creamos el proceso
            ProcessBuilder pb;
            pb = new ProcessBuilder("java", "-cp", classPath, ".actividades.act10_6.ProcesadorFichero", ficheroEntrada, vocales[i], vocales[i] + ".txt");

            //Si hay algún error en el proceso a crear, lo almacenamos en un fichero. Usamos la técnica de redirigir
            // la salida estándar de errores.
            pb.redirectError(new File(fichErrores));

            // Lanzamos el proceso
            Process p = pb.start();

            // Además de guardar en un fichero de errores se muestran estos en pantalla. Es redundante.
            try {
                System.out.println("ERRORES de "  +  vocales[i]);
                InputStream er = p.getErrorStream();
                BufferedReader brer = new BufferedReader(new InputStreamReader(er));
                String liner = null;
                while ((liner = brer.readLine()) != null)
                    System.out.println("ERROR >" + liner);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        //Fin del for
        }
        /* Esperamos un poco*/
        Thread.sleep(3000);

        // Contamos el total de vocales del texto
        int totalvocales=0;
        for (int i=0; i<vocales.length; i++)
        {
            BufferedReader br;
            br = UtilidadesFicheros.getBufferedReader(vocales[i].toUpperCase() + ".txt");
            // el fichero sólo contiene una línea con el total de vocales de una determinada letra
            totalvocales+= Integer.parseInt(br.readLine());  // convertir la cadena leída en un valor entero.
        }

        System.out.println("El total de vocales del fichero es " + totalvocales);
    }
}
