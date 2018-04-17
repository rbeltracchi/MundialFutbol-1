/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundialfutbol;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Administrador
 */
public class Partido {
    private Date fecha;
    private Equipo local;
    private Equipo visitante;
    private Resultado resultado;
    
    //A falta del creador de partido en vacio se realizo la
    public Partido(){
        this.fecha = new Date();
        this.local = new Equipo();
        this.visitante = new Equipo();
        this.resultado = new Resultado();
    }
    
     public  Partido(Date Fecha,Equipo Local, Equipo Visitante){
        this.fecha=Fecha;
        this.local=Local;
        this.visitante=Visitante;
    }
    public  Resultado getResultado(){
        return this.resultado;
    }
    public Equipo getLocal(){
        return this.local;
    }
    public Equipo getVisitante(){
        return this.visitante;
    }
    //Debido a la falta de este cree un setResultado;
    public void setResultado(Resultado resultado){
        this.resultado = resultado;
    }
    //Debido a la falta de el resto de los set. se agregaron
    public void setLocal(Equipo Equipo){
        this.local=Equipo;
    }
     public void setVisitante(Equipo Equipo){
        this.visitante=Equipo;
    }
    public void setFecha(Date Fecha){
        this.fecha=Fecha;
    }
    public Date getFecha(){
        return this.fecha;
    }
    @Override
    public String toString(){
        SimpleDateFormat fFecha = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY");
        return "El partido lo disputaran: "+this.local.getNombre() + " vs " + this.visitante.getNombre() + "\nLa Fecha : "+ fFecha.format(fecha);
    }
}
