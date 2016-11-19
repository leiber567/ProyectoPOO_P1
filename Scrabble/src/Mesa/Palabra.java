package Mesa;
import java.util.*;
public class Palabra {
    private String word;
    private ArrayList<Coordenada> coordenadas;
    private int orientacion;
    public Palabra(String word, ArrayList<Coordenada> coordenadas, int orientacion){
        this.word = word;
        this.coordenadas = coordenadas;
        this.orientacion = orientacion;
    }
    public Palabra(){
        this.word = null;
        coordenadas = new ArrayList();
        this.orientacion = -1;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }
    
    
}
