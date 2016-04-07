package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;

public interface MONProcesoFueraPedido extends EJBObject  {
  ArrayList procesarFueraPedido(ArrayList lstProductos) throws RemoteException, MareException;

    void crearListasAFPDefinitivas(Long oidPais) throws MareException, RemoteException;
}