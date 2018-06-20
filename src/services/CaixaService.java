/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Caixa;
import helpers.CaixaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CaixaService {
    
     /**
     * Gets the database product list
     * @param hql Search query
     * @return Existent database product
     */
    private static List<Caixa> getCaixaList(String hql)
    {
        List<Caixa> caixaList = HibernateGenericLibrary.executeHQLQuery(hql);
        return caixaList;
    }
    
    /**
     * Converts database product list to helper product list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<CaixaBLL> getHelperList(String hql)
    {
        List<Caixa> caixaList = getCaixaList(hql);
        List<CaixaBLL> helperList = new ArrayList<>();
        
        caixaList.forEach((caixa) -> {
            helperList.add(new CaixaBLL(caixa));
        });
        
        return helperList;
    }
    
}
