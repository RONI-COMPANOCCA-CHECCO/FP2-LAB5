import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ColeccionesList{
    static Scanner consola = new Scanner(System.in);
    // implementacion de la interfaz
    List<String> listaCadenas = new ArrayList<String>();
    
    public void llenarArrayList(){
        // agregamos elementos
        listaCadenas.add("Arequipa");
        listaCadenas.add("Tacna");
        listaCadenas.add("Moquegua");
        listaCadenas.add("Trujillo");
        listaCadenas.add("Lima");
        listaCadenas.add("Chiclayo");
        listaCadenas.add("Cajamarca");
        // permite duplicados
        listaCadenas.add("Cajamarca");
        listaCadenas.add("Cuzco");
        listaCadenas.add("Arequipa");
        Iterator iterador = listaCadenas.iterator();
        // recorremos y mostramos contenido de lista
        System.out.println(("\nARRAYLIST\n"));
        while(iterador.hasNext()){
            String elemento = (String) iterador.next();
            System.out.println(elemento);
        }
        // muestra el tamaño de la lista
        System.out.println("Tamaño: "+listaCadenas.size());
        // retorna un objeto segun su posicion
        int indice = listaCadenas.indexOf("Arequipa");
        System.out.println("Elemento: "+listaCadenas.get(indice)+"Posicion: "+indice);
        indice = listaCadenas.indexOf("Lima");
        System.out.println("Elemento: "+listaCadenas.get(indice)+"Posicion: "+indice);
    }
        
    public void buscarEnArrayList(){
        //busqueda de un objeto dentro de la coleccion
        System.out.println("Ingrese un valor a Buscar: ");
        String objetoBuscar = consola.next();

        if(listaCadenas.contains(objetoBuscar)){
            System.out.println(objetoBuscar+" Se encuentra en la Lista");
        }else {
            System.out.println(objetoBuscar+" No se encuentra!!");
        }
        
    }

    public void eliminarEnArrayList(){
        //eliminar un objeto de la coleccion
        System.out.println("Ingrese un valor a Borrar: ");
        String objetoBorrar1 = consola.next();
        int posicion = listaCadenas.indexOf(objetoBorrar1);
        listaCadenas.remove(posicion);

        //eliminar todos los objeto de la coleccion
        listaCadenas.clear();
        if (listaCadenas.isEmpty()){
            System.out.println("La lista se encuentra vacia");
        }
    }
}