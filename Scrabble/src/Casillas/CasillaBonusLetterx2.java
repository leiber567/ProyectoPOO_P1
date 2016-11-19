package Casillas;

public class CasillaBonusLetterx2 extends Casilla{

    public CasillaBonusLetterx2(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(2);
        this.setTipo((char)27+"[045;37m"+"Lx2"+(char)27+"[049;30m");
    }
    
}
