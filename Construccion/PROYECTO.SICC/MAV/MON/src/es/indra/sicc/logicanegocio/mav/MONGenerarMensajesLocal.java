package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTODatosMensaje;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.mare.common.exception.MareException;

public interface MONGenerarMensajesLocal extends EJBLocalObject 
{
    DTOBuzonMensajes generarMensaje(DTODatosMensaje dto) throws MareException;

    Boolean hayStockSuficiente(Long pais, Long producto, Long almacen, Long unidadesDemandadas) throws MareException;

    Long obtenerAlmacen(Long oidPais) throws MareException;
}