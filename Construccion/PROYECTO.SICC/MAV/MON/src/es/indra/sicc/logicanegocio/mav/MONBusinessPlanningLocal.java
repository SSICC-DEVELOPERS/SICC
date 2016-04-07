package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mav.DTOBuscarCargaBP;
import es.indra.sicc.dtos.mav.DTOCargaBP;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

public interface MONBusinessPlanningLocal extends EJBLocalObject 
{
    DTOSProductoValidado actualizaDetalleMAV(DTODetalleMAV dto) throws MareException;

    DTOCargaBP cargaPaginaBP(DTOBuscarCargaBP dto) throws MareException;

    DTOSalida obtenerPeriodosRangoAnual(DTOPeriodo dtoPeriodo) throws MareException;

    void cargaTextosDetalle(DTODetalleMAV dto) throws MareException;

    DTOSalida obtieneDetallesMAV(DTODetalleMAV dto) throws MareException;

    DTODetalleMAV obtieneDetalleMAV(DTOOID dto) throws MareException;

    DTOSProductoValidado validaProducto(DTODetalleMAV dto) throws MareException;

    void desactivaDetalleMAV(DTOOID dto) throws MareException;

    DTOSalida descProducto(DTODetalleMAV dtoe) throws MareException;
}
