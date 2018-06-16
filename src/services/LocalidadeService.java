/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Localidade;
import helpers.LocalidadeBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class LocalidadeService {
    
    /**
     * Gets the database location list
     * @param hql Search query
     * @return Existent database locations
     */
    private static List<Localidade> getLocationList(String hql)
    {
        List<Localidade> locationList = HibernateGenericLibrary.executeHQLQuery(hql);
        return locationList;
    }
    
    /**
     * Converts database location list to helper location list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<LocalidadeBLL> getHelperList(String hql)
    {
        List<Localidade> locationList = getLocationList(hql);
        List<LocalidadeBLL> helperList = new ArrayList<>();
        
        locationList.forEach((location) -> {
            helperList.add(new LocalidadeBLL(location));
        });
        
        return helperList;
    }
}
