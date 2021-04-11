package practica6;

/*
 Juan Gil S�nchez
 01/04/2021 
 */
public class ListaArray {


// Atributos 
private Object[] arrayElementos;
private int numElementos1;
private static final int TAMA�O_INICIAL = 4;

// M�todos  
/** 
 * Inicializa el array de elementos de la lista.  
 */
public ListaArray() {
arrayElementos = new Object[TAMA�O_INICIAL];
numElementos1 = 0;
}
 
/**
 * @return n�mero de elementos actual en la lista.
 */
public int size() {
       return numElementos1;
}

// ...

 // class



	/**
	 * A�ade un elemento a la lista
	 * @param elemento - el elemento a a�adir
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
	 * Comprueba si el array si el array interno est� casi lleno y lo copia
	 * ampliando al doble su tama�o.
	 */
      private void comprobarLlenado() {
		// El array interno est� casi lleno, se duplica el espacio. 
		if (numElementos1 + 1 == arrayElementos.length) {
		      Object[] arrayAmpliado = new Object[arrayElementos.length*2];
		    System.arraycopy(arrayElementos, 0, 
                                  arrayAmpliado, 0, numElementos1);
			arrayElementos = arrayAmpliado;
		}
	}

	/**
	 * Inserta un elemento en la posici�n especificada por el �ndice.
	 * @param indice - indica la posici�n de inserci�n en la lista.
	 * @param elemento - elemento a insertar.
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int indice, Object elemento) {
		// El �ndice debe ser v�lido.
		if (indice >= numElementos1 || indice < 0) {
		     throw new IndexOutOfBoundsException("�ndice incorrecto: " 
                                                        + indice);
		}
		comprobarLlenado();

		// Inserci�n, desplaza los elementos desde �ndice indicado.
		if (indice < numElementos1) {
			System.arraycopy(arrayElementos, indice, arrayElementos,
                                    indice+1, numElementos1 - indice);
		}
		arrayElementos[indice] = elemento;
		numElementos1++;
	}


/**
* Devuelve el �ndice de la primera ocurrencia para el objeto especificado.
* @param elem - el elemento buscado.
* @return el �ndice del elemento o -1 si no lo encuentra.
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
    arrayElementos = new Object[TAMA�O_INICIAL];
    numElementos1 = 0;
}
 
/**
 * Comprueba si existe un elemento.
 * @param elem � el elemento a comprobar.
 * @return true - si existe.
 */
public boolean contains(Object elem) {
   return indexOf(elem) != -1; 
}
 
/**
 * Obtiene el elemento-dato por �ndice.
 * @param indice - posi�n relativa del nodo que contiene el elemento-dato.
 * @return el dato indicado por el �ndice de nodo; null si est� indefinido.
 *@exception IndexOutOfBoundsException - �ndice no est� entre 0 y numElementos-1.
 */
public Object get(int indice) {
// El �ndice debe ser v�lido para la lista.
if (indice >= numElementos1 || indice < 0) {
throw new IndexOutOfBoundsException("�ndice incorrecto: " + indice);
}  
	return arrayElementos[indice];
}


/**
 * Elimina el elemento especificado en el �ndice.
 * @param indice - del elemento a eliminar.
 * @return - el elemento eliminado.
* @exception IndexOutOfBoundsException - �ndice no est� entre 0 y numElementos-1.
 */
public Object remove(int indice) {
// El �ndice debe ser v�lido para la lista.
if (indice >= numElementos1 || indice < 0) {
throw new IndexOutOfBoundsException("�ndice incorrecto: " + indice);
}
// Elimina desplazando uno hacia la izquierda, sobre la posici�n a borrar.
Object elem = arrayElementos[indice];
System.arraycopy(arrayElementos, indice+1, arrayElementos, indice, numElementos1 - (indice+1));

// Ajusta el �ltimo elemento.
arrayElementos[numElementos1-1] = null;
numElementos1--;
return elem;
}
 
/**
 * Elimina el elemento especificado.
 * @param elemento - elemento a eliminar.
 * @return - el �ndice del elemento eliminado o -1 si no existe.
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
System.out.format("�Hay pan en la lista? %b", listaCompra.contains("Pan"));
}


}
