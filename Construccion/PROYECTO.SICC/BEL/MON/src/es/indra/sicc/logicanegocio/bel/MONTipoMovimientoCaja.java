package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelTipoMovimCajaData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoMovimientoCaja extends EJBObject 
{
  public Hashtable insertar(BelTipoMovimCajaData belTipoMovimCajaData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
    
  public Vector query(BelTipoMovimCajaData belTipoMovimCajaFrom, BelTipoMovimCajaData belTipoMovimCajaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
    
  public void remove(Vector belTipoMovimCaja ) throws MareException, RemoteException;
    
  public void update(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels) throws MareException, RemoteException;
}