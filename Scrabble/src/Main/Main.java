package Main;

import Mesa.*;
import Casillas.*;
import Menu.MiMenu;
import java.util.*;
import Jugador.*;
public class Main {

    public static void main(String[] args) {
      
        Scanner escaner = new Scanner (System.in);
        escaner.useLocale(Locale.US);
        escaner.useDelimiter("\n");
        MiMenu.mostrarMenu();
        Tablero t1 = new Tablero();

        Palabra w;
 
     
        /*for(int i=0;i<3;i++){
           
           System.out.print("Fila");
           a = escaner.nextInt();
           System.out.print("Columna");
           b = escaner.nextInt();
           System.out.print("Orientacion");
           c = escaner.nextInt();
           System.out.println("Palabra");
           word = escaner.next();
           w = t1.verificarPosCasillas(word, c, a, b, atril);
           System.out.println(w.getWord());
           if(w!=null && t1.verificarContiguas(w))
               t1.ponerFichas(t1, w);
           t1.mostrarTablero();*/
       
        
        Fichas f = new Fichas();
        Player j = new Player("Leiber");
        Diccionario d = new Diccionario();
        /*f.getNumeroFichas().put("RR", f.getNumeroFichas().get("RR")-1);
        System.out.println(f.getNumeroFichas());
        */
        String []tgb = {"ELEFANTE","CARRO","LEON"};
        int [] posx={7,6,8};
        int [] posy={4,8,11};
        int [] or={2,1,2};
        
        j.setAtril(f);
        j.getAtril().mostrarAtril();
        System.out.println();
        for(int i = 0;i<3;i++){
            escaner.next();
            w=(t1.verificarPosCasillas(tgb[i], or[i], posx[i], posy[i]));
            if(w!=null && i==0)
                t1.ponerFichas(w);
            
            else if(w!=null && t1.verificarContiguas(w) && i!=0){
                System.out.println(t1.verificarContiguas(w));
                t1.ponerFichas(w);                
            }

            t1.mostrarTablero();
            ArrayList<String> ccc= new ArrayList();
            ccc.add("C");
            ccc.add("A");
            System.out.println(ccc.toString());
        }
    }
    
}

