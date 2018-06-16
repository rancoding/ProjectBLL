/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import helpers.MarcaBLL;
import dao.Marca;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class MarcaService {
    
    /**
     * Gets the database brand list
     * @param hql Search query
     * @return Existent database brands
     */
    private static List<Marca> getBrandList(String hql)
    {
        List<Marca> brandList = HibernateGenericLibrary.executeHQLQuery(hql);
        return brandList;
    }
    
    /**
     * Converts database brand list to helper brand list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<MarcaBLL> getHelperList(String hql)
    {
        List<Marca> brandList = getBrandList(hql);
        List<MarcaBLL> helperList = new ArrayList<>();
        
        brandList.forEach((brand) -> {
            helperList.add(new MarcaBLL(brand));
        });
        
        return helperList;
    }
}
