package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCondiPromoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCondicionPromocion extends EJBObject {
    Vector query(PreCondiPromoData preCondiPromoFrom, 
                 PreCondiPromoData preCondiPromoTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
