package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTOBalanceoLinea;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;

public interface MONBalanceoLinea extends EJBObject {
    DTOSalida obtenerOrdenacionProductos(DTOBelcorp dtoe) throws MareException, RemoteException;
    DTOSalida obtenerOrigenDatos(DTOBelcorp dtoe) throws MareException, RemoteException;
    DTOBalanceoLinea ejecutarBalanceo(DTOBalanceoLinea dtoe) throws MareException, RemoteException;
    DTOBalanceoLinea ordenarProductos(DTOBalanceoLinea dtoe) throws MareException, RemoteException;
    DTOBalanceoLinea ordenarAnaqueles(DTOBalanceoLinea dtoe) throws MareException, RemoteException;
    DTOBalanceoLinea distribuirProductosMatching(DTOBalanceoLinea dtoe) throws MareException, RemoteException;
    void emitirAlarmas(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException, RemoteException;
    void eliminarBalanceoPrevio(Long oidAsignacionProductosAnaqueles) throws MareException, RemoteException;
    DTOBalanceoLinea evaluarCarga(DTOBalanceoLinea dtoe) throws MareException, RemoteException;
}