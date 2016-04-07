package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOParticipantesDetalle;
import es.indra.sicc.util.DTOOIDs;

public interface MONParticipantesDetalle extends EJBObject {
    DTOSalida obtenerGruposCliente(DTOBelcorp DTOE) throws MareException, RemoteException;
    void guardarDetalle(DTOParticipantesDetalle DTOE) throws MareException, RemoteException;
    DTOSalida buscarDetalle(DTOParticipantesDetalle DTOE) throws MareException, RemoteException;
    void eliminarDetalle(DTOOIDs DTOE) throws MareException, RemoteException;
}