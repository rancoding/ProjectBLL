/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Produto;
import helpers.ProdutoBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoService {
    
    /**
     * Gets the database product list
     * @param hql Search query
     * @return Existent database product
     */
    private static List<Produto> getProdutoList(String hql)
    {
        List<Produto> productList = HibernateGenericLibrary.executeHQLQuery(hql);
        return productList;
    }
    
    /**
     * Converts database product list to helper product list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<ProdutoBLL> getHelperList(String hql)
    {
        List<Produto> productList = getProdutoList(hql);
        List<ProdutoBLL> helperList = new ArrayList<>();
        
        productList.forEach((product) -> {
            helperList.add(new ProdutoBLL(product));
        });
        
        return helperList;
    }
}
