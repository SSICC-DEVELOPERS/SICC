package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.belcorp.mso.CccCuentContaData;
import es.indra.belcorp.mso.CccCuentCorriBancaData;
import es.indra.belcorp.mso.CccSucurData;
import es.indra.belcorp.mso.SegSocieData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCCCCuentaCorrient extends EJBObject {
    Vector query(CccCuentContaData cccCuentContaFrom, 
                 CccCuentContaData cccCuentContaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guradarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(CccCuentCorriBancaData cccCuentCorriBancaFrom, 
                 CccCuentCorriBancaData cccCuentCorriBancaTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CccCuentCorriBancaData cccCuentCorriBanca, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccCuentCorriBanca) throws MareException, 
                                                  RemoteException;
}
