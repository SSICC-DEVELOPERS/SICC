package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.belcorp.mso.ZonNivelGeogrData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import java.util.Hashtable;

public interface MONNivelGeografico extends EJBObject 
{
    Vector query(ZonNivelGeogrData zonNivelGeogrFrom, ZonNivelGeogrData zonNivelGeogrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

    Hashtable guardar(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels, HashMap userProperties) throws RemoteException, MareException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels) throws MareException, RemoteException;
}