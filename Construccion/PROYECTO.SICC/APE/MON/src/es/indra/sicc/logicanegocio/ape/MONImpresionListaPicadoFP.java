package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOBusquedaListaPicadoFP;
import es.indra.sicc.util.DTOColeccion;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;

public interface MONImpresionListaPicadoFP extends EJBObject  {
  DTOSalida buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoE) throws MareException, RemoteException;

  void imprimirListaPicadoCabeceraFP(DTOColeccion dtoE) throws MareException, RemoteException;
}