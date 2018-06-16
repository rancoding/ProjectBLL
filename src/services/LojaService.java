/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Loja;
import helpers.LojaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class LojaService {
    
    /**
     * Gets the database shop list
     * @param hql Search query
     * @return Existent database shops
     */
    private static List<Loja> getShopList(String hql)
    {
        List<Loja> shopList = HibernateGenericLibrary.executeHQLQuery(hql);
        return shopList;
    }
    
    /**
     * Converts database shop list to helper shop list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<LojaBLL> getHelperList(String hql)
    {
        List<Loja> shopList = getShopList(hql);
        List<LojaBLL> helperList = new ArrayList<>();
        
        shopList.forEach((shop) -> {
            helperList.add(new LojaBLL(shop));
        });
        
        return helperList;
    }
}
