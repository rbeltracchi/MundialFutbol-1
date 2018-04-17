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
public class MundialFutbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creacion de Objetos de Equipo.
        Equipo Equipo1 = new Equipo("Rusia");
        Equipo Equipo2 = new Equipo();
        Equipo2.setNombre("Arabia Saudi");
        Equipo Equipo3 = new Equipo("Egipto");
        Equipo Equipo4 = new Equipo();
        Equipo4.setNombre("Uruguay");
        //Fin de la creacion de objetos de equipos.
        
        //Cargando partidos

        //Partido 1
        Partido Partido1 = new Partido();
        Date Fecha1;
        Fecha1= new Date(118,5,14);
        Partido1.setFecha(Fecha1);
        Partido1.setLocal(Equipo1);
        Partido1.setVisitante(Equipo2);
        //Relacion de los equipos con los partidos
        Equipo1.addPartidosJugados(Partido1);
        Equipo2.addPartidosJugados(Partido1);
        //Partido2
        Date Fecha2;
        Fecha2= new Date(118,5,14);
        Partido Partido2 = new Partido(Fecha2,Equipo3,Equipo2);
        //Relacion de los equipos con los partidos
        Equipo3.addPartidosJugados(Partido2);
        Equipo2.addPartidosJugados(Partido2);
        //Partido3
        Date Fecha3;
        Fecha3= new Date(118,5,19);
        Partido Partido3 = new Partido(Fecha3,Equipo1,Equipo3);
        //Relacion de los equipos con los partidos
        Equipo1.addPartidosJugados(Partido3);
        Equipo3.addPartidosJugados(Partido3);
        //Partido4
        Date Fecha4;
        Fecha4= new Date(118,5,20);
        Partido Partido4 = new Partido(Fecha4,Equipo4,Equipo2);
        //Relacion de los equipos con los partidos
        Equipo4.addPartidosJugados(Partido4);
        Equipo2.addPartidosJugados(Partido4);
        //Partido 5
        Date Fecha5;
        Fecha5= new Date(118,5,25);
        Partido Partido5 = new Partido(Fecha5,Equipo2,Equipo3);
        //Relacion de los equipos con los partidos
        Equipo3.addPartidosJugados(Partido5);
        Equipo2.addPartidosJugados(Partido5);
        // Partido 6
        Date Fecha6;
        Fecha6= new Date(118,5,25);
        Partido Partido6 = new Partido(Fecha6,Equipo4,Equipo1);
        //Relacion de los equipos con los partidos
        Equipo1.addPartidosJugados(Partido6);
        Equipo4.addPartidosJugados(Partido6);
        // Final de creacion de Partidos
        
        //Creacion de los resultados respectivos a los partidos de los grupos disputados.
        //Resultado 1
        Resultado Resultado1 = new Resultado();
        Resultado1.setGolesLocal(2);
        Resultado1.setGolesVisitante(1);
        //Relacion del Partido1 con el Resultado1
        Partido1.setResultado(Resultado1);
        //Resultado2
        Resultado Resultado2 = new Resultado(2,1);
        //Relacion del partido con su resultado
        Partido2.setResultado(Resultado2);
        //Resultado3
        Resultado Resultado3 = new Resultado(1,2);
        //Relacion del partido con su resultado
        Partido3.setResultado(Resultado3);
        //Resultado4
        Resultado Resultado4 = new Resultado(3,0);
        //Relacion del partido con su resultado
        Partido4.setResultado(Resultado4);
        //Resultado5
        Resultado Resultado5 = new Resultado(0,2);
        //Relacion del partido con su resultado
        Partido5.setResultado(Resultado5);
        //Resultado6
        Resultado Resultado6 = new Resultado(1,4);
        //Relacion del partido con su resultado
        Partido6.setResultado(Resultado6);
        //Fin de la carga de Resultados.
        
        //Etapa mundial Grupos
        EtapaMundial EtapaGrupo = new Grupo("Grupo A");        
        //Relacion de los partidos con la Etapa del Grupo A
        EtapaGrupo.addPartido(Partido1);
        EtapaGrupo.addPartido(Partido2);
        EtapaGrupo.addPartido(Partido3);
        EtapaGrupo.addPartido(Partido4);
        EtapaGrupo.addPartido(Partido5);
        EtapaGrupo.addPartido(Partido6);
        //Fin de la relacion de los partidos
        EtapaGrupo.getEquiposQueAvanzan();
        //Caso para demostrar que los equipos que avanzan son correctos
        
        //Etapa mundial de llaves
        EtapaMundial EtapaLlave = new Llave("Final");
        //Creacion de partido de llave
        Date FechaF;
        FechaF= new Date(118,5,29);
        Partido PartidoF = new Partido(FechaF,Equipo1,Equipo3);
        //Relacion de los partidos con los equipos
        Equipo1.addPartidosJugados(PartidoF);
        Equipo3.addPartidosJugados(PartidoF);
        //Creacion de resultado
        Resultado ResultadoF = new Resultado(8,7);
        //Relacion del partido con su resultado
        PartidoF.setResultado(ResultadoF);
        //Fin de la Creacion de la llave
        
        //Cargo el partido a la Etapa de LLaves
        EtapaLlave.addPartido(PartidoF);
        //Fin de la carga
        // Decoracion para ver la "final" de manera legible
        System.out.println(PartidoF.toString());
              
        //
        EtapaLlave.getEquiposQueAvanzan();
        //Caso para demostrar los que avanzan
        
        
        //Testeo de diferencia de goles
        System.out.println("El Equipo: "+Equipo1.getNombre() +" Tuvo una diferencia de goles de: " +Equipo1.getDiferenciaDeGoles());
      
        
        
    }

          
}
