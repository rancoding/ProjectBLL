/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.Funcionario;
import hibernate.HibernateGenericLibrary;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class FuncionarioBLL extends Funcionario {

    public FuncionarioBLL() {
    }
    
    public FuncionarioBLL(Funcionario employee)
    {
        super(employee.getIdfuncionario(), employee.getHorario(), employee.getLocaltrabalho(), employee.getNome(), employee.getUsername(), employee.getPassword(),
              employee.getDatanascimento(), employee.getSexo(), employee.isActivo(), employee.isTipo(), employee.getMorada(), employee.getEntregasForIdfuncionarioentrega(),
              employee.getEntregasForIdfuncionariorecebe(), employee.getVendas(), employee.getPontohorarios());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    /**
     * Creates an employee and saves it to the database
     */
    public void create()
    {
        Funcionario employee = new Funcionario();
        employee.setNome(this.getNome());
        employee.setUsername(this.getUsername());
        employee.setPassword(this.getPassword());
        employee.setDatanascimento(this.getDatanascimento());
        employee.setSexo(this.getSexo());
        employee.setActivo(this.isActivo());
        employee.setTipo(this.isTipo());
        employee.setMorada(this.getMorada());
        
        //Horario schedule = this.getHorario();
        employee.setHorario(this.getHorario());
        
        //Localtrabalho workingLocation = this.getLocaltrabalho();
        employee.setLocaltrabalho(this.getLocaltrabalho());
        
        HibernateGenericLibrary.saveObject(employee);
    }
    
    /**
     * Updates an existent brand on the database
     */
    public void update()
    {
        List<Funcionario> employeeList = HibernateGenericLibrary.executeHQLQuery("FROM Funcionario WHERE idfuncionario = " + this.getIdfuncionario());
        Funcionario employee = employeeList.get(0);
        employee.setNome(this.getNome());
        employee.setUsername(this.getUsername());
        employee.setPassword(this.getPassword());
        employee.setDatanascimento(this.getDatanascimento());
        employee.setSexo(this.getSexo());
        employee.setActivo(this.isActivo());
        employee.setTipo(this.isTipo());
        employee.setMorada(this.getMorada());
        HibernateGenericLibrary.updateObject(employee);
    }
}
