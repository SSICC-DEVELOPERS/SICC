package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOResumen;
import es.indra.sicc.dtos.cob.DTOUsuarioCobranzas;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.cob.DTOBuscarUsuariosCob;
import es.indra.sicc.util.DTOBelcorp;

public interface MONParametrizacionCOB extends EJBObject 
{
  DTOSalida obtenerEtapasDeuda(DTOBelcorp dtoe) throws RemoteException, MareException;

  DTOSalida obtenerTipoCargoPorEtapa(DTOOID dtoe) throws MareException, RemoteException;

  DTOSalida obtenerResumen(DTOResumen dtoe) throws RemoteException, MareException;

  DTOSalida obtenerEstadoUsuario(DTOBelcorp dtoe) throws RemoteException, MareException;

  void guardarUsuarioCobranzas(DTOUsuarioCobranzas dtoe) throws RemoteException, MareException;

  Boolean comprobarUnicoSupervisor(Boolean indUsuarioSupervisor) throws RemoteException, MareException;

  DTOSalida obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe) throws RemoteException, MareException;

  void eliminarUsuarios(DTOOIDs dtoe) throws RemoteException, MareException;

  DTOSalida recuperarUsuarioCob(DTOOID dtoe) throws RemoteException, MareException;

  Boolean comprobarEstado(Long estadoAnterior, Long oidEstadoUsuario, Long oidUsuarioCob) throws RemoteException, MareException;

  Boolean comprobarEtapa(Long oidUsuarioCob) throws RemoteException, MareException;

    DTOSalida obtenerEtapasDeudaPorTipoCargo(DTOOID dto) throws MareException, RemoteException;
}