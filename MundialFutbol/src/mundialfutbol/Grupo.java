/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author Administrador
 */
public class Grupo extends EtapaMundial {
    //Viendo la necesidad de saber cuantos equipos pasan se decidio crear una constante final solo para grupo.
    final static private int EQUIPOSQUEPASAN = 2;
    public Grupo(String descripcionEtapa) {
        //super(descripcionEtapa);
        super("Estamos en grupo");
    }
    private int pointEquipo(Equipo equipo){
        //Esta funcion devuelve los puntos del equipo
        int points = 0;
        Partido pJugado;
        //Un recorrido por la lista de los partidos jugados por este equipo en el Grupo
        for (Iterator<Partido> partidosPlayed = this.getPartidos().iterator(); partidosPlayed.hasNext();){
           pJugado = partidosPlayed.next();
           //este if divide en dos ramas la comparacion, para los puntos si el equipo jugo 
           //de local o de visitante.          
           if (pJugado.getLocal().equals(equipo)){
               if(pJugado.getResultado().ganoLocal()){
                   //Verifica si el equipo local gano, en caso de ganar le aumenta 3 a los puntos.
                   points +=3;
               }
           }
           else if(pJugado.getVisitante().equals(equipo)){
               //este "else if es para verificar (redundantemente) si el equipo jugo de vistante
               if(!pJugado.getResultado().ganoLocal()&& !pJugado.getResultado().empate()){
                   //Si no gano local y no empato, quiere decir que gano el visitante.
                   points +=3;
               }
            }
            if((pJugado.getLocal().equals(equipo)||pJugado.getVisitante().equals(equipo))&&pJugado.getResultado().empate()){
                //Este if se fija si empataros y verifica redundantemente si el equipo jugo de visitante o de local
                  points +=1;
            }             
        }        
        return points;
    }
    private boolean Existe(List<Equipo> aPasar, Equipo equipoPasa ){
        //esta funcion recorre la lista de equipos que van a pasar a la siguiente ronda
        //para saber si el equipo que esta contemplando ya existe en esta lista
        for(Iterator<Equipo> ePasados = aPasar.iterator();ePasados.hasNext();){
            //Recorre la lista de equipos..
            if (equipoPasa.equals(ePasados.next())){
                //Verifica que el equipo recibido por parametros, esta dentro de la lista antes mencionada.
                return true;
            }
        }
        return false;       
    }
    @Override
    public List<Equipo> getEquiposQueAvanzan(){
        List<Equipo> aPasarEquipos = new ArrayList<>();
        Partido partidoAComparar;
        Equipo equipoPasa= new Equipo();
        for (int cantEquiposAPasar = 0; cantEquiposAPasar < EQUIPOSQUEPASAN; cantEquiposAPasar ++){
            //Este for se encarga de encontrar la cantidad de Equipos que deben pasar.
            for (Iterator<Partido> partidoASaber= super.getPartidos().iterator(); partidoASaber.hasNext();){
                //El for de aca recorre la lista de los partidos jugados por el grupo.
                partidoAComparar = partidoASaber.next();
                if ((pointEquipo(partidoAComparar.getLocal()) > pointEquipo(partidoAComparar.getVisitante()))&& !Existe(aPasarEquipos,partidoAComparar.getLocal())){
                    //Se compara los puntos del local contra los del vicitante y se verifica que el equipo local no exista
                    //En la lista de los que van a pasar.
                    if (!equipoPasa.equals(partidoAComparar.getLocal())&&(pointEquipo(equipoPasa)<pointEquipo(partidoAComparar.getLocal()))){
                        //Este if verifica si el equipo local es diferente al equipo que tengo como mayor y es mayor que este mismo
                        equipoPasa =partidoAComparar.getLocal();
                        //Aca se salva el local en caso de que sea el que tenga mas puntos
                    }
                }
                else if(((pointEquipo(partidoAComparar.getVisitante()) > pointEquipo(partidoAComparar.getLocal()))&& !Existe(aPasarEquipos,partidoAComparar.getVisitante()))){
                    //Se comprar los puntos del visitante contra el local y se verifica que el local no exista
                    //en la lista de los que van a pasar.
                    if (!equipoPasa.equals(partidoAComparar.getVisitante())&&(pointEquipo(equipoPasa)<pointEquipo(partidoAComparar.getVisitante()))){
                        //Este if verifica si el equipo Visitante es diferente al equipo que tengo como mayor
                        //Y si los puntos son mayores.
                            equipoPasa =partidoAComparar.getVisitante();
                            //Se salva el visitante en caso de que tenga mas puntos.
                        }
                      
                    }           
                }    
            aPasarEquipos.add(equipoPasa);
            System.out.println("Equipo con mas puntos: "+ equipoPasa.getNombre() + " Puntos: " + pointEquipo(equipoPasa));
            //Se agrega el equipo con mayor puntaje en la lista
            equipoPasa = new Equipo();
            //se vacia el equipo para evitar errores
            }
         return aPasarEquipos;
    }
}
