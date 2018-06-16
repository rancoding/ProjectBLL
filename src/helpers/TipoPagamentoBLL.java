/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Tipopagamento;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class TipoPagamentoBLL extends Tipopagamento {

    public TipoPagamentoBLL() {
    }
    
    public TipoPagamentoBLL(Tipopagamento paymentType)
    {
        super(paymentType.getIdtipopagamento(), paymentType.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a payment type and saves it to the database
     */
    public void create()
    {
        Tipopagamento paymentType = new Tipopagamento();
        paymentType.setNome(this.getNome());
        HibernateGenericLibrary.saveObject(paymentType);
    }
    
}
