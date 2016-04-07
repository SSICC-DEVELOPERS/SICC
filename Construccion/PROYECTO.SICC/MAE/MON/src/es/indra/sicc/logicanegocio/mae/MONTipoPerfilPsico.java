package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoPerfiPsicoData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONTipoPerfilPsico extends EJBObject 
{
 public Hashtable insertar(MaeTipoPerfiPsicoData maeTipoPerfiPsicoData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
 
 public Vector query(MaeTipoPerfiPsicoData maeTipoPerfiPsicoFrom, MaeTipoPerfiPsicoData maeTipoPerfiPsicoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;

 public void remove(Vector MaeTipoPerfiPsicoData ) throws MareException, RemoteException;
 
 public void update(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels) throws MareException, RemoteException;
 
}