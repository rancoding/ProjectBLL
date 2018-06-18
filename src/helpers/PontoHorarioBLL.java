/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Pontohorario;

/**
 *
 * @author Gustavo Vieira
 */
public class PontoHorarioBLL extends Pontohorario {

    public PontoHorarioBLL() {
    }

    public PontoHorarioBLL(Pontohorario point) {
        super(point.getId(), point.getFuncionario(), point.getHorario(), point.isDiasemana());
    }
    
    public void create()
    {
        
    }
    
}
