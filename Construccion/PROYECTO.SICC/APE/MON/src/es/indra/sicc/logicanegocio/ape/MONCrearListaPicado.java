package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.util.DTOBelcorp;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOEtiqueta;

public interface MONCrearListaPicado extends EJBObject  {
  void crearListaPicado(DTOFACConsolidado consolidado) throws MareException, RemoteException;

  void crearSecuencia() throws MareException, RemoteException;

  void armarListaPicado() throws MareException, RemoteException;

  ArrayList obtenerListaProductos() throws MareException, RemoteException;

  void grabarListaPicado(DTOFACConsolidado consolidado) throws RemoteException, MareException;

  void calcularCubicaje() throws MareException, RemoteException;

  void generarEtiquetas() throws MareException, RemoteException;

  void procesoEmbalajeTermindo(DTOEtiqueta dtoe) throws RemoteException, MareException;
  
  void eliminarAnaquelesPostVenta(DTOBelcorp dtoe) throws RemoteException, MareException;
}