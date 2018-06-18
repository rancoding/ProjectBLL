/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Localtrabalho;
import helpers.LocalTrabalhoBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class LocalTrabalhoService {
    /**
     * Gets the database shop list
     * @param hql Search query
     * @return Existent database shops
     */
    private static List<Localtrabalho> getWorkingLocationList(String hql)
    {
        List<Localtrabalho> shopList = HibernateGenericLibrary.executeHQLQuery(hql);
        return shopList;
    }
    
    /**
     * Converts database shop list to helper shop list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<LocalTrabalhoBLL> getHelperList(String hql)
    {
        List<Localtrabalho> workingList = getWorkingLocationList(hql);
        List<LocalTrabalhoBLL> helperList = new ArrayList<>();
        
        workingList.forEach((location) -> {
            helperList.add(new LocalTrabalhoBLL(location));
        });
        
        return helperList;
    }
}
