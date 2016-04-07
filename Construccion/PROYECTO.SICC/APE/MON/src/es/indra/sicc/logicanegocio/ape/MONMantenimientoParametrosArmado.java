package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOInsertarListaAFP;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

public interface MONMantenimientoParametrosArmado extends EJBObject  {
  void insertarParametrosArmado(DTOInsertarListaAFP dtoe) throws RemoteException, MareException;

  DTOSalida recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe) throws RemoteException, MareException;

  void eliminarParametrosArmado(DTOOIDs dtoOids) throws RemoteException, MareException;

  DTOSalida recuperarAgrupacionesAFP(DTOAgrupacionEspecifica dtoe) throws RemoteException, MareException;
}