package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOECBRegistrosMAV;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mav.DTOCargaPaginaRegistrosMAV;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOAgrupacionEnvios;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.mav.DTORegistrosMAV;
import es.indra.sicc.dtos.mav.DTOProcesoDetalleMAV;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTOLineaCombo;

public interface MONRegistroMAVLocal extends EJBLocalObject 
{
    DTOSalida buscarEnviosMAVATC(DTOECBRegistrosMAV dto) throws MareException;

    DTOSalida buscarEnviosMAVATD(DTOECBRegistrosMAV dto) throws MareException;

    DTOSalida buscarEnviosMAVProductos(DTOECBRegistrosMAV dto) throws MareException;

    DTOCargaPaginaRegistrosMAV cargaPaginaRegistrosMAV(DTOBelcorp dto) throws MareException;

    DTODetalleMAV comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo) throws MareException;

    DTOSalida detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto) throws MareException;

    void generarEnvioMAV(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio) throws MareException;

    void generarInformacionMAV(MareDTO dto) throws MareException;

    void guardarRegistrosMAV(DTORegistrosMAV dto) throws MareException;

    DTOProcesoDetalleMAV procesarLineaDetalleMAV(DTODetalleMAV dto, Long peirodo, Long actividad, Boolean simulacion) throws MareException;

    DTOLineaCombo recuperarTipoClienteActividad(DTOOID dto) throws MareException;

    Boolean validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion) throws MareException;

    Boolean validarVinculosEnvioMAV(Long oid) throws MareException;

    void generarEnviosMasivos(DTODetalleMAV[] dto, Long periodo, Long cliente) throws MareException;
}