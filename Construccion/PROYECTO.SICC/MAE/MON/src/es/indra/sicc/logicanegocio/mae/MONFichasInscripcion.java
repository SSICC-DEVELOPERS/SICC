package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOReimprimirFichasInscripcion;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public interface MONFichasInscripcion extends EJBObject  {
    DTOSalida obtenerFichasInscripcion(DTOSiccPaginacion dto) throws RemoteException, MareException;

    void reimprimirFichasInscripcion(DTOReimprimirFichasInscripcion dto) throws RemoteException, MareException;

    Integer obtenVersionReimpresion(Long oidCliente) throws RemoteException, MareException;
}