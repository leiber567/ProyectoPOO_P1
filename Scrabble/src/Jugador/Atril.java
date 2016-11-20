
package Jugador;
import java.util.*;
public class Atril {
    private ArrayList<Ficha> miAtril;
    private final int tamañoAtril = 7;
    private int numFichas;

    public Atril() {
        this.miAtril = new ArrayList();
        this.numFichas = miAtril.size();
    }

    public ArrayList<Ficha> getMiAtril() {
        return miAtril;
    }

    public void setMiAtril(ArrayList<Ficha> miAtril) {
        this.miAtril = miAtril;
    }
    
    public int getTamaño(){
        return this.tamañoAtril;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public void setNumFichas(int numFichas) {
        this.numFichas = numFichas;
    }
    
    public void addFicha(Ficha fichaAñadir){
        miAtril.add(fichaAñadir);
    }
    public void mostrarAtril(){
        for(int i = 0; i<miAtril.size(); i++)
            System.out.print("["+miAtril.get(i).getLetra()+","+miAtril.get(i).getValor()+"]\t");
    }
    
    
    
}
