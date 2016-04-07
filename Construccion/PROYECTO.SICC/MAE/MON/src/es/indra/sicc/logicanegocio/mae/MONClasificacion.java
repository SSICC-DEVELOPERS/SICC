package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClasiData;
import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.belcorp.mso.MaeTipoClienData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONClasificacion extends EJBObject {
    Vector query(MaeTipoClienData maeTipoClienFrom, 
                 MaeTipoClienData maeTipoClienTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                 MaeSubtiClienData maeSubtiClienTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                 MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, 
                 MaeTipoClasiClienData maeTipoClasiClienTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, 
                 MaeTipoClasiClienData maeTipoClasiClienTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarClasificacion(MaeClasiData maeClasi, 
                                   Vector localizationLabels, 
                                   HashMap userProperties) throws MareException, 
                                                                  RemoteException;

    Vector query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(MaeClasiData maeClasi, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeClasi) throws MareException, RemoteException;
}
