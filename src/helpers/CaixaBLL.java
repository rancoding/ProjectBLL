/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Caixa;

import hibernate.HibernateGenericLibrary;
import java.util.List;

public class CaixaBLL extends Caixa{
    
     public CaixaBLL() {
    }
    
    public CaixaBLL(Caixa box)
    {
        super(box.getId(), box.getArmazem(), box.getProduto(), box.getQuantidade());
    }
    
//
//    @Override
//    public String toString() {
//        return super.getProduto();
//    }
//    
    
    /**
     * Creates a color and saves it to the database
     */
    public void create()
    {
        Caixa box = new Caixa();
        box.setArmazem(this.getArmazem());
        box.setProduto(this.getProduto());
        box.setId(this.getId());
        box.setQuantidade(this.getQuantidade());
        HibernateGenericLibrary.saveObject(box);
    }
    
    /**
     * Updates an existent color on the database
     */
    public void update()
    {
        List<Caixa> caixaList = HibernateGenericLibrary.executeHQLQuery("FROM Caixa WHERE idCaixa = " + this.getId());
        Caixa box = caixaList.get(0);
        box.setArmazem(this.getArmazem());
        box.setProduto(this.getProduto());
        box.setId(this.getId());
        box.setQuantidade(this.getQuantidade());
        HibernateGenericLibrary.updateObject(box);
    }
}
