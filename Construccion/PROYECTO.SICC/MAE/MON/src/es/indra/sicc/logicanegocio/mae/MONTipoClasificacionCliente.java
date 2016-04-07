package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoClasificacionCliente extends EJBObject 
{

  public Hashtable insertar(MaeTipoClasiClienData maeTipoClasiClienData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
    
  public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo,  HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
  
  public void remove(Vector MaeTipoClasiClienData ) throws MareException, RemoteException;
  
  public void update(MaeTipoClasiClienData MaeTipoClasiClienData, Vector localizationLabels) throws MareException, RemoteException;
  
}