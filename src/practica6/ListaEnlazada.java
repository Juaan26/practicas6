

/**
 * Ejercicios 3 y 4. 3; se pide un método add para la implementación de la lista enlazada que se proporciona
 * en los apuntes, que acepta como argumento el índice donde se inserta y el objeto a insertar.4; se pide un
 * método removeAll, que recibe como argumento otra lista enlazada y sirve para eliminar de la primera lista todos los
 * elementos que se proporcionan en la segunda.
 * Juan Gil Sánchez
 * 06/04/2021
 */

public class ListaEnlazada {
	
	//Atributos de la Lista Enlazada
	private Nodo primero;
	private int numElementos;

	public static void main(String[] args) {
		
		ListaEnlazada list1 = new ListaEnlazada();
		
		//se añaden 4 datos de prueba con el método tradicional al final de la lista.
		list1.add("Hola");
		list1.add(2);
		list1.add(true);
		list1.add(3.14);
		
		//prueba del método add nuevo, con índice y con un dato de tipo String.
		list1.add(4,"prueba");
		
		System.out.println("Lista 1:\n");
		for (int i = 0; i < list1.size(); i++) {
		System.out.println(i + ": " + list1.get(i));
		}
		
		ListaEnlazada list2 = new ListaEnlazada();
		
		//Se añaden 3 datos de prueba en la Lista Enlazada list2. 2 de ellos están en la list1.
		list2.add("Hola");
		list2.add("prueba");
		list2.add(66.77);
		
		//Se borran los datos de la list1 que estén también en la list2.
		list1.removeAll(list2);
		
		System.out.println("\nLista 1 modificada:\n");
		for (int i = 0; i < List1.size(); i++) {
		System.out.println(i + ": " + List1.get(i));
		}
	}
	
	//Constructor de la lista vacía
	public ListaEnlazada() {
		primero = null;
		numElementos = 0;
	}
	
	public int size() {
		
		return numElementos;
	}

	
	/**
	 * Método add original, que añade un elemento al final de la lista.
	 * @param elem -  el elemento a añadir.
	 * Admite un elemento null.
	 */
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
	
	/**
	 * método add que pide el ejercicio 3.
	 * 
	 * @param indice - el índice donde se ha de insertar el dato
	 * @param dato - el dato del nodo
	 */
	public void add(int indice, Object dato) {
		
		//Excepción que se lanza si intentamos introducir el número en un índice fuera de los límites de la lista.
		if (indice < 0 || indice > numElementos) {
	   		 throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
	   	}
		
		Nodo nuevo = new Nodo(dato);
		Nodo actual = obtenerNodo(indice);
		
		//caso en el que se quiera introducir el dato en primer lugar
		if(indice == 0) {
			
			primero = nuevo;
			nuevo.siguiente = actual;
		}
		
		else {
			
			//En el caso de que se quiera introducir el dato en último lugar. Se resta 1 a numElementos para evitar 
			//sumarlo dos veces (una con cada método add)
			if(indice == numElementos) {
				
				this.add(dato);
				numElementos --;
			}
			
			else {
		
				Nodo anterior = obtenerNodo(indice-1);
				
				anterior.siguiente = nuevo;
				nuevo.siguiente = actual;
			}
		}
		
		numElementos ++;
	}
	
	//Método auxiliar que obtiene un nodo según el índice;
	private Nodo obtenerNodo(int indice) {
		assert indice >= 0 && indice < numElementos;
		
		Nodo actual = primero;
		for (int i=0;i<indice;i++) actual = actual.siguiente;
		return actual;
	}
	
	/**
	 * @param indice – obtiene un elemento por su índice.
	 * @return elemento contenido en el nodo indicado por el índice.
	 * @exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1.
	 */
	public Object get(int indice) {
	// lanza excepción si el índice no es válido
	   	 if (indice >= numElementos || indice < 0) {
	   		 throw new IndexOutOfBoundsException("índice incorrecto: " + indice);
	   	 }
	Nodo aux = obtenerNodo(indice);
	   	return aux.dato;
	}
	
	/**
	 * Método que pide el ejercicio 4, en el que se proporciona una ListaEnlazada con datos que se tienen
	 * que borrar de otra.
	 * 
	 * @param datosAborrar - Lista enlazada con los datos a borrar
	 */
	public void removeAll(ListaEnlazada datosAborrar) {
		
		for(int i=0;i<this.numElementos;i++) {
			
			for(int j=0;j<datosAborrar.numElementos;j++) {
				
				if(this.get(i) == datosAborrar.get(j)) {
				
					this.remove(i);
					numElementos --;
				}
			}
		}
		
	}
	
	/**
	 * Elimina el elemento indicado por el índice. Ignora índices negativos
	 * @param indice - posición del elemento a eliminar
	 * @exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1
	 */
	public void remove(int indice) {
		// Lanza excepción si el índice no es válido.
		if (indice >= numElementos || indice < 0) {
			throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
		}		
		if (indice > 0) {		
			removeIntermedio(indice);
		}		
		if (indice == 0) {
			removePrimero();
		}		
	}
	
	//Método auxiliar al método remove, que usa cuando se tiene que eliminar el primer nodo.
	private void removePrimero() {
		   
		primero = primero.siguiente;
		numElementos--;
	}
	
	//Método auxiliar al método remove, que se usa para eliminar nodos intermedios o el nodo final.
	private void removeIntermedio(int indice) {
		
		assert indice > 0 && indice < numElementos;
		
		Nodo actual = null;
		Nodo anterior = null;
		
		anterior = obtenerNodo(indice - 1);
		
		actual = anterior.siguiente;
		anterior.siguiente = actual.siguiente;
		numElementos--;
	}
}

class Nodo {
	
	//Atributos
	Object dato;
	Nodo siguiente;
	
	//Constructor
	public Nodo(Object dato) {
		
		this.dato = dato;
		siguiente = null;
	}
}
