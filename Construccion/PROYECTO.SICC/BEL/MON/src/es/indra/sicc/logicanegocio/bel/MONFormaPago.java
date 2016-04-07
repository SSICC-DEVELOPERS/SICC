package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelFormaPagoData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONFormaPago extends EJBObject 
{

 public Hashtable insertar(BelFormaPagoData belFormaPagoData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
  
 public Vector query(BelFormaPagoData belFormaPagoDataFrom, BelFormaPagoData belFormaPagoDataTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

 public void remove(Vector belFormaPago ) throws MareException, RemoteException;
  
 public void update(BelFormaPagoData belFormaPagoData, Vector localizationLabels) throws MareException, RemoteException;
  

}