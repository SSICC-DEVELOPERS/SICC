package es.indra.sicc.logicanegocio.edu;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;
import es.indra.sicc.dtos.edu.DTOValidarParticipantes;

public interface MONRegistrarNuevas extends EJBObject  {
    DTOSalida consultaCursosRegistrarNuevas(DTOConsultaCurso dtoe) throws RemoteException, MareException;

    DTOParticipantesValidados validarParticipantesRegistrarNuevas(DTOValidarParticipantes dtoe) throws RemoteException, MareException;
}