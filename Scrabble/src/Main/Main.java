package Main;

import Mesa.*;
import Casillas.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Punto p1 = new Punto (5,4);
        ArrayList<Casilla> asd = new ArrayList();
        asd.add(new CasillaNormal(5,4));
        CasillaNormal q1 = new CasillaNormal(5,4);
        CasillaBonusLetterx2 q2= new CasillaBonusLetterx2(5,4);
        CasillaBonusLetterx3 q3= new CasillaBonusLetterx3(5,4);
        
        CasillaBonusWordx3 r = new CasillaBonusWordx3(5,4);
        asd.add(q1);
        Tablero t1 = new Tablero();
        System.out.println(5 == p1.getCoordX() && 4==p1.getCoordY());
        System.out.println(asd.contains(r));
        System.out.println((char)27+"[042;37m"+"L"+(char)27+"[049;30m");
        
        //t1.mostrarTablero();
        String a = (char)27+"[045;37m"+"Lx2"+(char)27+"[049;30m";
        HashMap<String, Integer> fichas = new HashMap<String, Integer>();
        fichas.put("A", 4);
        fichas.put("B", 6);
        System.out.println(fichas.get("Blank"));
        System.out.println((char)65);
    }
    
}
