package es.indra.sicc.logicanegocio.pre;

import es.indra.sicc.util.DTOString;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.dtos.pre.DTOEBuscarOfertas;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOTextoOferta;
import es.indra.sicc.dtos.pre.DTOComprobarOrden;
import es.indra.sicc.dtos.pre.DTOEOrdenOfertas;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOModificarOferta;
import es.indra.sicc.dtos.pre.DTOValidacionRecuperacion;
import es.indra.sicc.dtos.pre.DTOValidacionesOferta;

import java.util.ArrayList;

public interface MONOfertaLocal extends EJBLocalObject 
{
    void asignarAdicional(String CUV, DetalleOfertaLocal detalleOferta, OfertaLocal oferta) throws MareException;

    void asignarCodigosVenta(DTOCabecCatal dto) throws MareException;

    DTOSalida buscarOfertas(DTOEBuscarOfertas dto) throws MareException;

    RecordSet buscarOfertasSinCodigoVenta(DTOCabecCatal dto) throws MareException;

    DTOSalida buscarProductosEstimados(DTOEBuscarProductos dto) throws MareException;

    DTOSalida buscarProductosEstimadosPerf(DTOEBuscarProductos dto) throws MareException;

    DTOSalida buscarProductosEstrategiaIndividual(DTOCabecCatal dto) throws MareException;

    DTOSalida buscarProductosMaestro(DTOEBuscarProductos dto) throws MareException;

    DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductos(DTOOID dto) throws MareException;

    DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductosMinimo(DTOOID dto) throws MareException;

    DTOSCargarCriteriosDefinirOferta cargarCriteriosDefinirOferta(DTOECargarCriteriosDefinirOferta dtoe) throws MareException;

    DTOSalida cargarPaisMarcaCanalPeriodo(DTOOID dto) throws MareException;

    Boolean comprobarNumeroOrden(DTOTextoOferta dto) throws MareException;

    DTOComprobarOrden comprobarOrdenOfertas(DTOOID dto) throws MareException;

    DTOSalida consultarOrdenOfertas(DTOEOrdenOfertas dto) throws MareException;

    Integer eliminarOferta(DTOOID dtoOid) throws MareException;

    void eliminarTextoOferta(DTOOID dto) throws MareException;

    boolean existeOtroProductoAsignado(String CUV, Long oidCabecera) throws MareException;

    OfertaLocal guardarCabeceraOferta(DTOOferta dto) throws MareException;

    DetalleOfertaLocal guardarDetalleOferta(DTODetalleOferta dto) throws MareException;

    void guardarOferta(DTOOferta dto) throws MareException;

    void guardarTextoOferta(DTOTextoOferta dto) throws MareException;

    void modificarOferta(DTOOferta dto) throws MareException;

    DTOSalida obtenerFactorCuadreGrupos(DTOOID dtoe) throws MareException;

    RecordSet obtenerGrupoCondicionadoMayorRanking(Long oidOferta) throws MareException;

    RecordSet obtenerGrupoCondicionadoMenorRanking(Long oidOferta) throws MareException;

    DTOSalida obtenerIndicadorCuadreGrupos(DTOOID dtoe) throws MareException;

    Integer obtenerNumeroOferta(Long oidOferta) throws MareException;

    DTOOferta obtenerOferta(DTOOID dto) throws MareException;

    DTOModificarOferta obtenerOfertaModificacion(DTOOID dtoOId) throws MareException;

    DTOSalida obtenerOfertasPromocion(DTOOID dtoe) throws MareException;

    DTOSalida obtenerProductos(DTOOID dto) throws MareException;

    DTOSalida obtenerProductosAsociados(DTOOID dtoe) throws MareException;

    RecordSet obtenerProductosGrupo(Long oidOferta, Long numeroGrupo) throws MareException;

    DTOSalida obtenerProductosOferta(Long oidOferta) throws MareException;

    RecordSet obtenerProductosOfertaSinCV(Long oidOferta) throws MareException;

    DTOOID obtenerProgramaFidelizacion(DTOOID dtoE) throws MareException;

    DTOTextoOferta obtenerTextoOferta(DTOTextoOferta dtoe) throws MareException;

    String obtenerUltimoCodigoVenta(Long oidCabecera) throws MareException;

    Integer obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia) throws MareException;

    void registrarOfertasIndividuales(DTOCabecCatal dto) throws MareException;

    void secuenciarOfertas(DTOOID dto) throws MareException;

    void validarAcceso(DTOOferta dto) throws MareException;

  ArrayList ordenarOfertas(RecordSet ofertas) throws MareException;

  DTOSalida consultarOrdenOfertaFiltros(DTOEOrdenOfertas dto) throws MareException;

    DTOSalida obtenerProductosAsociados(ArrayList dtos) throws MareException;

    DTOString validarRestriccionesOferta(DTOValidacionesOferta dto) throws MareException;

    DTOString validarProductoRecuperacion(DTOValidacionRecuperacion dto) throws MareException;
}
