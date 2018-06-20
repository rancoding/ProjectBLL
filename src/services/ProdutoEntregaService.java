/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Produtoentrega;
import helpers.ProdutoEntregaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoEntregaService {
    
    /**
     * Gets the database delivery product list
     * @param hql Search query
     * @return Existent database delivery products
     */
    private static List<Produtoentrega> getDeliveryProductList(String hql)
    {
        List<Produtoentrega> productList = HibernateGenericLibrary.executeHQLQuery(hql);
        return productList;
    }
    
    /**
     * Converts database delivery product list to helper delivery product list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<ProdutoEntregaBLL> getHelperList(String hql)
    {
        List<Produtoentrega> deliveryProductList = getDeliveryProductList(hql);
        List<ProdutoEntregaBLL> helperList = new ArrayList<>();
        
        deliveryProductList.forEach((deliveryProduct) -> {
            helperList.add(new ProdutoEntregaBLL(deliveryProduct));
        });
        
        return helperList;
    }
    
}
