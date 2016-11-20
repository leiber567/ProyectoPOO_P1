package Menu;

import java.util.*;

public class MiMenu {   
    /**
     * Método permite mostrar por pantalla el menú principal del juego.
     */
    public static void mostrarMenu(){
        System.out.println((char)27+"[049;32m"+"\n\t\t¡BIENVENIDO A SCRABBLE!"+(char)27+"[049;30m");
        System.out.println("\t1.- Juego nuevo");
        System.out.println("\t2.- Instrucciones");
        System.out.println("\t3.- Información");
        System.out.println("\t4.- Salir");
    }//Cierre del método.
    
    /**
     * Método permite mostrar las instrucciones del juego.
     */
    public static void mostrarInstrucciones(){
        System.out.println((char)27+"[049;31m"+"\t\t\t\tINSTRUCCIONES\n"+
        "\n");        
    }//Cierre del método.
    
    /**
     * Método permite mostrar información sobre el juego.
     */
    public static void mostrarInformacion(){
        System.out.println((char)27+"[049;31m"+"\t\t\t\t¿De que trata Battleship?\n" +
        "\n");
    }//Cierre del método.
    
    
    public static void jugarTurno(){ 
        
    }//Cierre del método.
    
    /**
     * Método que permite el ingreso válido de un tipo de dato entero entre
     * un rango de valores dados como parámetros.
     * @param limitInf Valor mínimo que puede tener el entero ingresado.
     * @param limitSup Valor máximo que puede tener el entero ingresado.
     * @param mensaje Mensaje que se mostrará en caso de que no se ingrese
     * un tipo de dato que no sea entero.
     * @return Entero que se encuentra entre el rango dado como límite.
     */
    public static int ingresarOpcion(int limitInf,int limitSup, String mensaje){
        /*
        Inicializacion de un objeto escaner para el ingreso de datos
        */
        Scanner escaner = new Scanner (System.in);
        escaner.useLocale(Locale.US);
        escaner.useDelimiter("\n");
        /*
        Opción que será retornada y estará entre el límite dado
        */
        int opcion=0;
        /*
        Se le solicitará una opción al usuario hasta que la misma sea de tipo
        entero y se encuentre en el intervalo dado como límite.
        */
        do{
            System.out.print((char)27+"[37;34m"+"Ingrese la opción que desee: "+(char)27+"[049;30m");
            String cad_opcion = escaner.next();
            try{
                if(Integer.parseInt(cad_opcion)>=limitInf && Integer.parseInt(cad_opcion)<=limitSup)
                    opcion=Integer.parseInt(cad_opcion);
            }
            catch(NumberFormatException e){
                System.out.println((char)27+"[049;31m"+mensaje+(char)27+"[049;30m");
            }
        }while(opcion == 0);
        return opcion;
    }//Cierre del método.
} 