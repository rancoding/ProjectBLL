/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Entrega;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class EntregaBLL extends Entrega {

    public EntregaBLL() {
    }
    
    public EntregaBLL(Entrega delivery)
    {
        super(delivery.getIdentrega(), delivery.getArmazem(), delivery.getFuncionarioByIdfuncionarioentrega(), delivery.getFuncionarioByIdfuncionariorecebe(),
              delivery.getLoja(), delivery.getDataenvio(), delivery.getDataentrega(), delivery.isConfirmado(), delivery.isEntregue(), delivery.isEnviado());
    }
    
    public void create()
    {
        Entrega delivery = new Entrega();
        delivery.setArmazem(this.getArmazem());
        delivery.setLoja(this.getLoja());
        delivery.setConfirmado(this.isConfirmado());
        delivery.setEntregue(this.isEntregue());
        delivery.setEnviado(this.isEnviado());
        if(this.getFuncionarioByIdfuncionarioentrega() != null) { delivery.setFuncionarioByIdfuncionarioentrega(this.getFuncionarioByIdfuncionarioentrega()); }
        if(this.getFuncionarioByIdfuncionariorecebe()!= null) { delivery.setFuncionarioByIdfuncionariorecebe(this.getFuncionarioByIdfuncionariorecebe()); }
        if(this.getDataenvio()!= null) { delivery.setDataenvio(this.getDataenvio()); }
        if(this.getDataentrega()!= null) { delivery.setDataentrega(this.getDataentrega()); }
        HibernateGenericLibrary.saveObject(delivery);
    }
}
