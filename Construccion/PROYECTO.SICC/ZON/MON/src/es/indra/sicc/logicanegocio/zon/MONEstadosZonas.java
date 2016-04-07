package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.belcorp.mso.ZonEstadZonaData;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.SegMarcaData;

public interface MONEstadosZonas extends EJBObject 
{
    Hashtable guardar(ZonEstadZonaData zonEstadZona, Vector localizationLabels, HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties) throws RemoteException, MareException;

    void update(ZonEstadZonaData zonEstadZona, Vector localizationLabels) throws RemoteException, MareException;

    void remove(Vector zonEstadZonaOids) throws MareException, RemoteException;

    Vector query(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
}