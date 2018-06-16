/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Funcionario;
import helpers.FuncionarioBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class FuncionarioService {
    
    /**
     * Gets the database employee list
     * @param hql Search query
     * @return Existent database employees
     */
    private static List<Funcionario> getEmployeeList(String hql)
    {
        List<Funcionario> employeeList = HibernateGenericLibrary.executeHQLQuery(hql);
        return employeeList;
    }
    
    /**
     * Converts database employee list to helper employee list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<FuncionarioBLL> getHelperList(String hql)
    {
        List<Funcionario> employeeList = getEmployeeList(hql);
        List<FuncionarioBLL> helperList = new ArrayList<>();
        
        employeeList.forEach((employee) -> {
            helperList.add(new FuncionarioBLL(employee));
        });
        
        return helperList;
    }
}
