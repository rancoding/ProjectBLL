/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Localtrabalho;

/**
 *
 * @author Gustavo Vieira
 */
public class LocalTrabalhoBLL extends Localtrabalho {

    public LocalTrabalhoBLL() {
    }
    
    public LocalTrabalhoBLL(Localtrabalho workingLocation)
    {
        super(workingLocation.getIdlocaltrabalho());
    }
}
