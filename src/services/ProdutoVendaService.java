/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Produtovenda;
import helpers.ProdutoVendaBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoVendaService {
    
    /**
     * Gets the database sale product list
     * @param hql Search query
     * @return Existent database sale products
     */
    private static List<Produtovenda> getSaleProductList(String hql)
    {
        List<Produtovenda> saleProductList = HibernateGenericLibrary.executeHQLQuery(hql);
        return saleProductList;
    }
    
    /**
     * Converts database sale product list to helper sale product list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<ProdutoVendaBLL> getHelperList(String hql)
    {
        List<Produtovenda> saleProductList = getSaleProductList(hql);
        List<ProdutoVendaBLL> helperList = new ArrayList<>();
        
        saleProductList.forEach((saleProduct) -> {
            helperList.add(new ProdutoVendaBLL(saleProduct));
        });
        
        return helperList;
    }
}
