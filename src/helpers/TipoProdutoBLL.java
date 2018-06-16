/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Tipoproduto;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class TipoProdutoBLL extends Tipoproduto {

    public TipoProdutoBLL() {
    }
    
    public TipoProdutoBLL(Tipoproduto productType)
    {
        super(productType.getIdtipoproduto(), productType.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a product type and saves it to the database
     */
    public void create()
    {
        Tipoproduto productType = new Tipoproduto();
        productType.setNome(this.getNome());
        HibernateGenericLibrary.saveObject(productType);
    }
    
    /**
     * Updates an existent product type on the database
     */
    public void update()
    {
        List<Tipoproduto> productTypeList = HibernateGenericLibrary.executeHQLQuery("FROM Tipoproduto WHERE idtipoproduto = " + this.getIdtipoproduto());
        Tipoproduto productType = productTypeList.get(0);
        productType.setNome(this.getNome());
        HibernateGenericLibrary.updateObject(productType);
    }
}
