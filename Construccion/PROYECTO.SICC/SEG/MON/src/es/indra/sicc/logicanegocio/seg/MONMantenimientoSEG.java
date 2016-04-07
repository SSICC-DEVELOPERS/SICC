package es.indra.sicc.logicanegocio.seg;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.dtos.seg.DTOColeccionSubaccesos;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.dtos.seg.DTOPMC;
import es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo;
import es.indra.sicc.dtos.seg.DTOSubacceso;
import es.indra.sicc.dtos.seg.DTOSubaccesosPorAccesoYCanal;
import es.indra.sicc.dtos.seg.DTOValidarUbigeo;
import es.indra.sicc.dtos.seg.DTOEBuscarVinculosJerarquia;
import es.indra.sicc.dtos.seg.DTOEVinculoJerarquia;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.dtos.seg.DTOEBuscarSubaccesos;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOCAS;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOBoolean;
import java.util.Date;



public interface MONMantenimientoSEG extends EJBObject {
    DTOSalida recuperarPaises(DTOBelcorp dto)
        throws RemoteException, MareException;

    DTOSalida recuperarDepartamentos(DTOBelcorp dto)
        throws RemoteException, MareException;

    DTOSalida recuperarMarcas(DTOBelcorp belcorp, Boolean todos)
        throws RemoteException, MareException;

    DTOSalida recuperarCanales(DTOBelcorp dto, Boolean todos)
        throws RemoteException, MareException;

    DTOSalida recuperarAccesos(DTOBelcorp dto, Boolean todos)
        throws RemoteException, MareException;

    DTOSalida recuperarSubaccesos(DTOBelcorp dto, Boolean todos)
        throws RemoteException, MareException;

    DTOSalida recuperarPeriodos(DTOBelcorp dto)
        throws RemoteException, MareException;

    DTOSalida recuperarEmpresas(DTOBelcorp dto, Boolean todos)
        throws RemoteException, MareException;

    DTOSalida recuperarIdiomas(DTOBelcorp dto) throws RemoteException, MareException;
    DTOSalida recuperarAccesosPorCanal(DTOAccesosPorCanal dtoe) throws RemoteException, MareException;
    DTOSalida recuperarSubaccesosPorAccesoCanal(DTOSubaccesosPorAccesoYCanal dtoe) throws RemoteException, MareException;
    DTOSalida recuperarEmpresasPorPais(DTOBelcorp dto) throws RemoteException, MareException;
    DTOSalida recuperarTiposPeriodo(DTOBelcorp dto) throws RemoteException, MareException;
    DTOSalida recuperarPeriodosPorTipoPeriodo(DTOPeriodosPorTipoPeriodo dtoe) throws RemoteException, MareException;
    DTOSalida recuperarPaisesSinTodos(DTOBelcorp dto) throws RemoteException, MareException;
    DTOSalida recuperarTamanoTipoPeriodoPorCanal(Long canal) throws RemoteException, MareException;
    DTOPMC obtienePaisMarcaCanal (DTOFiltroPMC dtoe) throws RemoteException, MareException;
    DTOSalida recuperarTiposVia (DTOBelcorp dto) throws RemoteException, MareException;
    DTOSalida recuperarDepartamentosPorPais (DTOBelcorp dto) throws RemoteException, MareException;  

    DTOSalida recuperarDescripcionPais(DTOInternacional internacional) throws MareException, RemoteException;

    Integer obtenerLongitudNumeroCliente(Long oidPais) throws MareException, RemoteException;

    Long obtenerOidCanal(String codigo) throws MareException, RemoteException;

    Long obtenerOidPais(String codigo) throws MareException, RemoteException;

    Long obtenerOidMarca(String codigo) throws MareException, RemoteException;

    DTOSalida recuperarMarcas(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida recuperarCanales(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida recuperarAccesos(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida recuperarSubaccesos(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida recuperarModulos(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida recuperarNacionalidades(DTOBelcorp dto) throws MareException, RemoteException;

    Long obtenerOidTipoVia(String codigo) throws RemoteException, MareException;

  void insertarSubacceso(DTOSubacceso dto) throws MareException, RemoteException;

  void modificarSubacceso(DTOSubacceso dto) throws MareException, RemoteException;

  void eliminarSubaccesos(DTOOIDs dtos) throws RemoteException, MareException;

  DTOValidarUbigeo validarUbigeo(DTOSubacceso dto) throws MareException, RemoteException;

  DTOSalida buscarPorCriterioSubacceso(DTOSubacceso dto) throws RemoteException, MareException;

    DTOSalida recuperarPais(DTOOID dtoOid) throws MareException, RemoteException;

	DTOPMC obtienePaisMarcaCanalTodos(DTOFiltroPMC dtoe) throws MareException, RemoteException;

	DTOSalida recuperarPaises(DTOBelcorp dto, Boolean todos) throws MareException, RemoteException;

	Boolean usaGeoreferenciador(Long oidPais) throws MareException, RemoteException;

  DTOSalida obtenerSubaccesosPorAcceso(DTOOID dto) throws MareException, RemoteException;

  DTOSalida buscarVinculosJerarquia(DTOEBuscarVinculosJerarquia dto) throws MareException, RemoteException;

  void eliminarVinculosJerarquia(DTOOIDs dto) throws MareException, RemoteException;

  void guardarVinculosJerarquia(DTOEVinculoJerarquia dto) throws MareException, RemoteException;

  DTOSalida recuperarSubaccesosCriterios(DTOEBuscarSubaccesos dto) throws RemoteException, MareException;

  DTOSalida consultarSubacceso(DTOOID dto) throws MareException, RemoteException;

  void guardarSubacceso(DTOSubacceso dto) throws MareException, RemoteException;

  DTOSalida obtenerMarcasSinFiltro() throws MareException, RemoteException;

  DTOSalida obtenerCanalesSinFiltro(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerAccesosSinFiltro(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerSubaccesosSinFiltro(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerEmpresasSinFiltro(DTOOID dto) throws MareException, RemoteException;

  DTOSalida buscarSubaccesos(DTOEBuscarSubaccesos dtoe) throws MareException, RemoteException;

  DTOCAS obtieneCanalAccesoSubacceso(DTOCargaCAS dto) throws MareException, RemoteException;

  Long obtenerOidMoneda(String codigo) throws MareException, RemoteException;

  BigDecimal obtenerCambioMonedaAlternativa(Long oidPais) throws RemoteException, MareException;

  BigDecimal obtenerTipoCambio(Long moneda1, Long moneda2) throws RemoteException, MareException;

  Long obtenerOidPeriodo(String codigo, Long canal) throws MareException, RemoteException;

  DTOSalida obtenerSubaccesosMultiAcceso( es.indra.sicc.util.DTOOIDs dto ) throws  MareException , RemoteException;

	DTOSalida recuperarPaisesSinFiltro(DTOOID dto) throws MareException, RemoteException;

	DTOSalida obtenerAccesosPorCanal(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerMonedasAlternativas(DTOBelcorp dtoe) throws MareException, RemoteException;

	DTOSalida recuperarMarcasProducto(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida recuperarMarcasProductoMP(DTOOID dto) throws  MareException, RemoteException;

  Long obtenerOidModulo(String codigo) throws  MareException, RemoteException;

	DTOSalida obtenerMonedas(DTOBelcorp dto) throws MareException, RemoteException;

  DTOBoolean obtenerIndicadorFleteZonaUbigeo(DTOBelcorp dtoe) throws RemoteException, MareException;

  Long[] obtenerSubAccesosPorCodigoAcceso(String codAcceso) throws RemoteException, MareException;

    BigDecimal obtenerUltimoTipoCambio(Long moneda1, Long moneda2) throws MareException, RemoteException;
	 DTOOID obtenerMonedaPais (DTOOID dto)throws MareException, RemoteException;
	DTOSalida obtenerTiposCambioMoneda (DTOOID dto)throws MareException  , RemoteException;

	DTOSalida obtenerPeriodosPorCanal(DTOOID dtoin) throws  RemoteException, MareException, RemoteException;

	DTOOID obtenerOIDMonedaAltPais(Long oidPais, String codigoMonedaAlt) throws  RemoteException, MareException, RemoteException;

  BigDecimal obtenerTipoCambioAnterior(Long oidMoneda1, Long oidMoneda2, Date fechaDesde) throws MareException, RemoteException;

  DTOSalida obtenerMonedasPorPais(DTOBelcorp dto) throws RemoteException, MareException;
	
    DTOSalida obtenerOidCanalAccesoSubAcceso() throws RemoteException, MareException;

  DTOSubacceso buscarValoresDefectoAccSubac(DTOBelcorp dto) throws RemoteException, MareException;
}
