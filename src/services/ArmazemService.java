/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Armazem;
import helpers.ArmazemBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ArmazemService {
    
    /**
     * Gets the database warehouse list
     * @param hql Search query
     * @return Existent database warehouses
     */
    private static List<Armazem> getWarehouseList(String hql)
    {
        List<Armazem> warehouseList = HibernateGenericLibrary.executeHQLQuery(hql);
        return warehouseList;
    }
    
    /**
     * Converts database warehouse list to helper warehouse list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<ArmazemBLL> getHelperList(String hql)
    {
        List<Armazem> warehouseList = getWarehouseList(hql);
        List<ArmazemBLL> helperList = new ArrayList<>();
        
        warehouseList.forEach((warehouse) -> {
            helperList.add(new ArmazemBLL(warehouse));
        });
        
        return helperList;
    }
}
