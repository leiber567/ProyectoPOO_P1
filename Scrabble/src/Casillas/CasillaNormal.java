package Casillas;

public class CasillaNormal extends Casilla{

    public CasillaNormal(int coordX, int coordY) {
        super(coordX, coordY);
        this.setValor(1);
        this.setTipo("   ");
    }
    @Override
    public String getRepresentacion() {
        if (this.getContenido() == null)
            return (char)27+"[047;37m"+" "+this.getTipo()+" "+(char)27+"[049;30m";
        else
            if (this.getContenido().length()>1)
                return (char)27+"[043;30m"+"  "+this.getContenido()+" "+(char)27+"[049;30m";
            else
                return (char)27+"[043;30m"+"  "+this.getContenido()+"  "+(char)27+"[049;30m";
    }
    
}
