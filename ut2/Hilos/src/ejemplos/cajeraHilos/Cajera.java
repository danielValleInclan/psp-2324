package ejemplos.cajeraHilos;

public class Cajera extends Thread {
    private String nombre;
    private Cliente cliente;
    private long timeStamp;
    public void run(){
        System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +
                this.cliente.getNombre() +  " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.timeStamp) / 1000 + " seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(this.cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " -> Tiempo: " +
                    (System.currentTimeMillis() - this.timeStamp) / 1000 + " seg");
        }
        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " +
                this.cliente.getNombre() +  " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.timeStamp) / 1000 + " seg");
    }
    public Cajera(String nombre, Cliente cliente, long timeStamp) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.timeStamp = timeStamp;
    }

    private void esperarXsegundos(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }
}
