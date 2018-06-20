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
 * @author Gustavo Vieira
 */
public class CaixaService {
    
    /**
     * Gets the database box list
     * @param hql Search query
     * @return Existent database boxes
     */
    private static List<Caixa> getBoxList(String hql)
    {
        List<Caixa> boxList = HibernateGenericLibrary.executeHQLQuery(hql);
        return boxList;
    }
    
    /**
     * Converts database box list to helper box list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<CaixaBLL> getHelperList(String hql)
    {
        List<Caixa> boxList = getBoxList(hql);
        List<CaixaBLL> helperList = new ArrayList<>();
        
        boxList.forEach((box) -> {
            helperList.add(new CaixaBLL(box));
        });
        
        return helperList;
    }
    
}
