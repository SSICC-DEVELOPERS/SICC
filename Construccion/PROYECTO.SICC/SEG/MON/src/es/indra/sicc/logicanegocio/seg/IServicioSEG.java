/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.seg;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo;
import es.indra.sicc.dtos.seg.DTOPMC;
import es.indra.sicc.dtos.seg.DTOSubaccesosPorAccesoYCanal;
import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import java.math.BigDecimal;

import java.rmi.RemoteException;
/**
 * Sistema:           Belcorp - SICC
 * Modulo:            SEG - Seguridad
 * Componente:        Interface IServicioSEG
 * Fecha:             07/04/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Dario Hruszecki
 */ 

public interface IServicioSEG  {
    public DTOSalida obtenerSubaccesosMultiAcceso (DTOOIDs dto) throws  MareException; 
    public DTOSalida recuperarAccesosPorCanal(DTOAccesosPorCanal dtoe) throws MareException;
    public DTOSalida recuperarSubaccesosPorAccesoCanal(DTOSubaccesosPorAccesoYCanal dtoe) throws MareException;
    public DTOSalida recuperarPeriodosPorTipoPeriodo(DTOPeriodosPorTipoPeriodo dtoe) throws MareException;
    public DTOSalida recuperarTamanoTipoPeriodoPorCanal(Long canal) throws MareException;    
    public DTOPMC obtienePaisMarcaCanal (DTOFiltroPMC dtoe) throws MareException;

    /*
     * inc 260
     */
    public DTOSalida recuperarDescripcionPais(DTOInternacional internacional) throws MareException;

    /*
     * Nuevos métodos agregados en el modelo de componentes SICC-DMCO-SEG-201-319
     */
    public Integer obtenerLongitudNumeroCliente (Long oidPais) throws MareException;
    public Long obtenerOidCanal (String codigo) throws MareException;
    public Long obtenerOidPais (String codigo) throws MareException;
    public Long obtenerOidMarca (String codigo) throws MareException;
    public Long obtenerOidTipoVia (String codigo) throws MareException;
    public DTOSalida recuperarMarcas(DTOBelcorp dto, Boolean todos) throws MareException;
    public DTOSalida recuperarMarcas(DTOBelcorp dto) throws MareException;    
    public DTOSalida recuperarCanales(DTOBelcorp dto, Boolean todos) throws MareException;
    public DTOSalida recuperarCanales(DTOBelcorp dto) throws MareException;    
    public DTOSalida recuperarAccesos(DTOBelcorp dto, Boolean todos) throws MareException;
    public DTOSalida recuperarAccesos(DTOBelcorp dto) throws MareException;        
    public DTOSalida recuperarEmpresas(DTOBelcorp dto, Boolean todos) throws MareException;
    public DTOSalida recuperarSubaccesos(DTOBelcorp dto, Boolean todos) throws MareException;
    public DTOSalida recuperarSubaccesos(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarPaisesSinTodos (DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarPaises(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarEmpresasPorPais(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarTiposPeriodo(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarPeriodos(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarTiposVia (DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarDepartamentosPorPais (DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarDepartamentos(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarIdiomas(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarModulos(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarNacionalidades(DTOBelcorp dto) throws MareException;
    public DTOSalida recuperarPais(DTOOID dtoOid) throws MareException;
    public DTOCAS obtieneCanalAccesoSubacceso(DTOCargaCAS dto) throws MareException;
    public Long obtenerOidMoneda(String codigo) throws MareException;
    public BigDecimal obtenerCambioMonedaAlternativa(Long oidPais) throws MareException;
    public Long obtenerOidPeriodo(String codigo, Long canal) throws MareException;
    public DTOSalida obtenerAccesosPorCanal(DTOOID dto) throws MareException;
    public DTOSalida obtenerSubaccesosPorAcceso(DTOOID dto) throws MareException;
    public DTOSalida recuperarMarcasProducto(DTOBelcorp dto) throws MareException;
    public Long obtenerOidModulo(String codigo) throws MareException;
	public DTOSalida obtenerMonedas(DTOBelcorp dto) throws MareException;
    public DTOBoolean obtenerIndicadorFleteZonaUbigeo(DTOBelcorp dtoe) throws MareException;
    public Long[] obtenerSubAccesosPorCodigoAcceso(String codAcceso) throws MareException;
    BigDecimal obtenerUltimoTipoCambio(Long moneda1, Long moneda2) throws MareException;
	public DTOOID obtenerMonedaPais (DTOOID dto)throws MareException;
	public DTOOID obtenerOIDMonedaAltPais(Long oidPais, String codigoMonedaAlt) throws  RemoteException, MareException;
	public  DTOSalida obtenerTiposCambioMoneda (DTOOID dto)throws MareException;
	public DTOSalida obtenerPeriodosPorCanal(DTOOID dtoin) throws  RemoteException, MareException;
  public BigDecimal obtenerTipoCambio(Long moneda1, Long moneda2) throws MareException; 
}