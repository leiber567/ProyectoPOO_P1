package Mesa;

import java.util.*;

public class Fichas {
    HashMap<String, Integer> valorFichas = new HashMap<String, Integer>();
    HashMap<String, Integer> numeroFichas = new HashMap<String, Integer>();
    Integer numberTiles[] = {11,3,4,4,11,4,2,4,6,2,1,4,1,3,5,1,8,2,1,4,1,7,4,6,2,1,1,1,1,2};
    Integer values[] = {1,3,2,2,1,2,2,2,1,6,8,1,8,3,1,8,1,3,8,1,8,1,1,1,4,8,8,4,10,0};
    String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","LL","M","N","Ñ","O","P","Q","R","RR","S","T","U","V","W","X","Y","Z"," "};
    int indice = 0;
    public Fichas(){
        for (int i = 0; i<values.length; i++){
            valorFichas.put(letras[i], values[i]);
            numeroFichas.put(letras[i], numberTiles[i]);            
        }      
    }

    public HashMap<String, Integer> getValorFichas() {
        return valorFichas;
    }

    public void setValorFichas(HashMap<String, Integer> valorFichas) {
        this.valorFichas = valorFichas;
    }

    public HashMap<String, Integer> getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(HashMap<String, Integer> numeroFichas) {
        this.numeroFichas = numeroFichas;
    }
}
