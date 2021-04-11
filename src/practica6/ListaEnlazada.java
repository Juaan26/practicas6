package practica6;

public class ListaEnlazada<E> {

	private Nodo primero;      
	private int numElementos;

public ListaEnlazada() {
		
		primero = 
				null;
		numElementos = 0;
 }


class Nodo {
		Object dato;
		Nodo siguiente;
		private ListaEnlazada<E>.Nodo primero;
		private int numElementos;

public Nodo(Object dato) {
	
		this.dato = dato;
		siguiente = null;
}

public void add(E elem, int indice ) {
	
	if (indice >= numElementos || indice < 0) {
		
		throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
	}	
	
	Nodo nuevo = new Nodo(elem);
	Nodo actual;
	Nodo anterior;
	
	if (indice == 0) {
		
		actual = primero;
		this.primero = nuevo;
		nuevo.siguiente = actual;
}
	else {
		
		anterior = obtenerNodo(indice-1);
		actual = anterior.siguiente;
		anterior.siguiente = nuevo ;
		nuevo.siguiente = actual;
}
	
		this.numElementos++;
}

public void add(Object dato) {	 

   	 Nodo nuevo = new Nodo(dato);
   	 Nodo ultimo = null;
   	 
		if (numElementos == 0) {
			
			primero = nuevo;
 }
	 else {

			ultimo = obtenerNodo(numElementos-1);
			ultimo.siguiente = nuevo;
	 	}
		numElementos++;           		
}

private Nodo obtenerNodo(int indice) {
	
		assert indice >= 0 && indice < numElementos;
		Nodo actual = primero;
		for (int i = 0; i < indice; i++)
			actual = actual.siguiente;
		return actual;
	}
	
public Object remove(int indice) {
	
	if (indice >= numElementos || indice < 0) {
		
		throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
}		
	if (indice > 0) {	
	
		return removeIntermedio(indice);
}		
	if (indice == 0) {
		
		return removePrimero();
}		
		return null;
	}
	
private Object removePrimero() {
	
	Nodo actual = null;
		actual = primero;			  
		primero = primero.siguiente;	
		numElementos--;
	return actual.dato;
	}

	
private Object removeIntermedio(int indice) {
	
		assert indice > 0 && indice < numElementos;
		Nodo actual = null;
		Nodo anterior = null;
		
	anterior = obtenerNodo(indice - 1);
	actual = anterior.siguiente;		    
	anterior.siguiente = actual.siguiente;     
	numElementos--;
		return actual.dato;	
	}
	
public int remove(Object dato) { 
	
	int actual = indexOf(dato);
	if (actual != -1) {
			remove(actual);        
		}
			return actual;
	}
	
public int indexOf(Object dato) {
	Nodo actual = primero;
		
		for (int i = 0; actual != null; i++) {
		
			if ((actual.dato != null && actual.dato.equals(dato))
				|| actual.dato == dato) {
				return i;
	}
			actual = actual.siguiente;
	}
				return -1;
}
		
		public Object get(int indice) {
		
		   	 if (indice >= numElementos || indice < 0) {
		   		 throw new IndexOutOfBoundsException("índice incorrecto: " + indice);
		   	 }
		Nodo aux = obtenerNodo(indice);
		   	return aux.dato;
		} 
	}
}