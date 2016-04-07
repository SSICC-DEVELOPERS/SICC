package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDirecData;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public interface MONTipoDireccion extends EJBObject 
{

 public Hashtable insertar(MaeTipoDirecData maeTipoDirecData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
  
 public Vector query(MaeTipoDirecData maeTipoClasiClienFrom, MaeTipoDirecData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
 
 public void remove(Vector MaeTipoDirecData ) throws MareException, RemoteException;
 
 public void update(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels) throws MareException, RemoteException;
 
}