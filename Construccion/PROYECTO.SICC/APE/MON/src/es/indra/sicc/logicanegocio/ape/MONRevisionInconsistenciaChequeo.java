package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.util.DTOColeccion;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODate;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;

public interface MONRevisionInconsistenciaChequeo extends EJBObject {
    DTOSalida buscarInconsistenciaChequeo(DTODate dtoe) throws MareException, RemoteException;
    DTOSalida revisarCaja(DTOListaPicadoDetalle dtoe) throws MareException, RemoteException;
    void guardarInconsistenciaChequeo(DTOColeccion dtoe) throws RemoteException, MareException;
}