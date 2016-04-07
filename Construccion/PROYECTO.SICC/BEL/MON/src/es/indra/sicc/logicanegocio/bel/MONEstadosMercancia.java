package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelEstadMercaData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONEstadosMercancia extends EJBObject 
{
    public Hashtable insertar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
   
    public Vector query(BelEstadMercaData belEstadMercaFrom, BelEstadMercaData belEstadMercaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
    
    public void remove(Vector belEstadMerca ) throws MareException, RemoteException;
    
    public void update(BelEstadMercaData belEstadMercaData, Vector localizationLabels) throws MareException, RemoteException;

}