package practica6;

import java.util.ArrayList;

public class PruebaListaEnlazada {
	
	public static void main(String[] args) {
			ArrayList listaCompra = new ArrayList();
				listaCompra.add("Leche");
				listaCompra.add("Miel");
				listaCompra.add("Aceitunas");
				listaCompra.add("Cerveza");
				listaCompra.add("Café");
           System.out.println("Lista de la compra:");
           for (int i = 0; i < listaCompra.size(); i++) {
           System.out.println(listaCompra.get(i));
}
           System.out.println("elementos en la lista: " + listaCompra.size());
           System.out.println("elementos 3 en la lista: " + listaCompra.get(3));
           System.out.println("posición del elemento Miel: " + listaCompra.indexOf("Miel"));
           System.out.println("eliminado: " + listaCompra.remove("Miel"));
}
}

