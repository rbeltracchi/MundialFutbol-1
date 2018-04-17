/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;

/**
 *
 * @author Administrador
 */
public class Resultado {
    private int golesLocal;
    private int golesVisitante;
    
    //A falta del constructor en vacio tambien se creo uno
    public Resultado(){
        this.golesLocal=0;
        this.golesVisitante=0;
    }
    //Se crearon los Sets respectivamente de los atributos de Resultado
    public void setGolesLocal(int goles){
        this.golesLocal=goles;
    }
    public void setGolesVisitante(int goles){
        this.golesVisitante=goles;
    }
    //A falta del constructor
    public Resultado(int golesLocal,int golesVisitante){
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
    
    public int getGolesLocal(){
        return golesLocal;
    }
    public int getGolesVisitante(){
        return golesVisitante;
    }
    public boolean ganoLocal(){
        if(this.golesLocal > this.golesVisitante){
            return true;
        }
        return false;
    }
    public boolean empate(){
        if(this.golesLocal == this.golesVisitante){
            return true;
        }
        return false;
    }
}
