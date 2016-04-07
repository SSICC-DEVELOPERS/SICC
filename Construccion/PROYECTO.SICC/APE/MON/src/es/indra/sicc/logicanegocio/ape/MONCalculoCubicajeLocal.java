package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.mare.common.exception.MareException;

public interface MONCalculoCubicajeLocal extends EJBLocalObject 
{
  void calcularCubicajePorVolumen(DTOListaPicadoCabecera listaPicado) throws MareException;
}