package Casillas;

public class CasillaBonusWordx3 extends Casilla{

    public CasillaBonusWordx3(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(4);
        this.setTipo("Wx3");
    }
    @Override
    public String getRepresentacion() {
        if (this.getContenido() == null)
            return (char)27+"[041;37m"+" "+this.getTipo()+" "+(char)27+"[049;30m";
        else
            if (this.getContenido().length()>1)
                return (char)27+"[043;30m"+"  "+this.getContenido()+" "+(char)27+"[049;30m";
            else
                return (char)27+"[043;30m"+"  "+this.getContenido()+"  "+(char)27+"[049;30m";
    }
    
}
