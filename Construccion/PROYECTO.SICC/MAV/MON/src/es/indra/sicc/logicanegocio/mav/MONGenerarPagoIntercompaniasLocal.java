package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOGenerarPagoIntercompanias;
import es.indra.mare.common.exception.MareException;

public interface MONGenerarPagoIntercompaniasLocal extends EJBLocalObject 
{
    void generarPagoIntercompanias(DTOGenerarPagoIntercompanias dto) throws MareException;
}