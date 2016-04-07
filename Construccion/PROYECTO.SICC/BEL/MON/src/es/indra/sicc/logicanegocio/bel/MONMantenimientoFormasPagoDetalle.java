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
import es.indra.sicc.dtos.bel.DTOEBuscarFormasPagoDetalle;
import es.indra.sicc.dtos.bel.DTOFormaPagoDetalle;
import es.indra.sicc.dtos.bel.DTOEDetalleFormaPago;
import es.indra.sicc.dtos.cra.DTOActividad;

public interface MONMantenimientoFormasPagoDetalle extends EJBObject  {
	/** 
     * Método para buscar detalles de formas de Pago
     * @param dto DTOEBuscarFormasPagoDetalle con los atributos por los que se filtrará la busqueda
     * @return DTOSalida con los detalles de las formas de pago
     * @exception MareException 
     */
	public DTOSalida buscarFormasPagoDetalle (DTOEBuscarFormasPagoDetalle dto) throws MareException,RemoteException;

	/** 
     * Método para consultar un detalle de una forma de Pago
     * @param dto DTOOID con el oid del detalle a consultar
     * @return DTOFormaPagoDetalle con los datos del detalle
     * @exception MareException 
     */	
	public DTOFormaPagoDetalle consultarFormaPagoDetalle (DTOOID dto)throws MareException,RemoteException;

	/** 
     * Método para consultar los detalles de una forma de Pago
     * @param dto DTOOID con el oid de la forma de pago cuyos detalles queremos consultar
     * @return DTOSalida con los detalles de la forma de pago
     * @exception MareException 
     */	
	public DTOSalida consultarDetalleFormaPago (DTOOID dto) throws MareException,RemoteException;

	/** 
     * Método para insertar/modificar los detalles de una forma de Pago
     * @param dto DTOEDetalleFormaPago con los datos de los detalles de la forma de pago y el oid de la forma de pago
     * @exception MareException 
     */	
	public void guardarDetalleFormaPago (DTOEDetalleFormaPago dto) throws MareException,RemoteException;

	DTOSalida recargaComboActividades(DTOActividad dto) throws MareException, RemoteException;
}