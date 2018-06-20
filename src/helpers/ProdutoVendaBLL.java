/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Produtovenda;

/**
 *
 * @author Gustavo Vieira
 */
public class ProdutoVendaBLL extends Produtovenda {

    public ProdutoVendaBLL() {
    }
    
    public ProdutoVendaBLL(Produtovenda saleProduct)
    {
        super(saleProduct.getId(), saleProduct.getProduto(), saleProduct.getVenda(), saleProduct.getQuantidade());
    }
}
