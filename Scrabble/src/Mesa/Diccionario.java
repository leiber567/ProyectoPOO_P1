package Mesa;
import java.util.*;
public class Diccionario {
    private ArrayList<String> miDiccionario;
    
    public Diccionario(){
        this.miDiccionario = null;
    }

    public ArrayList<String> getMiDiccionario() {
        return miDiccionario;
    }

    public void setMiDiccionario(ArrayList<String> miDiccionario) {
        this.miDiccionario = miDiccionario;
    }
    
    public boolean contains(String palabra){
        for(int i = 0; i<miDiccionario.size(); i++){
            if(miDiccionario.get(i).equals(palabra))
                return true;
        }
        return false;
    }
    /*
    public boolean containsWord(Palabra word){
        if()
    }*/
}
