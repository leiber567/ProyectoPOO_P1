package Casillas;

public class CasillaNormal extends Casilla{

    public CasillaNormal(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(1);
        this.setTipo((char)27+"[047;31m"+"   "+(char)27+"[049;30m");
    }
    
}
