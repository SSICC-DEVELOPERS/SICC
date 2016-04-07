package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoClienData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoCliente extends EJBObject 
{

 public Hashtable insertar(MaeTipoClienData maeTipoClienData, Vector vector , HashMap userProperties) throws MareException, RemoteException;

 public Vector query(MaeTipoClienData maeTipoClasiClienFrom, MaeTipoClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
 
 public void remove(Vector maeTipoClienData ) throws MareException, RemoteException;
 
 public void update(MaeTipoClienData MaeTipoClienData, Vector localizationLabels) throws MareException, RemoteException;
 
}