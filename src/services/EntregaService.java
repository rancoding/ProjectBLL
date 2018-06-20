/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Entrega;
import helpers.EntregaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class EntregaService {
    
    /**
     * Gets the database delivery list
     * @param hql Search query
     * @return Existent database deliveries
     */
    private static List<Entrega> getDeliveryList(String hql)
    {
        List<Entrega> colorList = HibernateGenericLibrary.executeHQLQuery(hql);
        return colorList;
    }
    
    /**
     * Converts database delivery list to helper delivery list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<EntregaBLL> getHelperList(String hql)
    {
        List<Entrega> deliveryList = getDeliveryList(hql);
        List<EntregaBLL> helperList = new ArrayList<>();
        
        deliveryList.forEach((delivery) -> {
            helperList.add(new EntregaBLL(delivery));
        });
        
        return helperList;
    }
    
}
