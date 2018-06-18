/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Pontohorario;
import helpers.PontoHorarioBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class PontoHorarioService {
    
    /**
     * Gets the database point list
     * @param hql Search query
     * @return Existent database points
     */
    private static List<Pontohorario> getSchedulePointList(String hql)
    {
        List<Pontohorario> pointList = HibernateGenericLibrary.executeHQLQuery(hql);
        return pointList;
    }
    
    /**
     * Converts database point list to helper point list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<PontoHorarioBLL> getHelperList(String hql)
    {
        List<Pontohorario> pointList = getSchedulePointList(hql);
        List<PontoHorarioBLL> helperList = new ArrayList<>();
        
        pointList.forEach((point) -> {
            helperList.add(new PontoHorarioBLL(point));
        });
        
        return helperList;
    }
}
