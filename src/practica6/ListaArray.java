package practica6;

/*
 Juan Gil Sánchez
 01/04/2021 
 */
public class ListaArray {


// Atributos 
private Object[] arrayElementos;
private int numElementos1;
private static final int TAMAÑO_INICIAL = 4;

// Métodos  
/** 
 * Inicializa el array de elementos de la lista.  
 */
public ListaArray() {
arrayElementos = new Object[TAMAÑO_INICIAL];
numElementos1 = 0;
}
 
/**
 * @return número de elementos actual en la lista.
 */
public int size() {
       return numElementos1;
}

// ...

 // class



	/**
	 * Añade un elemento a la lista
	 * @param elemento - el elemento a añadir
	 */
	public void add(Object elemento) {
		if (numElementos1 == 0) {
			arrayElementos[0] = elemento;
			numElementos1++;
		}
		else {
			comprobarLlenado();
			arrayElementos[numElementos1] = elemento;
			numElementos1++;
		}
	}
	
      /**
	 * Comprueba si el array si el array interno está casi lleno y lo copia
	 * ampliando al doble su tamaño.
	 */
      private void comprobarLlenado() {
		// El array interno está casi lleno, se duplica el espacio. 
		if (numElementos1 + 1 == arrayElementos.length) {
		      Object[] arrayAmpliado = new Object[arrayElementos.length*2];
		    System.arraycopy(arrayElementos, 0, 
                                  arrayAmpliado, 0, numElementos1);
			arrayElementos = arrayAmpliado;
		}
	}

	/**
	 * Inserta un elemento en la posición especificada por el índice.
	 * @param indice - indica la posición de inserción en la lista.
	 * @param elemento - elemento a insertar.
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int indice, Object elemento) {
		// El índice debe ser válido.
		if (indice >= numElementos1 || indice < 0) {
		     throw new IndexOutOfBoundsException("Índice incorrecto: " 
                                                        + indice);
		}
		comprobarLlenado();

		// Inserción, desplaza los elementos desde índice indicado.
		if (indice < numElementos1) {
			System.arraycopy(arrayElementos, indice, arrayElementos,
                                    indice+1, numElementos1 - indice);
		}
		arrayElementos[indice] = elemento;
		numElementos1++;
	}


/**
* Devuelve el índice de la primera ocurrencia para el objeto especificado.
* @param elem - el elemento buscado.
* @return el índice del elemento o -1 si no lo encuentra.
*/
public int indexOf(Object elem) {
if (elem == null) {
for (int i = 0; i < arrayElementos.length; i++) {
       if (arrayElementos[i] == null) {
return i;
}
}
} 
else {
for (int i = 0; i < arrayElementos.length; i++) {
if (elem.equals(arrayElementos[i])) {
return i;
}
}
}
return -1;
}
 
/**
 * Borra todos los elementos de la lista.
 */
public void clear() {
    arrayElementos = new Object[TAMAÑO_INICIAL];
    numElementos1 = 0;
}
 
/**
 * Comprueba si existe un elemento.
 * @param elem – el elemento a comprobar.
 * @return true - si existe.
 */
public boolean contains(Object elem) {
   return indexOf(elem) != -1; 
}
 
/**
 * Obtiene el elemento-dato por índice.
 * @param indice - posión relativa del nodo que contiene el elemento-dato.
 * @return el dato indicado por el índice de nodo; null si está indefinido.
 *@exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1.
 */
public Object get(int indice) {
// El índice debe ser válido para la lista.
if (indice >= numElementos1 || indice < 0) {
throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
}  
	return arrayElementos[indice];
}


/**
 * Elimina el elemento especificado en el índice.
 * @param indice - del elemento a eliminar.
 * @return - el elemento eliminado.
* @exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1.
 */
public Object remove(int indice) {
// El índice debe ser válido para la lista.
if (indice >= numElementos1 || indice < 0) {
throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
}
// Elimina desplazando uno hacia la izquierda, sobre la posición a borrar.
Object elem = arrayElementos[indice];
System.arraycopy(arrayElementos, indice+1, arrayElementos, indice, numElementos1 - (indice+1));

// Ajusta el último elemento.
arrayElementos[numElementos1-1] = null;
numElementos1--;
return elem;
}
 
/**
 * Elimina el elemento especificado.
 * @param elemento - elemento a eliminar.
 * @return - el índice del elemento eliminado o -1 si no existe.
 */
public int remove(Object elem) {
int indice = indexOf(elem);

if (indice != -1) {
 remove(indice);
   	 }		 
return indice;
}



public static void main(String[] args){
ListaArray listaCompra = new ListaArray();
listaCompra.add("Leche");
listaCompra.add("Miel");
listaCompra.add("Aceitunas");
listaCompra.add("Cerveza");
listaCompra.remove("Aceitunas");
listaCompra.add(1, "Fruta");
listaCompra.add(0, "Queso");
listaCompra.add(4, "Verduras");

System.out.format("Los %d elementos de la lista de la compra son:\n",  listaCompra.size());
for (int i = 0; i < listaCompra.size(); i++) {
System.out.format("%s\n", listaCompra.get(i));
}
System.out.format("¿Hay pan en la lista? %b", listaCompra.contains("Pan"));
}


}
