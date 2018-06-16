/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Tipoproduto;
import helpers.TipoProdutoBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class TipoProdutoService {
    
     /**
     * Gets the database product type list
     * @param hql Search query
     * @return Existent database product types
     */
    private static List<Tipoproduto> getProductTypeList(String hql)
    {
        List<Tipoproduto> productTypeList = HibernateGenericLibrary.executeHQLQuery(hql);
        return productTypeList;
    }
    
    /**
     * Converts database product type list to helper product type list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<TipoProdutoBLL> getHelperList(String hql)
    {
        List<Tipoproduto> productTypeList = getProductTypeList(hql);
        List<TipoProdutoBLL> helperList = new ArrayList<>();
        
        productTypeList.forEach((productType) -> {
            helperList.add(new TipoProdutoBLL(productType));
        });
        
        return helperList;
    }
}
