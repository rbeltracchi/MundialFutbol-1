/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public abstract class EtapaMundial {
    private   String descripcionEtapa;
    private   List<Partido> partidos;
    
    public EtapaMundial(String descripcionEtapa){
        this.descripcionEtapa=descripcionEtapa;
        this.partidos = new ArrayList<>();      
        
    }
   
    public String getDescripcionEtapa(){
        return this.descripcionEtapa;
    }
    public void addPartido(Partido Partido){
        this.partidos.add(Partido);
    }
    protected List<Partido> getPartidos(){
        return this.partidos;
    }
    public abstract List<Equipo> getEquiposQueAvanzan();
}
