/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Caixa;

/**
 *
 * @author Gustavo Vieira
 */
public class CaixaBLL extends Caixa {

    public CaixaBLL() {
    }
    
    public CaixaBLL(Caixa box)
    {
        super(box.getId(), box.getArmazem(), box.getProduto(), box.getQuantidade());
    }
}
