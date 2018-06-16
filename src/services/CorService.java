/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Cor;
import helpers.CorBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class CorService {
    
    /**
     * Gets the database color list
     * @param hql Search query
     * @return Existent database colors
     */
    private static List<Cor> getColorList(String hql)
    {
        List<Cor> colorList = HibernateGenericLibrary.executeHQLQuery(hql);
        return colorList;
    }
    
    /**
     * Converts database color list to helper color list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<CorBLL> getHelperList(String hql)
    {
        List<Cor> colorList = getColorList(hql);
        List<CorBLL> helperList = new ArrayList<>();
        
        colorList.forEach((color) -> {
            helperList.add(new CorBLL(color));
        });
        
        return helperList;
    }
}
