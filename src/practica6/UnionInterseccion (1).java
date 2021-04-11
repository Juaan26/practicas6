package practicas;

/**
 * Ejercicio 5; se pide una nueva versión del programa de los apuntes de Unión e Intersección pero resuelto
 * con los métodos addAll(), removeAll() y retainAll().
 * Juan Gil Sánchez 
 * 06/04/2021
 */

import java.util.ArrayList;

public class UnionInterseccion {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		list2.add(12);
		
		System.out.println("ArrayList1: " + list1 + "\n");
		System.out.println("ArrayList2: " + list2 + "\n");
		
		ArrayList<Integer> listaUnion = listaUnion(list1,list2);
		System.out.println("Unión de list1 y list2: " + listaUnion + "\n");
	
		ArrayList<Integer> listaInterseccion = listaInterseccion(list1,list2);
		System.out.println("Intersección de list1 y list2: " + listaInterseccion);
		
		
	}
	
	public static ArrayList<Integer> listaUnion (ArrayList<Integer> list1, ArrayList<Integer> list2){
		
		ArrayList<Integer> listaUnion = new ArrayList<Integer>();
		ArrayList<Integer> listaAuxiliar = new ArrayList<Integer>();
		
		listaAuxiliar = listaInterseccion(list1,list2);
		listaUnion.addAll(list1);
		listaUnion.removeAll(listaAuxiliar);
		listaUnion.addAll(list2);
		
		return listaUnion;
	}
	
	public static ArrayList<Integer> listaInterseccion (ArrayList<Integer> list1, ArrayList<Integer> list2){
		
		ArrayList<Integer> listaInterseccion = new ArrayList<Integer>();
		
		listaInterseccion.addAll(list1);
		listaInterseccion.retainAll(list2);
		
		return listaInterseccion;
	}
}
