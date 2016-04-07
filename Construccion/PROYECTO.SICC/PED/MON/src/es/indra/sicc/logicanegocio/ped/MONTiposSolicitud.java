/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       12/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */
 
package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;
import es.indra.sicc.util.DTOBelcorp;


public interface MONTiposSolicitud extends EJBObject  {

	void elimina(DTOOIDs dto) throws MareException, RemoteException;

	void guarda(DTOTipoSolicitud dto) throws MareException, RemoteException;

	DTOSalida consulta(DTOTipoSolicitud dto) throws MareException, RemoteException;

	DTOTipoSolicitud consultaDetalles(DTOOID dto) throws MareException, RemoteException;

	DTOTipoSolicitud obtenerValoresAsociadosTipoSolicitud(DTOOID dtoe) throws MareException, RemoteException;

	DTOSalida obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto) throws MareException, RemoteException;

  DTOSalida obtenerAccesosBelcenter(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;

}