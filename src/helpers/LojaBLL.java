/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Loja;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class LojaBLL extends Loja {

    public LojaBLL() {
    }
    
    public LojaBLL(Loja shop)
    {
        super(shop.getIdloja(), shop.getLocalidade(), shop.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a shop and saves it to the database
     */
    public void create()
    {
        Loja shop = new Loja();
        shop.setNome(this.getNome());
        shop.setLocalidade(this.getLocalidade());
        HibernateGenericLibrary.saveObject(shop);
    }
}
