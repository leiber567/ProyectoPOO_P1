package Jugador;
import java.util.*;
import Mesa.*;

public class Player {
    private String nombre;
    private int puntuacion;
    private Atril atril;
    
    public Player (String nombre){
        this.atril = new Atril();
        this.nombre = nombre;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Atril getAtril() {
        return atril;
    }

 

        
    public void setAtril(Fichas fichasJuego){
        int aleatoriaPos;
        int iterador = 7-atril.getNumFichas();
        Ficha fichaAtril;
        for(int i = 0; i<iterador; i++){
            do{
                aleatoriaPos = (int)(Math.random()*(fichasJuego.getValorFichas().size()-1));
            }while(fichasJuego.getNumeroFichas().get(fichasJuego.getLetras()[aleatoriaPos])==0);
            fichasJuego.getNumeroFichas().put(fichasJuego.getLetras()[aleatoriaPos],
                                              fichasJuego.getNumeroFichas().get(fichasJuego.getLetras()[aleatoriaPos])-1);
            fichaAtril = new Ficha(fichasJuego.getLetras()[aleatoriaPos], fichasJuego.getValorFichas().get(fichasJuego.getLetras()[aleatoriaPos]));
            atril.setNumFichas(atril.getNumFichas()+1);
            atril.addFicha(fichaAtril);            
        }
    }
    
    public void setPrimerAtril(Fichas fichasJuego, Diccionario diccionario){
        int aleatoriaPos;
        do{
            aleatoriaPos = (int)(Math.random()*(diccionario.getMiDiccionario().size()-1));
        }while(diccionario.getMiDiccionario().get(aleatoriaPos).length()>7);
        ArrayList<String> palabraEnFicha = Palabra.arreglarLetrasPalabra(diccionario.getMiDiccionario().get(aleatoriaPos));
        for(int i = 0; i<palabraEnFicha.size(); i++){
            atril.addFicha(new Ficha(palabraEnFicha.get(i),fichasJuego.getValorFichas().get(palabraEnFicha.get(i))));
            atril.setNumFichas(atril.getNumFichas()+1);
        }
        setAtril(fichasJuego);
        Collections.shuffle(atril.getMiAtril());
    }
    
    
}
