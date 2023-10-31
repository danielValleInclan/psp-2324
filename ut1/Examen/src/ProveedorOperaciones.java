import java.io.*;

public class ProveedorOperaciones {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/Examen"); //directorio
        File outF = new File("resultados_operaciones.txt"); //fichero donde se guardan los resultados
        File inF = new File("datos_operaciones.txt"); //fichero donde se recogen las operaciones
        File errF = new File("calculadoraerror.txt"); // fichero de erroes
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "Calculadora").directory(directorio);

        pb.redirectError(errF);

        Process p = pb.start();

        // Lectura del fichero de operaciones y pasar valores
        try {
            FileReader fr = new FileReader(inF);
            BufferedReader br = new BufferedReader(fr);//Flujo de lectura
            OutputStream os = p.getOutputStream(); //Flujo pasar valores
            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
                String[] split = linea.split(","); //Dividimos el string por comas

                //Pasar los valores al proceso
                for (String s : split) {
                    os.write(s.getBytes()); //Pasamos valor
                    os.write("\n".getBytes());

                }
            }

            os.close();
            int exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Escribir el resultado de Process en fichero
        try {
            FileOutputStream fos = new FileOutputStream(outF);
            PrintWriter pw = new PrintWriter(fos);
            InputStream is = p.getInputStream(); // leemos la salida del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea); //Muestra por pantalla
                pw.write(linea); // Se escribe en el fichero
                pw.write("\n");
            }
            br.close();
            pw.close();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
