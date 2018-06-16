/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Tamanho;
import helpers.TamanhoBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class TamanhoService {
    
    /**
     * Gets the database size list
     * @param hql Search query
     * @return Existent database sizes
     */
    private static List<Tamanho> getSizeList(String hql)
    {
        List<Tamanho> sizeList = HibernateGenericLibrary.executeHQLQuery(hql);
        return sizeList;
    }
    
    /**
     * Converts database size list to helper size list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<TamanhoBLL> getHelperList(String hql)
    {
        List<Tamanho> sizeList = getSizeList(hql);
        List<TamanhoBLL> helperList = new ArrayList<>();
        
        sizeList.forEach((size) -> {
            helperList.add(new TamanhoBLL(size));
        });
        
        return helperList;
    }
}
