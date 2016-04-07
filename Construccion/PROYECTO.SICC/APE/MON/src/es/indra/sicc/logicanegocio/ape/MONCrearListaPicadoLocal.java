package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.util.DTOBelcorp;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOEtiqueta;

public interface MONCrearListaPicadoLocal extends EJBLocalObject  {
  void crearListaPicado(DTOFACConsolidado consolidado) throws MareException;

  void crearSecuencia() throws MareException;

  void armarListaPicado() throws MareException;

  ArrayList obtenerListaProductos() throws MareException;

  void grabarListaPicado(DTOFACConsolidado consolidado) throws MareException;

  void calcularCubicaje() throws MareException;

  void generarEtiquetas() throws MareException;

  void procesoEmbalajeTermindo(DTOEtiqueta dtoe) throws MareException;
  
  void eliminarAnaquelesPostVenta(DTOBelcorp dtoe) throws MareException;
}