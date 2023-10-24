package actividades.act10_6;

import java.io.*;

public class Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {
        String ficheroEntrada;
        ficheroEntrada = args[0];
        String classpathUtilidades;
        classpathUtilidades = args[1];
        String classpathProcesadorFichero;
        classpathProcesadorFichero = args[2];
        String[] vocales = { "A", "E", "I", "O", "U" };
        String classPath;
        classPath = classpathProcesadorFichero + ":" + classpathUtilidades;
        System.out.println("Usando classpath:" + classPath);

        for (int i=0;i<args.length;i++)
        {
            System.out.println(args[i]);

        }
        /* Se lanzan los procesos*/
        for (int i = 0; i < vocales.length; i++) {
            String fichErrores = "Errores_" + vocales[i] + ".txt";
            ProcessBuilder pb;
            pb = new ProcessBuilder("java", "-cp", classPath, "UT1.ContadorVocales.ProcesadorFichero", ficheroEntrada, vocales[i], vocales[i] + ".txt");
            //Si hay algún error, almacenarlo en un fichero
            pb.redirectError(new File(fichErrores));
            Process p = pb.start();

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
    /* La recogida de resultados se deja como
		 * ejercicio al lector. ;) */
    }
}
