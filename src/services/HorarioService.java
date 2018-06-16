/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Horario;
import helpers.HorarioBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class HorarioService {
    
    /**
     * Gets the database schedule list
     * @param hql Search query
     * @return Existent database schedules
     */
    private static List<Horario> getScheduleList(String hql)
    {
        List<Horario> scheduleList = HibernateGenericLibrary.executeHQLQuery(hql);
        return scheduleList;
    }
    
    /**
     * Converts database schedule list to helper schedule list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<HorarioBLL> getHelperList(String hql)
    {
        List<Horario> scheduleList = getScheduleList(hql);
        List<HorarioBLL> helperList = new ArrayList<>();
        
        scheduleList.forEach((schedule) -> {
            helperList.add(new HorarioBLL(schedule));
        });
        
        return helperList;
    }
}
