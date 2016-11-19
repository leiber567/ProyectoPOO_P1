package Casillas;

public class CasillaBonusWordx3 extends Casilla{

    public CasillaBonusWordx3(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(1);
        this.setTipo((char)27+"[041;37m"+"Wx3"+(char)27+"[049;30m");
    }
    
}
