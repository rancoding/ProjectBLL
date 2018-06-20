/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Entrega;
import dao.Produto;
import dao.Produtoentrega;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoEntregaBLL extends Produtoentrega {

    public ProdutoEntregaBLL() {
    }
    
    public ProdutoEntregaBLL(Produtoentrega deliveryProduct)
    {
        super(deliveryProduct.getId(), deliveryProduct.getEntrega(), deliveryProduct.getProduto(), deliveryProduct.getQuantidade());
    }
    
    public void create()
    {
        Produtoentrega deliveryProduct = new Produtoentrega();
        deliveryProduct.setEntrega(this.getEntrega());
        deliveryProduct.setProduto(this.getProduto());
        deliveryProduct.setQuantidade(this.getQuantidade());
        HibernateGenericLibrary.saveObject(deliveryProduct);
    }
}
