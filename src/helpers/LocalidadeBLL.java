/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Localidade;
import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class LocalidadeBLL extends Localidade {

    public LocalidadeBLL() {
    }
    
    public LocalidadeBLL(Localidade location)
    {
        super(location.getIdlocalidade(), location.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a location and saves it to the database
     */
    public void create()
    {
        Localidade location = new Localidade();
        location.setNome(this.getNome());
        HibernateGenericLibrary.saveObject(location);
    }
    
}
