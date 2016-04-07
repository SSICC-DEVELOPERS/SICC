package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccProceData;
import es.indra.belcorp.mso.CccSubprData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccProceSubproce extends EJBObject {
    Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CccSubprData cccSubprFrom, CccSubprData cccSubprTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CccSubprData cccSubpr, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
