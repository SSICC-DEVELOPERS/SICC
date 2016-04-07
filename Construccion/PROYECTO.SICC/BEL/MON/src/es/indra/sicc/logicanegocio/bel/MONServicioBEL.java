/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.bel;

import javax.ejb.EJBObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.dtos.bel.DTOStock;
import es.indra.sicc.dtos.bel.DTOAlmOrigDest;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.bel.DTOCopiarParametrosBelcenter;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;
import java.math.BigDecimal;

public interface MONServicioBEL extends EJBObject  {

	/** 
     * Método para recuperar el Stock de una Agrupacion para un almacen y un producto determinados
     * @param pais Long con el oid del pais
     * @param almacen Long con el oid del almacen
     * @param producto Long con el oid del producto
     * @param codigoAgrupacion String con el codigo de agrupacion
     * @return Long  con el valor del Stock
     * @exception MareException 
     */	
	public Long recuperarStockEstadosAgrupados (Long pais, Long almacen, Long producto, String codigoAgrupacion) throws MareException,RemoteException;

	/** 
     * Método para obtener los medios de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosDePago (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener los medios de pago de un pais (datos asignables a un combo)
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosPagoCombo (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener los tipos de medios de pago
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerTiposMedioPago (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener las formas de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerFormasPagoCabecera  (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener los estados de mercancia de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerEstadosMercancia   (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener el subacceso asociado a una Maquina
     * @param dto DTOString con la cadena que identifica la Maquina
     * @return DTOOID con el oid del subacceso asociado
     * @exception MareException 
     */	
	public DTOOID obtenerSubaccesoAsociado (DTOString dto) throws MareException,RemoteException;

	/** 
     * Método para obtener los almacenes de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerAlmacenes  (DTOBelcorp dto) throws MareException,RemoteException;

	/** 
     * Método para obtener el Stock correspondiente a un almacen, un producto y un estado de mercancia determinados
     * @param almacen Long con el oid del almacen
     * @param estado Long con el oid del estado de la mercancia
     * @param producto Long con el oid del producto
     * @return Long  con el valor del saldo
	 * @exception MareException 
     */	
	public Long comprobarStock (Long almacen, Long estado, Long producto) throws MareException,RemoteException;

	/** 
     * Método para obtener las operaciones definidas
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerOperaciones() throws MareException,RemoteException;

	void moverRegistrosDeStock(DTOAlmOrigDest dtoAlmOrigDest) throws RemoteException, MareException;

	void eliminarRegistrosDeStock(DTOStock dtoStock) throws  RemoteException, MareException;

	DTOSalida consultarFPagoDetalNumPosi(DTOOID dtoe) throws MareException, RemoteException;

  DTOBoolean comprobarParametrizacionSubacceso(DTOOID dto) throws  RemoteException, MareException, RemoteException;

  void copiarParametrosBelcenter(DTOCopiarParametrosBelcenter dto) throws  RemoteException, MareException, RemoteException;

  DTOSalida obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws  RemoteException, MareException;

  DTOSalida obtenerTiposMovimientosCaja(DTOBelcorp dtoe) throws  RemoteException, MareException;

    DTOSalida obtenerMediosPagoBelcenter(DTOOID dto) throws MareException, RemoteException;

    void emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo, BigDecimal limiteEfectivoCaja) throws RemoteException, MareException;

    BigDecimal calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto) throws RemoteException, MareException;

  DTOSalida obtieneSubaccesosPRMBelcenter(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerAgrupacionStockCabecera(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws MareException, RemoteException;

  void emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo) throws MareException, RemoteException;

    DTOOID obtenerCanalVD(DTOString dtoe) throws MareException, 
                                                 RemoteException;
}
