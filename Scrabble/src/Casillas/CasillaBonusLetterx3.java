package Casillas;

public class CasillaBonusLetterx3 extends Casilla{

    public CasillaBonusLetterx3(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(1);
        this.setTipo((char)27+"[044;37m"+"Lx3"+(char)27+"[049;30m");
    }
    
}
