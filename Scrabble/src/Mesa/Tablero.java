package Mesa;
import Casillas.*;
import java.util.*;
public class Tablero {
    private final int ancho = 15;
    private final int largo = 15;
    private ArrayList<Casilla> miTablero;
    private final int posLetterx2[][] = {{0,3},{0,11},{1,1},{2,2},{3,3},{4,4},{13,1},{12,2},{11,3},{10,4},{1,13},{2,12},{3,11},{4,10},{10,10},{11,11},{12,12},{13,13},
            {2,6},{3,7},{2,8},{12,6},{12,8},{11,7},{3,0},{3,14},{6,2},{6,6},{6,8},{6,12},{7,3},{7,11},{8,2},{8,6},{8,8},{8,12},{11,0},{11,14},{14,3},{14,11}};
    private final int posLetterx3[][] = {{1,5},{1,9},{5,1},{5,5},{5,9},{5,13},{9,1},{9,5},{9,9},{9,13},{13,5},{13,9}};
    private final int posWordx3[][] = {{0,0},{0,7},{0,14},{7,0},{7,14},{14,0},{14,7},{14,14}};
    private Diccionario diccionario;
    public Tablero() {
        diccionario = new Diccionario();
        miTablero = new ArrayList();
        for(int i = 0; i<largo; i++){
            for(int j = 0; j<ancho; j++){                
                if(i == 7 && j == 7){
                    Casilla casillaCentral = new CasillaNormal(i,j);
                    casillaCentral.setTipo("SOR");
                    miTablero.add(casillaCentral);
                }
                else if (isInArray(posLetterx2, i, j))
                    miTablero.add(new CasillaBonusLetterx2(i,j));
                else if (isInArray(posLetterx3, i, j))
                    miTablero.add(new CasillaBonusLetterx3(i,j));
                else if (isInArray(posWordx3, i, j))
                    miTablero.add(new CasillaBonusWordx3(i,j));
                else
                    miTablero.add(new CasillaNormal(i,j));
            }
        }
    }    
        
    public int getValorCasilla(int fila, int columna){
        for(int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getValor();
        }
        return 0;
    }

    public ArrayList<Casilla> getMiTablero() {
        return miTablero;
    }

    public void setMiTablero(ArrayList<Casilla> miTablero) {
        this.miTablero = miTablero;
    }    
    
    public String getTipoCasilla(int fila, int columna){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getTipo();
        }
        return null;       
    }
    
    public String getRepresentacionCasilla(int fila, int columna){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getRepresentacion();
        }
        return null;       
    }
    public String getContenidoCasilla(int fila, int columna){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getContenido();
        }
        return null;       
    }
    
    public void setContenidoCasilla(int fila, int columna, String contenido){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
               
               miTablero.get(i).setContenido(contenido);
        }
    }    
    
    public boolean isInArray(int[][] array, int fila, int columna){
        for (int i=0; i<array.length; i++){            
            if (array[i][0] == fila && array[i][1] == columna)
                return true;
        }
        return false;
    }
    
    
    
    public Palabra verificarPosCasillas(String palabra, int orientacion, int posFila, int posColumna/*, ArrayList<String> atril*/){
        ArrayList<String> arrayPalabra = Palabra.arreglarLetrasPalabra(palabra);
        //int numFichasAtril = atril.size();
        Palabra newPalabra = new Palabra();
        int iteracion = 0;
        /*for (int i = 0; i<arrayPalabra.size(); i++){
            for(int j = 0; j<atril.size(); j++){
                if(atril.get(j).equals(arrayPalabra.get(i)){
                    atril.remove(j);                  
                    j = numFichasAtril;
                    numFichasAtril--;
                }
            }
        }
        if(numFichasAtril != atril.size()){   */ 
            if((orientacion == 1) && (posFila + (arrayPalabra.size() - 1) < (largo))){
                for(int i = posFila; i<(posFila + arrayPalabra.size()); i++){
                    if(getContenidoCasilla(i, posColumna)!=null &&
                       !getContenidoCasilla(i, posColumna).equals(arrayPalabra.get(iteracion)))
                       return null;
                    newPalabra.getCoordenadas().add(new Coordenada(i, posColumna));
                    newPalabra.getLetrasPalabra().add(arrayPalabra.get(iteracion));
                    iteracion++;
                }
                newPalabra.setOrientacion(orientacion);
                newPalabra.setPalabra(palabra);
                newPalabra.setLetrasPalabra(arrayPalabra);
                return newPalabra;
            }        
            if((orientacion == 2) && (posColumna + (arrayPalabra.size() - 1) < (ancho))){
                for(int i = posColumna; i<(posColumna + arrayPalabra.size()); i++){
                    if(getContenidoCasilla(posFila, i)!=null &&
                       !getContenidoCasilla(posFila, i).equals(arrayPalabra.get(iteracion)))
                        return null;
                    newPalabra.getCoordenadas().add(new Coordenada(posFila, i));
                    newPalabra.getLetrasPalabra().add(arrayPalabra.get(iteracion));
                    iteracion++;
                }
                newPalabra.setOrientacion(orientacion);
                newPalabra.setPalabra(palabra);
                newPalabra.setLetrasPalabra(arrayPalabra);
                return newPalabra;
            }        
        return null;
    }
    
    public boolean verificarContiguas(Palabra word){
        String palabra = "";
        String resp = "";
        ArrayList<String> verificarPalabra = new ArrayList();
        int j;
        int coordX;
        int coordY;
        if (word.getOrientacion()==1){
            for(int i = 0; i<word.getCoordenadas().size(); i++){
                coordX = word.getCoordenadas().get(i).getCoordX();
                coordY = word.getCoordenadas().get(i).getCoordY();
                palabra += word.getLetrasPalabra().get(i);
                j = 1;
                while ((getContenidoCasilla(coordX,coordY+j) != null) && (coordY+j < ancho)){
                    verificarPalabra.add(getContenidoCasilla(coordX,coordY+j));
                    j++;
                }
                for(int k = 0; k<verificarPalabra.size(); k++)
                    resp += verificarPalabra.get(k);
                    
                palabra = palabra+resp;
                resp = "";
                j = -1;
                verificarPalabra = new ArrayList();
                while ((getContenidoCasilla(coordX,coordY+j) != null) && (coordY+j >= 0)){
                    verificarPalabra.add(0,getContenidoCasilla(coordX,coordY+j));
                    j--;
                }
                for(int k = 0; k<verificarPalabra.size(); k++)
                    resp += verificarPalabra.get(k);
                palabra = resp+palabra;
                System.out.println(palabra+i);
                if(diccionario.containsWord(palabra))
                    return true;
                else{
                    verificarPalabra = new ArrayList();
                    resp = "";
                    palabra = "";
                    j = 1;
                }
            }
        }
        else{
            for(int i = 0; i<word.getCoordenadas().size(); i++){
                coordX = word.getCoordenadas().get(i).getCoordX();
                coordY = word.getCoordenadas().get(i).getCoordY();
                palabra += word.getLetrasPalabra().get(i);            
                j = 1;
                while ((getContenidoCasilla(coordX+j,coordY) != null) && (coordX+j < largo)){
                    verificarPalabra.add(getContenidoCasilla(coordX+j,coordY));
                    j++;
                }
                for(int k = 0; k<verificarPalabra.size(); k++)
                    resp += verificarPalabra.get(k);
                palabra = palabra+resp;
                j = -1;
                verificarPalabra = new ArrayList();
                while ((getContenidoCasilla(coordX+j,coordY) != null) && (coordX+j >= 0)){
                    verificarPalabra.add(0,getContenidoCasilla(coordX+j,coordY));
                    j--;
                }
                for(int k = 0; k<verificarPalabra.size(); k++)
                    resp += verificarPalabra.get(k);
                palabra = resp+palabra;
                if(diccionario.containsWord(palabra))
                    return true;
                else{
                    verificarPalabra = new ArrayList();
                    palabra = "";
                    resp = "";
                    j = 1;
                }
            }
        }
        return false;
    }
    
    
    public boolean ponerFichas(Palabra word){
            for(int i = 0; i<word.getCoordenadas().size(); i++){
   
                setContenidoCasilla(word.getCoordenadas().get(i).getCoordX(), 
                                    word.getCoordenadas().get(i).getCoordY(), word.getLetrasPalabra().get(i));

            }          
        return false;
        
    }   
    
    public void mostrarTablero(){
        String espacios = "";
        System.out.print("      ");
        for (int i = 0; i<ancho; i++){
            if(i<9 || i==(ancho-1))
                espacios = "  ";
            else
                espacios = " ";
            System.out.print((char)27+"[30;43m "+" "+i+espacios);
        }
        System.out.print("\n");
        for(int i = 0; i<largo; i++){
            if(i<=9)
                espacios = "   ";
            else
                espacios = "  ";
            System.out.print((char)27+"[30;43m"+"  "+i+espacios);  
            for(int j = 0; j<ancho; j++){
                if(i==((largo-1)/2) && j==((ancho-1)/2) && getContenidoCasilla(i,j) == null)
                    System.out.print((char)27+"[042;37m"+" SOR "+(char)27+"[049;30m");
                else
                    System.out.print(getRepresentacionCasilla(i, j));                        
            }
            System.out.print("\n");
        }
    }
}
