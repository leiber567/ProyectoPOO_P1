package Casillas;

public class Casilla {
    private int coordX;
    private int coordY;
    private int valor;
    private String tipo;
    private String contenido;
    public Casilla(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.valor = 0;
        this. tipo = "Casilla";
        this.contenido = null;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
   
    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
