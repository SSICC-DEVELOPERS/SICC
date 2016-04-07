/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialGeneracionVencimientos;
import es.indra.sicc.dtos.ccc.DTOCargaMasiva;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTODatosCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTOObtenerCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOParametrosSubproceso;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.dtos.ccc.DTOValidarNumeroDocumento;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.dtos.ccc.DTOConceptosGastosAbonos;
import es.indra.sicc.dtos.ccc.DTOBuscarMovimientosReasignacion;
import es.indra.sicc.dtos.ccc.DTOReasignacionPagos;

public interface MONCargosAbonos extends EJBObject  {
	public DTOSalida recargaSubprocesos(DTOOID dto) throws RemoteException, MareException;

	public DTOCargaInicialCargosAbonos obtenerDatosInicialesCargosAbonos(DTOCasoUso dto) throws RemoteException, MareException;

	//public RecordSet obtenerSubprocesosGestionCheques(Long idioma) throws MareException, RemoteException;

	public DTOCargaMasiva validarCarteraMasiva(DTOCargaMasiva cartera) throws RemoteException, MareException;

	public void enviarMensajesGastosAbonos(RecordSet conceptos, Long pais) throws RemoteException, MareException;

	public void aplicarCargosAbonos(DTOCargosAbonos dto) throws RemoteException, MareException;

	//public void validarClientesSubprocesos(DTOCargosAbonos dto) throws MareException, RemoteException;

	public DTOSalida buscar(DTOBuscarCargosAbonos dto) throws RemoteException, MareException;

	public void eliminar(DTOOIDs oids) throws RemoteException, MareException;

	public DTOCargosAbonos obtener(DTOObtenerCargosAbonos dto) throws RemoteException, MareException;

	//public void eliminarDetalles(Long cabecera) throws MareException, RemoteException;

	//public short conceptosGastosAbonos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros) throws RemoteException, MareException;

	//public short aplicacionCobros(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros) throws MareException, RemoteException;

	//public void guardarDetalle(DTODetalleCargosAbonos dto) throws MareException, RemoteException;

	//public short generacionVencimentos(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, Long pais, Long canal) throws MareException, RemoteException;

	//public void eliminarCargoAbono(Long oid) throws MareException, RemoteException;

	public short cancelacionCuotas(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, DTOCargosAbonos dtoCargosAbonos) throws RemoteException, MareException;

	//public DTOParametrosSubproceso obtenerParametrosSubproceso(String subproceso, Long proceso) throws MareException, RemoteException;

	public DTODatosCargaInicialConceptos cargaInicialConceptos(DTOCargaInicialConceptos dto) throws RemoteException, MareException;

	public DTOString bloquearCliente(DTOString dto) throws RemoteException, MareException;

	//public BigDecimal obtenerTasaCambioMonedaAlternativa(Long pais) throws RemoteException, MareException;

	public DTOCargaInicialGeneracionVencimientos cargaInicialVencimientos(DTOBelcorp dto) throws RemoteException, MareException;

	public DTOSalida obtenerDatosInicialesProcesos(DTOBelcorp dto) throws RemoteException, MareException;

	void enviarMensaje(DTOConceptosGastosAbonos dto) throws RemoteException, MareException;

	public DTOSalida obtenerTiposCargo(DTOBelcorp dto) throws RemoteException, MareException;

  DTOCargaInicialCargosAbonos obtenerNumeroIdentificacion(DTOCasoUso dto) throws MareException, RemoteException;

  DTOString validarNumeroDocumento(DTOValidarNumeroDocumento dto) throws MareException, RemoteException;

   void validarBloqueo(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida buscarBancosReasignar(DTOBuscarMovimientosReasignacion dtoe) throws MareException, RemoteException;

  void reasignarBancos(DTOReasignacionPagos dtoE) throws RemoteException, MareException;

}