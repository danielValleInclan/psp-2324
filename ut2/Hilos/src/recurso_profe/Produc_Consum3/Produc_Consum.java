/*  Queremos hacer una variante del modelo productor-consumidor.  Tendremos 2 productores, p1 yp2, y 2 consumidores, c1 y c2 que
*   irán alternado en este orden: p1,c1,p2,c2
*  */
package recurso_profe.Produc_Consum3;


public class Produc_Consum {
  public static void main(String[] args) {  
    Cola cola = new Cola();

    Productor p1 = new Productor(cola, 1);  // Productor num 1
    Productor p2 = new Productor(cola, 2);  // Productor num 2
    Consumidor c1 = new Consumidor(cola, 1);   // Consumidor num 1
    Consumidor c2 = new Consumidor(cola, 2);    // Consumidor num 2


      p1.start();
      p2.start();
	  c1.start();
	  c2.start();
  }
}