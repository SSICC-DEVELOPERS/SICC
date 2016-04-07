package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosTextoVariable;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;

public interface MONConfiguracionTextosVariables extends EJBObject {
    void guardarConfiguracionTextoVariable(DTODatosTextoVariable dtoe) throws MareException, RemoteException;
    DTOSalida consultarConfiguracionTextoVariable(DTODatosTextoVariable dtoe) throws MareException, RemoteException;
    void eliminar(DTOOIDs dtoe) throws MareException, RemoteException;
}