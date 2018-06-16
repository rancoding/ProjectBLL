/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Armazem;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class ArmazemBLL extends Armazem {

    public ArmazemBLL() {
    }
    
    public ArmazemBLL(Armazem warehouse)
    {
        super(warehouse.getIdarmazem(), warehouse.getLocalidade(), warehouse.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a warehouse and saves it to the database
     */
    public void create()
    {
        Armazem warehouse = new Armazem();
        warehouse.setNome(this.getNome());
        warehouse.setLocalidade(this.getLocalidade());
        HibernateGenericLibrary.saveObject(warehouse);
    }
}
