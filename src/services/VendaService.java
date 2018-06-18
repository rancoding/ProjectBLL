/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Venda;
import helpers.VendaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class VendaService {
    
    /**
     * Gets the database sale list
     * @param hql Search query
     * @return Existent database sales
     */
    private static List<Venda> getSaleList(String hql)
    {
        List<Venda> saleList = HibernateGenericLibrary.executeHQLQuery(hql);
        return saleList;
    }
    
    /**
     * Converts database sale list to helper sale list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<VendaBLL> getHelperList(String hql)
    {
        List<Venda> saleList = getSaleList(hql);
        List<VendaBLL> helperList = new ArrayList<>();
        
        saleList.forEach((sale) -> {
            helperList.add(new VendaBLL(sale));
        });
        
        return helperList;
    }
}
