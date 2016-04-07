package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.com.DTOBuscarComisionesPagar;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.com.DTODatosPagarComision;

public interface MONPagarComisiones extends EJBObject  {
    DTOSalida obtenerComisionesPagar(DTOBuscarComisionesPagar dtoe) throws RemoteException, MareException;

    DTOSalida obtenerDetalleComisionPagar(DTODatosPagarComision dtoe) throws RemoteException, MareException;

    void pagarComisiones(DTODatosPagarComision dtoe) throws RemoteException, MareException;
}