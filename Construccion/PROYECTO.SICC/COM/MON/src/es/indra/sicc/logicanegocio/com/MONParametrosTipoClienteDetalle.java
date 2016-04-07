package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.com.DTOTipoClienteComDetalle;
import es.indra.mare.common.exception.MareException;

public interface MONParametrosTipoClienteDetalle extends EJBObject 
{
    DTOSalida obtenerTipoClienteCOMGerente(DTOBelcorp dtoE) throws MareException, RemoteException;

    void guardarTipoClienteComDetalle(DTOTipoClienteComDetalle dtoE) throws MareException, RemoteException;

    DTOSalida buscarTipoClienteComDetalle(DTOTipoClienteComDetalle dtoE) throws MareException, RemoteException;

    void eliminarTipoClienteComDetalle(DTOOIDs dto) throws MareException, RemoteException;
}