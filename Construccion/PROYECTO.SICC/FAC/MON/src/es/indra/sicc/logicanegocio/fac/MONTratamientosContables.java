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
 
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.fac.DTOApFormPagE;
import es.indra.sicc.dtos.fac.DTOFACDocumentoSubacceso;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACPosicionDocContable;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.util.DTOOIDs;

public interface MONTratamientosContables extends EJBObject  {
	void generarRegistroCC(DTOFACConsolidado dtoConso) throws RemoteException, MareException;

	ArrayList generarApuntesFormaPago(DTOApFormPagE dtoE, int numDecimales) throws RemoteException, MareException;

	DTOFACDocumentoSubacceso activarNuevoRangoNumeracionOficial(DTOFACCabeceraSolicitud consolidado, Long tipoDocumentoLegal) throws RemoteException, MareException;

	void generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable) throws RemoteException, MareException;

	void generarRegistroUnicoVenta(DTOFACConsolidado dtoConsolidado) throws RemoteException, MareException;

	void grabarDocumentoContable(DTOFACConsolidado dtoConsolidado) throws RemoteException, MareException;

	Hashtable recuperarTiposDocumento(DTOFACConsolidado dtoConsolidado) throws RemoteException, MareException;

	ArrayList seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento) throws RemoteException, MareException;

	void actualizarStockSeguimiento(DTOFACConsolidado dtoConsolidado) throws RemoteException, MareException;

	DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoe) throws RemoteException, MareException;

    void grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado) throws MareException, RemoteException;

    void regenerarCuentaCorriente(DTOOIDs tiposSolicitud) throws RemoteException, MareException;

    Hashtable actualizarNumeroDocumentoLegal(DTOFACCabeceraSolicitud consolidado, Hashtable hashTiposDocumento, Long clave, Long oidTipoPrograma, Long oidDocumLegalRef) throws RemoteException, MareException;

    void generarRegistroCC2(DTOFACConsolidado dtoConso) throws MareException, 
                                                               RemoteException;
}
