package Mesa;

public class Coordenada {
    private int coordX;
    private int coordY;
    
    public Coordenada(){
        this.coordX = 0;
        this.coordY = 0;
    }

    public Coordenada(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
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
    
    public boolean equalsCoord(int coordX, int coordY){
        if((this.coordX == coordX) && (this.coordY == coordY)){
            return true;
        }
        return false;
    }
    
    
}
