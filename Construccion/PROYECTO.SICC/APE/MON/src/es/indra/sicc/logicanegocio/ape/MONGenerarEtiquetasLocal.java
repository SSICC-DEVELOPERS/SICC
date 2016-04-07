package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.mare.common.exception.MareException;

public interface MONGenerarEtiquetasLocal extends EJBLocalObject 
{
  void generarEtiquetas(DTOListaPicado dtoe) throws MareException;
}