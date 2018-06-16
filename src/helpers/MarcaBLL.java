/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Marca;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class MarcaBLL extends Marca {

    public MarcaBLL() {
    }
    
    public MarcaBLL(Marca brand)
    {
        super(brand.getIdmarca(), brand.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a brand and saves it to the database
     */
    public void create()
    {
        Marca brand = new Marca();
        brand.setNome(this.getNome());
        HibernateGenericLibrary.saveObject(brand);
    }
    
    /**
     * Updates an existent brand on the database
     */
    public void update()
    {
        List<Marca> brandList = HibernateGenericLibrary.executeHQLQuery("FROM Marca WHERE idmarca = " + this.getIdmarca());
        Marca brand = brandList.get(0);
        brand.setNome(this.getNome());
        HibernateGenericLibrary.updateObject(brand);
    }
}
