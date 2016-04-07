package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOEValidarProducto;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.mare.common.exception.MareException;

public interface MONCargaMantenimientoListasLocal extends EJBLocalObject 
{
    DTOSProductoValidado validarProductos(DTOEValidarProducto dto) throws MareException;
}