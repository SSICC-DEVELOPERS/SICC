package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTOCargaParametrizacion;
import es.indra.sicc.dtos.mav.DTOParametrizacionMAV;

public interface MONMantenimientoListasLocal extends EJBLocalObject 
{
    void cargarDatosDesdeBusinessPlanning(DTOBelcorp dto) throws MareException;

    DTOCargaParametrizacion cargarParametrizacion(DTOOID dto) throws MareException;

    void guardarParametrizacion(DTOParametrizacionMAV dto) throws MareException;
}