/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Horario;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class HorarioBLL extends Horario {

    public HorarioBLL() {
    }
    
    public HorarioBLL(Horario schedule)
    {
        super(schedule.getIdhorario(), schedule.getHoraprimeiraentrada(), schedule.getHoraprimeirasaida(), schedule.getHorasegundaentrada(), schedule.getHorasegundasaida());
    }
    
    /**
     * Creates a schedule and saves it to the database
     */
    public void create()
    {
        Horario schedule = new Horario();
        schedule.setHoraprimeiraentrada(this.getHoraprimeiraentrada());
        schedule.setHoraprimeirasaida(this.getHoraprimeirasaida());
        schedule.setHorasegundaentrada(this.getHorasegundaentrada());
        schedule.setHorasegundasaida(this.getHorasegundasaida());
        HibernateGenericLibrary.saveObject(schedule);
    }
}
