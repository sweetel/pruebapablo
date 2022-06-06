/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lopez_pablo3ev;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Lopez_Pablo3ev {

   
    public static void main(String[] args) {
            
        Scanner leer = new Scanner(System.in);
        ArrayList <Prestamo> libros = new ArrayList <>();
        String [] menu = {"1- Alta Libro", "2- Baja libro (Buscando por ISBN)", "3- Visualizar libros del autor", "4- Salir"};
        int respuesta = 0;
        int respuesta1;
        int isbn;
        String prestado = null;
        String autor;
        String titulo;
        int contadorComprobante;
        
      
        while (respuesta != 4) {
            
          
            for ( int contador = 0; contador < menu.length; contador++ ) {
                System.out.print("\n"+menu[contador]);
            }
            
            System.out.print("\nElija una opcion: ");
            respuesta = leer.nextInt();
            
            switch (respuesta) {
                
                case 1:
                    System.out.print("\nISBN:  ");
                    isbn = leer.nextInt();
                    leer.nextLine();
                    System.out.print("\nTitulo:  ");
                    titulo = leer.nextLine();
                    System.out.print("\nAutor:  ");
                    autor = leer.nextLine();
                    
                    libros.add(new Prestamo(isbn, titulo, autor, prestado));
                    break;
                    
                case 2:
                    System.out.print("\nIntroduce codigo ISBN para borrar: ");
                    isbn = leer.nextInt();
                    contadorComprobante = 1;
                    for ( int contador = 0; contador < libros.size(); contador++ ) {
                        if (isbn == libros.get(contador).getISBN()) {
                            libros.remove(contador);
                            System.out.print("\nEl libro ha sido borrado correctamente.");
                            contadorComprobante = 0;
                        }
                        else {
                            contadorComprobante++;
                        }
                    }
                    if ( contadorComprobante == libros.size() ) {
                        System.out.print("\nEl codigo ISBN no exite.");                        
                    }
                    break;
                
                case 3:
                    leer.nextLine();
                    System.out.print("\nNombre del autor: ");
                    autor = leer.nextLine();
                    
                    for ( int contador = 0; contador < libros.size(); contador++ ) {
                        if ( libros.get(contador).getAutor().equalsIgnoreCase(autor) ) {
                            System.out.print("\nAutor: "+libros.get(contador).getAutor()+" - Libros: "+libros.get(contador).getTitulo());
                        }
                    }
                    break;
                          
            }
        }
    }
}
    

