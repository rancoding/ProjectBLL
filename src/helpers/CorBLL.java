/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Cor;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class CorBLL extends Cor {

    public CorBLL() {
    }
    
    public CorBLL(Cor color)
    {
        super(color.getIdcor(), color.getNome());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates a color and saves it to the database
     */
    public void create()
    {
        Cor color = new Cor();
        color.setNome(this.getNome());
        HibernateGenericLibrary.saveObject(color);
    }
    
    /**
     * Updates an existent color on the database
     */
    public void update()
    {
        List<Cor> colorList = HibernateGenericLibrary.executeHQLQuery("FROM Cor WHERE idcor = " + this.getIdcor());
        Cor color = colorList.get(0);
        color.setNome(this.getNome());
        HibernateGenericLibrary.updateObject(color);
    }
}
