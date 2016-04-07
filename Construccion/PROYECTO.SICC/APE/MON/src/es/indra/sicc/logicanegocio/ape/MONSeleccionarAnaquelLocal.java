package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelBusqueda;
import es.indra.sicc.dtos.ape.DTOProcesoFueraPedido;
import es.indra.mare.common.exception.MareException;

public interface MONSeleccionarAnaquelLocal extends EJBLocalObject 
{
  DTOProcesoFueraPedido seleccionarAnaquel(DTOAsignacionProductoAnaquelBusqueda dtoE) throws MareException;
}