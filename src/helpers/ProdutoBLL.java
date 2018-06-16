/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Produto;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoBLL extends Produto {

    public ProdutoBLL() {
    }
    
    public ProdutoBLL(Produto product)
    {
        super(product.getCodbarras(), product.getCor(), product.getMarca(), product.getTamanho(), product.getTipoproduto(), product.getDescricao(), product.getPrecocompra(), product.getPrecovenda(), product.getGenero());
    }

    @Override
    public String toString() {
        return super.getDescricao();
    }
    
    /**
     * Creates a product and saves it to the database
     */
    public void create()
    {
        Produto product = new Produto();
        product.setCodbarras(this.getCodbarras());
        product.setDescricao(this.getDescricao());
        product.setMarca(this.getMarca());
        product.setTamanho(this.getTamanho());
        product.setCor(this.getCor());
        product.setTipoproduto(this.getTipoproduto());
        product.setGenero(this.getGenero());
        product.setPrecocompra(this.getPrecocompra());
        product.setPrecovenda(this.getPrecovenda());
        HibernateGenericLibrary.saveObject(product);
    }

    /**
     * Updates an existent product on the database
     */
    public void update()
    {
        List<Produto> productList = HibernateGenericLibrary.executeHQLQuery("FROM Produto WHERE codbarras = " + this.getCodbarras());
        Produto product = productList.get(0);
        product.setCodbarras(this.getCodbarras());
        product.setDescricao(this.getDescricao());
        product.setMarca(this.getMarca());
        product.setTamanho(this.getTamanho());
        product.setTipoproduto(this.getTipoproduto());
        product.setGenero(this.getGenero());
        product.setCor(this.getCor());
        product.setPrecocompra(this.getPrecocompra());
        product.setPrecovenda(this.getPrecovenda());
        HibernateGenericLibrary.updateObject(product);
    }
    
}
