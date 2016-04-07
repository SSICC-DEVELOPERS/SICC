package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface MONConfiguracionClientes extends EJBObject  {
  DTOTipoSubtipo obtenerTipoSubtipo(DTOBelcorp dto) throws MareException, RemoteException;

  DTOClasificaciones obtenerClasificaciones(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerSubtipos(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerTipoClasificacion(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerClasificacionesPorTipo(DTOOID dto) throws MareException, RemoteException;

  RecordSet obtenerClasificacionesCliente(Long tipoClasificacion, String tipoCliente, Long idioma) throws RemoteException, MareException;

	DTOClasificaciones obtenerClasificacionesSubtipo(DTOOID subtipo) throws MareException, RemoteException;

	Long obtenerOidClienteTipoSubtipo(Long cliente, Long tipo) throws MareException, RemoteException;

  DTOSalida obtenerTiposDireccion(DTOBelcorp dtoe) throws MareException, RemoteException;

	DTOSalida obtenerTipos(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida obtenerTiposClasificacion(DTOOID subtipo) throws MareException, RemoteException;

	DTOTipoSubtipoCliente obtenerTipoPrincipalCliente(Long cliente) throws MareException, RemoteException;

	DTOSalida obtenerTiposDocumentoCliente(DTOOID cliente) throws RemoteException, MareException;

	RecordSet obtenerTipoDocumentoLegal(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerTiposTarjeta(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposDocumentoPorPais(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOTipoSubtipoCliente obtenerTipoSubtipoCliente(Long cliente) throws MareException, RemoteException;

    DTOTipoSubtipoCliente obtenerPrimerTipoClienteNoPrincipal(Long cliente) throws MareException, RemoteException;
}