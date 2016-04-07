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
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.util.DTOOIDs;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;

public interface MONReversionFAC extends EJBObject  {
	void desasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws RemoteException, MareException;

	void eliminarMensajeProductoFueraDocumentoLegal(DTOFACCabeceraDocContable dtoDocContable) throws RemoteException, MareException;
    
    //se elimina por incidencia 17582
	//void revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws RemoteException, MareException;

	void revertirFacturacion(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws RemoteException, MareException;

	void reasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws RemoteException, MareException;

	DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoE) throws RemoteException, MareException;

    void revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException, RemoteException;

  void revertirFacturacionOffLine(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws RemoteException, MareException;

  DTOFACReasignarNumeroDocContable reasignarNumeroDocumentoContableAsignar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws MareException, RemoteException;

  void reasignarNumeroDocumentoContableConfirmar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws  Exception, MareException, RemoteException;
}