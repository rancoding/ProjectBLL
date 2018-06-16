/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Tipopagamento;
import helpers.TipoPagamentoBLL;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class TipoPagamentoService {
    
     /**
     * Gets the database payment type list
     * @param hql Search query
     * @return Existent database payment types
     */
    private static List<Tipopagamento> getPaymentTypeList(String hql)
    {
        List<Tipopagamento> paymentTypeList = HibernateGenericLibrary.executeHQLQuery(hql);
        return paymentTypeList;
    }
    
    /**
     * Converts database payment type list to helper payment type list
     * @param hql Search query
     * @return Converted database list
     */
    public static List<TipoPagamentoBLL> getHelperList(String hql)
    {
        List<Tipopagamento> paymentTypeList = getPaymentTypeList(hql);
        List<TipoPagamentoBLL> helperList = new ArrayList<>();
        
        paymentTypeList.forEach((paymentType) -> {
            helperList.add(new TipoPagamentoBLL(paymentType));
        });
        
        return helperList;
    }
}
