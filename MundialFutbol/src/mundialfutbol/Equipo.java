/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class Equipo {
    private String nombre;
    private List<Partido> partidosJugados;
    
    //Cree el constructor de Equipo para el default vacio
    public Equipo(){
        this.nombre="";
        this.partidosJugados =new ArrayList<>();
    }
    //cree el constructor deQuipo con parametros
    public Equipo(String nombre){
        this.nombre=nombre;
        this.partidosJugados =new ArrayList<>();
        
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    //Viendo la necesidad de utilizar esto tube que crear un add para los partidosJugados
    public void addPartidosJugados(Partido partido)
    {
        partidosJugados.add(partido);
    }
    //Debido a la necesidad de acceder a los partidos jugados por el equipo se agrego:
    public List<Partido> getPartidosJugados(){
        return this.partidosJugados;
    }
    // punto 3 del trabajo especial esta funcion deberia de devolver la diferencia de goles en total
    public int getDiferenciaDeGoles(){
        int gMetidos= 0,gRecibidos = 0,Diferencia =0;
        Partido pJugado;
        for(Iterator<Partido> jPlayed = this.partidosJugados.iterator(); jPlayed.hasNext();){
        //este for recorreria la lista de los partidos jugados por el equipo
            pJugado = jPlayed.next();   
            if(pJugado.getLocal().equals(this)){
                //Este if verifica si el equipo jugo de local en caso de serlo asigna los goles respectivamente
                gMetidos += pJugado.getResultado().getGolesLocal();
                gRecibidos += pJugado.getResultado().getGolesVisitante();
            }
            else if(pJugado.getVisitante().equals(this)){
                //Este if verifica redudantemente si el equipo jugo de visante en caso de serlo asigan los goles respectivamente
                gMetidos += pJugado.getResultado().getGolesVisitante();
                gRecibidos += pJugado.getResultado().getGolesLocal();
            }
         }
            if (gMetidos > gRecibidos){
                //Verifica si los goles metidos son mayores para restarlo.
                Diferencia = gMetidos - gRecibidos;
            }
            else if(gRecibidos > gMetidos){
                //Verifica si recibio mas que los que metio en ese caso devuelve 0.
                Diferencia = 0;
            }
            else if(gMetidos == gRecibidos){
                //En caso de que sean iguales.
                Diferencia = 0;
            }
    return Diferencia;
    }
}
