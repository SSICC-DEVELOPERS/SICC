package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente;

public interface MONEncuestaAplicadaCliente extends EJBObject 
{
    DTOSalida obtenerPreguntasEncuesta (DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerRespuestasPorPregunta(DTOOID dto) throws MareException, RemoteException;

    void actualizarEncuestaAplicadaCliente(DTOEncuestaAplicadaPorCliente DTOE) throws RemoteException, MareException;

    DTOSalida buscarEncuestasAplicadasCliente(DTOEncuestaAplicadaPorCliente DTOE) throws RemoteException, MareException;

    void eliminarEncuestaAplicadaCliente(DTOOIDs dto) throws MareException, RemoteException;

    DTOEncuestaAplicadaPorCliente obtenerEncuestaAplicadaCliente(DTOOID DTOE) throws RemoteException, MareException;
}