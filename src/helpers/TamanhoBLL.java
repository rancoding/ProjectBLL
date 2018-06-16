/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Tamanho;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class TamanhoBLL extends Tamanho {

    public TamanhoBLL() {
    }
    
    public TamanhoBLL(Tamanho size)
    {
        super(size.getIdtamanho(), size.getDescricao());
    }

    @Override
    public String toString() {
        return super.getDescricao();
    }
    
    /**
     * Creates a size and saves it to the database
     */
    public void create()
    {
        Tamanho size = new Tamanho();
        size.setDescricao(this.getDescricao());
        HibernateGenericLibrary.saveObject(size);
    }
    
    /**
     * Updates an existent size on the database
     */
    public void update()
    {
        List<Tamanho> sizeList = HibernateGenericLibrary.executeHQLQuery("FROM Tamanho WHERE idtamanho = " + this.getIdtamanho());
        Tamanho size = sizeList.get(0);
        size.setDescricao(this.getDescricao());
        HibernateGenericLibrary.updateObject(size);
    }
}
