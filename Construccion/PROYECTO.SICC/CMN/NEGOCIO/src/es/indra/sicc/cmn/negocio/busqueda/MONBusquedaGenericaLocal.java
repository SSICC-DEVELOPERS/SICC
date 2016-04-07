package es.indra.sicc.cmn.negocio.busqueda;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBusquedaGenerica;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;


public interface MONBusquedaGenericaLocal extends EJBLocalObject 
{
  DTOSalida RealizarBusqueda(DTOBusquedaGenerica dto) throws MareException;
}