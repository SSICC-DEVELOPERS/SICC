package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.belcorp.mso.ZonEstruGeopoData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.ZonSubesGeopoData;
import java.util.Hashtable;

public interface MONEstruGeopol extends EJBObject 
{
    Vector query(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardar(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels, HashMap userProperties) throws MareException, RemoteException;

    void update(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}