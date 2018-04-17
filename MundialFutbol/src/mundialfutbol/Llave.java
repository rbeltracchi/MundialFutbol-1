/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Llave extends EtapaMundial{

    public Llave(String descripcionEtapa) {
        super(descripcionEtapa);
    }
    @Override
    public List<Equipo> getEquiposQueAvanzan(){
        //Se considera que los equipos aca no pueden empatar.
        List<Equipo> Equipillos = new ArrayList<>();
        Partido pAComparar;
        for (Iterator<Partido> pASaber = this.getPartidos().iterator(); pASaber.hasNext();){
            //Recorre la lista de partidos para saber si gano el local o el vicitante
            pAComparar = pASaber.next();
            if(pAComparar.getResultado().ganoLocal()){
                //Verifica si gano el Local
                Equipillos.add(pAComparar.getLocal());
                System.out.println("Equipo que pasa - " + pAComparar.getLocal().getNombre());
                //Salva el equipo local que gano
            }
            else if(!pAComparar.getResultado().ganoLocal() && (!pAComparar.getResultado().empate())){
                //Verifica si gano el Visitante
                Equipillos.add(pAComparar.getVisitante());
                System.out.println("Equipo que pasa - " + pAComparar.getVisitante().getNombre());
                //Salva al equipo visitante que gano
            }
        
        }
        return Equipillos;
    }
}
