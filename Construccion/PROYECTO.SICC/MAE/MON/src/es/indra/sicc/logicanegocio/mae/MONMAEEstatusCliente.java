package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstatClienData;
import es.indra.belcorp.mso.MaeEstatClienViewData;
import es.indra.belcorp.mso.MaeTipoEstatClienViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMAEEstatusCliente extends EJBObject {
    Vector query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, 
                 MaeTipoEstatClienViewData maeTipoEstatClienViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeEstatClienViewData maeEstatClienViewFrom, 
                 MaeEstatClienViewData maeEstatClienViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarEstatusCliente(MaeEstatClienData maeEstatClien, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(MaeEstatClienData maeEstatClienFrom, 
                 MaeEstatClienData maeEstatClienTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeEstatClienData maeEstatClien, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeEstatClien) throws MareException, RemoteException;
}
