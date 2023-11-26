package recurso_profe.Produc_Consum3;

public class Cola {
	private int numero;

	private boolean disponible = false;   // inicialmente la cola está vacía.
	private int turno = 1;                // inicialmente el turno es del productor o consumidor




	public synchronized int get(int i, int n) {
		while ((!disponible) || (n!=turno))
		{
			try {
				wait();
			}
			catch (InterruptedException e) {	}
		}
		disponible = false;

		// cambiamos el turno
		if (turno==1)
			turno=2;
		else
			turno=1;
		
		notifyAll();
		System.out.println(i + "=>Consumidor: " + n + ": consume: " + numero);
		return numero;
	}

	
	public synchronized void put(int valor, int n) {
		while ((disponible) || (n!=turno)) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		numero = valor;
		System.out.println(valor+"=>Productor" + n + " : produce: " + valor);

		disponible = true;
		
		notifyAll();
	}
}
