package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.belcorp.mso.ZonSubesGeopoData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;

public interface MONSubesGeopol extends EJBObject 
{
    Vector query(ZonSubesGeopoData zonSubesGeopoFrom, ZonSubesGeopoData zonSubesGeopoTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, RemoteException;
}