package Mesa;
import Casillas.*;
import java.util.*;
public class Tablero {
    private final int ancho = 15;
    private final int largo = 15;
    private ArrayList<Palabra> misPalabras;
    private ArrayList<Casilla> miTablero;
    private final int posLetterx2[][] = {{0,3},{0,11},{1,1},{2,2},{3,3},{4,4},{13,1},{12,2},{11,3},{10,4},{1,13},{2,12},{3,11},{4,10},{10,10},{11,11},{12,12},{13,13},
            {2,6},{3,7},{2,8},{12,6},{12,8},{11,7},{3,0},{3,14},{6,2},{6,6},{6,8},{6,12},{7,3},{7,11},{8,2},{8,6},{8,8},{8,12},{11,0},{11,14},{14,3},{14,11}};
    private final int posLetterx3[][] = {{1,5},{1,9},{5,1},{5,5},{5,9},{5,13},{9,1},{9,5},{9,9},{9,13},{13,5},{13,9}};
    private final int posWordx3[][] = {{0,0},{0,7},{0,14},{7,0},{7,14},{14,0},{14,7},{14,14}};
    private Diccionario diccionario;
    public Tablero() {
        miTablero = new ArrayList();
        for(int i = 0; i<largo; i++){
            for(int j = 0; j<ancho; j++){                
                if (isInArray(posLetterx2, i, j))
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
    /*
    public boolean isPalabra(int fila, int columna){
        for (int i = 0; i<misPalabras.size(); i++){
        
            
        
    }
    */
    
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
    public String getContenidoCasilla(int fila, int columna){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getContenido();
        }
        return null;       
    }
    
    
    public boolean isInArray(int[][] array, int fila, int columna){
        for (int i=0; i<array.length; i++){            
            if (array[i][0] == fila && array[i][1] == columna)
                return true;
        }
        return false;
    }
    
    public Palabra verificarPosCasillas(String palabra, int orientacion, int posFila, int posColumna, ArrayList<String> atril){
        char arrayFichas[] = palabra.toCharArray();
        int numFichasAtril = atril.size();
        Palabra newPalabra = new Palabra();
        for (int i = 0; i<arrayFichas.length; i++){
            for(int j = 0; j<atril.size(); j++){
                if(atril.get(j).equals(Character.toString(arrayFichas[i]))){
                    atril.remove(j);
                  
                    j = numFichasAtril;
                    numFichasAtril--;
                }
            }
        }
        if(numFichasAtril != atril.size()){    
            if((orientacion == 1) && (posFila + (arrayFichas.length - 1) < (largo - 1))){
                System.out.println("3");
                for(int i = posFila; i<(posFila + arrayFichas.length); i++){
                    if(getContenidoCasilla(i, posColumna)!=null &&
                       !getContenidoCasilla(i, posColumna).equals(Character.toString(arrayFichas[i])))
                       return null;
                    newPalabra.getCoordenadas().add(new Coordenada(i, posColumna));
                }
                newPalabra.setOrientacion(orientacion);
                return newPalabra;
            }        
            if((orientacion == 2) && (posColumna + (arrayFichas.length - 1) < (ancho - 1))){
                System.out.println("4");
                for(int i = posColumna; i<(posColumna + arrayFichas.length); i++){
                    if(getContenidoCasilla(posFila, i)!=null &&
                       !getContenidoCasilla(posFila, i).equals(Character.toString(arrayFichas[i])))
                        return null;
                    newPalabra.getCoordenadas().add(new Coordenada(posFila, i));
                }
                newPalabra.setOrientacion(orientacion);
                return newPalabra;
            }
        }
        System.out.println("123");
        return null;
    }
    
    public boolean verificarContiguas(Palabra word){
        String palabra = "";
        int j;
        int coordX;
        int coordY;
        if (word.getOrientacion()==1){
            for(int i = 0; i<word.getCoordenadas().size(); i++){
                coordX = word.getCoordenadas().get(i).getCoordX();
                coordY = word.getCoordenadas().get(i).getCoordY();
                palabra += getContenidoCasilla(coordX,coordY);                
                j = 1;
                while ((getContenidoCasilla(coordX,coordY+j) != null) && (coordX+1 < ancho-1)){
                    palabra += getContenidoCasilla(coordX,coordY+j);
                    j++;
                }
                if()
            }
        }
    }
    
    /*
    public Tablero ponerFichas(Tablero miTablero, String palabra){
        char arrayFichas[] = palabra.toCharArray();
        
    }
    */
    /*
    public String getPalabraPorPoner(String palabraVerificar, int fila, int columna, int orientacion){
        String palabra = "";
        if (verificarPosCasillas(palabraVerificar, orientacion, fila, columna)){
            if(orientacion == 1){
                System.out.println("a");
                for(int i = 0; i<largo; i++){
                    if(getContenidoCasilla(i, columna)!=null)
                        palabra += getContenidoCasilla(i, columna);
                    else if(getContenidoCasilla(i, columna)==null && 
                            verificarLetrasContinuas(i, columna, orientacion))
                        palabra = "";
                    else if(getContenidoCasilla(i, columna)==null && 
                            !verificarLetrasContinuas(i, columna, orientacion))
                        return palabra+palabraVerificar;
                }
            }
            else{
                System.out.println("b");
                for(int i = 0; i<ancho; i++){
                    if(getContenidoCasilla(fila, i)!=null)
                        palabra += getContenidoCasilla(fila, i);
                    else if(getContenidoCasilla(fila, i)==null && 
                            verificarLetrasContinuas(fila, i, orientacion))
                        palabra = "";
                    else if(getContenidoCasilla(fila, i)==null && 
                            !verificarLetrasContinuas(fila, i, orientacion))
                        return palabra+palabraVerificar;
                }
            }
        }
        return null;
    }
    */
  
    public boolean verificarLetrasContinuas(int inicioFila, int inicioColumna, int orientacion){
        if(orientacion ==1){
            for(int i = inicioFila+1; i<largo; i++){
                if(getContenidoCasilla(i, inicioColumna)!=null)
                    return true;
            }                
        }
        else{
            for(int i = inicioColumna+1; i<ancho; i++){
                if(getContenidoCasilla(i, inicioFila)!=null)
                    return true;
            }                
        }
        return false;
    }
    
    public void mostrarTablero(){
        String espacios = "";
        System.out.print("    ");
        for (int i = 0; i<ancho; i++){
            if(i<9 || i==(ancho-1))
                espacios = " ";
            else
                espacios = "";
            System.out.print((char)27+"[30;43m "+""+i+espacios);
        }
        System.out.print("\n");
        for(int i = 0; i<largo; i++){
            if(i<=9)
                espacios = "  ";
            else
                espacios = " ";
            System.out.print((char)27+"[30;43m"+" "+i+espacios);  
            for(int j = 0; j<ancho; j++){
                if(i==((largo-1)/2) && j==((ancho-1)/2))
                    System.out.print((char)27+"[042;37m"+"SOR"+(char)27+"[049;30m");
                else
                    if(getContenidoCasilla(i, j)==null)
                        System.out.print(getTipoCasilla(i,j));
                    else
                        System.out.println(getContenidoCasilla(i, j)==null);
                        
            }
            System.out.print("\n");
        }
    }
}
