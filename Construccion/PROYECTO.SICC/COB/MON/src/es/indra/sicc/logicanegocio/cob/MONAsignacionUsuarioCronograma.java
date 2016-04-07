package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.cob.DTOUsuarEtapaCobraDetal;

public interface MONAsignacionUsuarioCronograma extends EJBObject  {
  DTOSalida recuperarUsuariosCabecera(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida recuperarTiposCargo(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida recargaEtapaDeuda(DTOOID dtoOid) throws MareException, RemoteException;

  DTOSalida recuperarLiquidacion(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida recuperarGuiaArgumental(DTOBelcorp dto) throws MareException, RemoteException;

  void guardarAsigUsuConograma(DTOUsuarEtapaCobraDetal dto) throws MareException, RemoteException;

  DTOUsuarEtapaCobraDetal detalleUsuarioCabacera(DTOOID dtoOid) throws MareException, RemoteException;

  DTOSalida consultarUsuariosCronogramaCobranzaDetalle(DTOUsuarEtapaCobraDetal dto) throws MareException, RemoteException;

  void eliminarAsignacionUsuarios(DTOOIDs dtoOid) throws RemoteException, MareException;

  void guardarModificacionAsigUsuConograma(DTOUsuarEtapaCobraDetal dto) throws MareException, RemoteException;

  DTOSalida recuperarTiposCargoPorEtapa(DTOOID dto) throws RemoteException, MareException;
}