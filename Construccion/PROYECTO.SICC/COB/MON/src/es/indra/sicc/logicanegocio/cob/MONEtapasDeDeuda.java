package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobGuionArgumCabecViewData;
import es.indra.belcorp.mso.CobOrdenEtapaDeudaData;
import es.indra.belcorp.mso.CobTipoBalanData;
import es.indra.belcorp.mso.MsgMensaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEtapasDeDeuda extends EJBObject {
    Vector query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, 
                 CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobTipoBalanData cobTipoBalanFrom, 
                 CobTipoBalanData cobTipoBalanTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, 
                 CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, 
                 CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    Hashtable guardar(CobEtapaDeudaData cobEtapaDeuda, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobEtapaDeudaData cobEtapaDeuda, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
