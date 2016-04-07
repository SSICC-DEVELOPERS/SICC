/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       12/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTiposSolicitudHome extends EJBHome  {
	MONTiposSolicitud create() throws RemoteException, CreateException;
}