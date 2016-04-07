package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mav.DTOSCargaPaginaInsertarActividades;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOOIDs;

public interface MONMantenimientoActividadesMAVLocal extends EJBLocalObject 
{
    DTOSalida buscarActividades(DTOEBuscarActividadesMAV dto) throws MareException;

    DTOSCargaPaginaInsertarActividades cargaPaginaInsertarActividades(DTOBelcorp dto) throws MareException;

    DTOActividadMAV consultarActividad(DTOOID dto) throws MareException;

    void eliminarActividades(DTOOIDs dto) throws MareException;

    void guardarActividad(DTOActividadMAV dto) throws MareException;

    DTOSalida obtenerSubtiposCliente(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerSubtiposClienteMAV(DTOOID DTOE) throws MareException;

    DTOSalida obtieneActividadesMAV(DTOActividadMAV dto) throws MareException;

  DTOSalida obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto) throws MareException;
}