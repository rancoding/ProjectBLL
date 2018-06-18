/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Venda;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class VendaBLL extends Venda {

    public VendaBLL() {
    }
    
    public VendaBLL(Venda sale)
    {
        super(sale.getIdvenda(), sale.getFuncionario(), sale.getLoja(), sale.getTipopagamento(), sale.getDatavenda(), sale.getValortotal(), sale.getValorganho(), sale.isEstado());
    }
    
    /**
     * Creates a sale and saves it to the database
     */
    public void create()
    {
        Venda sale = new Venda();
        sale.setValorganho(0);
        sale.setValortotal(0);
        sale.setLoja(this.getLoja());
        sale.setFuncionario(this.getFuncionario());
        sale.setDatavenda(this.getDatavenda());
        sale.setEstado(this.isEstado());
        HibernateGenericLibrary.saveObject(sale);
    }
    
    /**
     * Updates an existent sale on the database
     */
    public void update()
    {
        List<Venda> saleList = HibernateGenericLibrary.executeHQLQuery("FROM Venda WHERE idvenda = " + this.getIdvenda());
        Venda sale = saleList.get(0);
        sale.setTipopagamento(this.getTipopagamento());
        sale.setEstado(this.isEstado());
        HibernateGenericLibrary.updateObject(sale);
    }
}
