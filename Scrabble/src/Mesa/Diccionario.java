package Mesa;
import java.util.*;
public class Diccionario {
    private ArrayList<String> miDiccionario;
    
    public Diccionario(){
        miDiccionario = new ArrayList();
        this.miDiccionario.add("CARRO");
        this.miDiccionario.add("CASA");
        this.miDiccionario.add("ELEFANTE");
        this.miDiccionario.add("LAPIZ");
        this.miDiccionario.add("PANTERA");
        this.miDiccionario.add("EL");
        this.miDiccionario.add("LA");
        this.miDiccionario.add("UN");
        this.miDiccionario.add("RELOJ");
        this.miDiccionario.add("JAULA");
        this.miDiccionario.add("EL");       
    }

    public ArrayList<String> getMiDiccionario() {
        return miDiccionario;
    }

    public void setMiDiccionario(ArrayList<String> miDiccionario) {
        this.miDiccionario = miDiccionario;
    }
    
    public boolean containsWord(String palabra){        
        if(miDiccionario.contains(palabra))
                return true;
        else
            return false;
    }
}
