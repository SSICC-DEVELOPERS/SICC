package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoEstatClienData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoEstatusCliente extends EJBObject 
{
  public Hashtable insertar(MaeTipoEstatClienData maeTipoEstatClienData, Vector vector , HashMap userProperties) throws MareException, RemoteException;

  public Vector query(MaeTipoEstatClienData maeTipoEstatClienFrom, MaeTipoEstatClienData maeTipoEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

  public void remove(Vector MaeTipoEstatClienData ) throws MareException, RemoteException;

  public void update(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels) throws MareException, RemoteException;

}