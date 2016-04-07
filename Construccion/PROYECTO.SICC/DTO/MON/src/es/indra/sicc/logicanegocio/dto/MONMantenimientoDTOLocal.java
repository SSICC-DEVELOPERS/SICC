package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentos;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentosOrdenacion;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTOSPaginaAlcanceTiposClienteDetalle;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO;
import es.indra.sicc.dtos.dto.DTOSAlcanceTipoClienteDTO;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEBuscarProductosDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOEBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOEBaseCalculo;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOListaDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOEDescuentosOrdenacion;
import es.indra.sicc.dtos.inc.DTODescuentosIncentivos;
import es.indra.sicc.dtos.dto.DTOCodigoClienteDto;
import es.indra.sicc.dtos.dto.DTODescuentoCliente;
import es.indra.sicc.dtos.dto.DTODescuento;

public interface MONMantenimientoDTOLocal extends EJBLocalObject 
{
    DTOSalida buscarDescuentos(DTOEBuscarDescuentos dto) throws MareException;

    DTOSalida buscarDescuentosOrdenacion(DTOEBuscarDescuentosOrdenacion dto) throws MareException;

    DTOSalida buscarMatricesDTOActivas(DTOSiccPaginacion dto) throws MareException;

    DTOSalida buscarMatricesDTOActivasREP(DTOBelcorp dto) throws MareException;

    DTOSPaginaAlcanceTiposClienteDetalle cargarPaginaAlcanceTiposClienteDetalle(DTOEMatrizSubtiposCliente dto) throws MareException;

    DTOSalida consultarAlcanceAdministrativoDTO(DTOOID dto) throws MareException;

    DTOSalida consultarAlcanceClasificacionDTO(DTOEBuscarAlcanceClasificacionDTO dto) throws MareException;

    DTOSalida consultarAlcanceClienteDTO(DTOEBuscarAlcanceClienteDTO dto) throws MareException;

    DTOSAlcanceTipoClienteDTO consultarAlcanceTipoClienteDTO(DTOOID dto) throws MareException;

    DTOSBaseAplicacion consultarBaseAplicacionDTO(DTOOID dto) throws MareException;

    DTOSBaseAplicacion consultarBaseAplicacionDTOBatch(DTOOID dto) throws MareException;

    DTOSBaseCalculo consultarBaseCalculoDTO(DTOOID dto) throws MareException;

    DTOOIDs consultarBasesAplicacionDTO(DTOOID dto) throws MareException;

    DTODescuentoDG consultarDescuentoDG(DTOOID dto) throws MareException;

    DTOSalida consultarProductosDTO(DTOEBuscarProductosDTO dto) throws MareException;

    void eliminarAlcanceAdministrativoDTO(DTOOIDs dto) throws MareException;

    void eliminarDTOSPorClasificacion(DTOOIDs dto) throws MareException;

    void eliminarDescuentos(DTOOIDs dto) throws MareException;

    void eliminarDescuentosCliente(DTOOIDs dto) throws MareException;

    void guardarAlcanceAdministrativo(DTOEAlcanceAdministrativoDTO dto) throws MareException;

    void guardarAlcanceClasificacion(DTOEAlcanceClasificacionDTO dto) throws MareException;

    void guardarAlcanceCliente(DTOEDescuentoCliente dto) throws MareException;

    void guardarAlcanceTipoCliente(DTOEAlcanceTipoCliente dto) throws MareException;

    void guardarBaseAplicacionDTO(DTOEBaseAplicacion dto) throws MareException;

    void guardarBaseCalculoDTO(DTOEBaseCalculo dto) throws MareException;

    void guardarDatosDescuento(DTOGlobalDescuento dtoe) throws MareException;

    DTOOID guardarDescuentoDG(DTOGlobalDescuento dto) throws MareException;

    void guardarListaAlcanceCliente(DTOListaDescuentoCliente dto) throws MareException;

    void guardarOrdenacionDTO(DTOEDescuentosOrdenacion dto) throws MareException;

    void guardarParametroNacional(DTODescuentoDG dto) throws MareException;

    void ingresarDescuentosIncentivos(DTODescuentosIncentivos dtoDes) throws MareException;

    DTODescuentoCliente obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe) throws MareException;

    DTOGlobalDescuento obtenerDatosDescuentos(DTOOID dtoe) throws MareException;

    DTODescuento obtenerDescuento(DTOOID dto) throws MareException;

    DTODescuento obtenerDescuentoBatch(DTOOID dto) throws MareException;

    DTOSalida obtenerDescuentosActivos(DTOSiccPaginacion dto) throws MareException;
}