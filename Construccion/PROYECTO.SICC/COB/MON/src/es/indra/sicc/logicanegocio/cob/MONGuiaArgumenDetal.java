package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.belcorp.mso.CobGuionArgumCabecData;
import es.indra.belcorp.mso.CobGuionArgumDetalData;
import es.indra.belcorp.mso.CobValorArgumData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONGuiaArgumenDetal extends EJBObject {
    Vector query(CobValorArgumData cobValorArgumFrom, 
                 CobValorArgumData cobValorArgumTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, 
                 CobGuionArgumCabecData cobGuionArgumCabecTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobGuionArgumDetalData cobGuionArgumDetalFrom, 
                 CobGuionArgumDetalData cobGuionArgumDetalTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobGuionArgumDetalData cobGuionArgumDetal, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(CobGuionArgumDetalData cobGuionArgumDetal, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
