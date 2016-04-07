package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoNivelSocecPersoData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoNivelSocecPersonal extends EJBObject 
{

 public Hashtable insertar(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector vector , HashMap userProperties) throws MareException, RemoteException;

  public Vector query(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoFrom, MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

  public void remove(Vector MaeTipoNivelSocecPersoData ) throws MareException, RemoteException;
  
  public void update(MaeTipoNivelSocecPersoData MaeTipoNivelSocecPersoData, Vector localizationLabels) throws MareException, RemoteException;
  
}