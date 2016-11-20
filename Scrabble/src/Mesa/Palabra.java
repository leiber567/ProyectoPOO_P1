package Mesa;
import java.util.*;
public class Palabra {
    private ArrayList<String> letrasPalabra;
    private ArrayList<Coordenada> coordenadas;
    private int orientacion;
    private String palabra;
    public Palabra(String palabra, ArrayList<Coordenada> coordenadas, ArrayList<String> letrasPalabra,int orientacion){
        this.palabra = palabra;
        this.coordenadas = coordenadas;
        this.orientacion = orientacion;
        this.letrasPalabra = letrasPalabra;
    }
    public Palabra(){
        this.palabra = null;
        coordenadas = new ArrayList();
        this.orientacion = -1;
        letrasPalabra = new ArrayList();
    }

    public ArrayList<String> getLetrasPalabra() {
        return letrasPalabra;
    }

    public void setLetrasPalabra(ArrayList<String> letrasPalabra) {
        this.letrasPalabra = letrasPalabra;
    }
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
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
    
    public static ArrayList<String> arreglarLetrasPalabra(String palabra){
        ArrayList<String> letrasPalabra = new ArrayList();
        String arrayPalabra[] = new String[palabra.length()];
        for(int i = 0; i<arrayPalabra.length;i++){
            if(i==0){
                arrayPalabra[i] = Character.toString(palabra.charAt(i));
            }
            else if(i-1>=0 && (palabra.charAt(i)!=palabra.charAt(i-1)))
                arrayPalabra[i] = Character.toString(palabra.charAt(i));
            if(i+1<arrayPalabra.length && (palabra.charAt(i)==palabra.charAt(i+1)))
                arrayPalabra[i]+=Character.toString(palabra.charAt(i+1));
            if(arrayPalabra[i]!=null)
                letrasPalabra.add(arrayPalabra[i]);
        }
        return letrasPalabra;
    }
}
