package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.DTOOID;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface MONINTGEO extends EJBObject {

  DTOSalidaBatch enviarEstandarizacionDeDirecciones(DTOBatch dtoBatch) throws RemoteException, MareException;
  
  DTOSalidaBatch recepcionarEstandarizacionDirecciones (DTOBatch dtoBatch) throws RemoteException, MareException;
  
  String comprobarExistenciaCodigos (String codTipoVia, String codNSE, Integer codTerritorio, Long codPais) throws RemoteException, MareException;


}