package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CccTipoCargoAbonoData;
import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEtapaDeDeudaTipoCargo extends EJBObject {
    Vector query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, 
                 CccTipoCargoAbonoData cccTipoCargoAbonoTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, 
                 CobEtapaDeudaData cobEtapaDeudaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, 
                 CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
