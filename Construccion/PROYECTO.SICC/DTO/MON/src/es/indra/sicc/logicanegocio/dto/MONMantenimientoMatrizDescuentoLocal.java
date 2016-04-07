package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.dto.DTOSCargarPaginaCrearMatrizDTO;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOMatrizDescuento;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.dto.DTOEMatrizCanal;
import es.indra.sicc.dtos.dto.DTOEMatrizTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOEMatrizAccesos;
import es.indra.sicc.dtos.dto.DTOEMatrizTiposCliente;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;

public interface MONMantenimientoMatrizDescuentoLocal extends EJBLocalObject 
{
    DTOSalida buscarMatricesDescuento(DTOBuscarMatricesDescuento dto) throws MareException;

    DTOSCargarPaginaCrearMatrizDTO cargarPaginaCrearMatrizDescuento(DTOBelcorp dto) throws MareException;

    DTOSalida cargarParametrosMatrizDescuento() throws MareException;

    DTOSalida compruebaDescuentosAsociados(Integer oidCabeceraMatriz) throws MareException;

    DTODatosMatrizDescuentos consultarMatrizDescuentos(DTOOID dto) throws MareException;

    void copiarMatrizDescuentos(DTOMatrizDescuento dto) throws MareException;

    void crearMatrizDescuentos(DTODatosMatrizDescuentos dto) throws MareException;

    void eliminarMatrizDescuentos(DTOOIDs dto) throws MareException;

    DTOSalida obtenerAccesosPorCanalDTOMatrizSeleccionada(DTOEMatrizCanal dto) throws MareException;

    DTOSalida obtenerCanalesDTOMatrizSeleccionada(DTOOID dto) throws MareException;

    DTOSalida obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(DTOEMatrizTipoClasificacion dto) throws MareException;

    DTOSalida obtenerMarcasDTOMatrizSeleccionada(DTOOID dto) throws MareException;

    DTOSalida obtenerNumerosDescuentos(DTOOID dto) throws MareException;

    DTOSalida obtenerSubaccesosDTOMatrizSeleccionada(DTOOID dto) throws MareException;

    DTOSalida obtenerSubaccesosMultiAccesoDTOMatrizSeleccionada(DTOEMatrizAccesos dto) throws MareException;

    DTOSalida obtenerSubtiposClienteDTOMatrizSeleccionada(DTOOID dto) throws MareException;

    DTOSalida obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(DTOEMatrizTiposCliente dto) throws MareException;

    DTOSalida obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(DTOEMatrizSubtiposCliente dto) throws MareException;

    DTOSalida obtenerTiposClienteDTOMatrizSeleccionada(DTOOID dto) throws MareException;
}