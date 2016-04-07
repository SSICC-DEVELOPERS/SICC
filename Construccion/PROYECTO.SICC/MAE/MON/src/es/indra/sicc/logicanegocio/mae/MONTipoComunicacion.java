package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoComunData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoComunicacion extends EJBObject 
{

 public Hashtable insertar(MaeTipoComunData maeTipoComunData, Vector vector , HashMap userProperties) throws MareException, RemoteException;

 public Vector query(MaeTipoComunData maeTipoComunFrom, MaeTipoComunData maeTipoComunTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

 public void remove(Vector MaeTipoComunData ) throws MareException, RemoteException;

 public void update(MaeTipoComunData MaeTipoComunData, Vector localizationLabels) throws MareException, RemoteException;

}