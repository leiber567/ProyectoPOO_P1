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
    
    public int getValorCasilla(int fila, int columna){
        for(int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getValor();
        }
        return 0;
    }
    
    
    public String getTipoCasilla(int fila, int columna){
        for (int i = 0; i<miTablero.size(); i++){
            if(miTablero.get(i).getCoordX() == fila &&
               miTablero.get(i).getCoordY() == columna)
                return miTablero.get(i).getTipo();
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
                    System.out.print(getTipoCasilla(i,j));
                        
            }
            System.out.print("\n");
        }
    }
}
