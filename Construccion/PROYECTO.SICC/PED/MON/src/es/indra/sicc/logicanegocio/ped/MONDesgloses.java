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
 *
 */

/**
 * @Autor: Hugo A. Mansi
 * @Fecha: 28/10/2004
 * @DMCO: SICC-DMCO-PED-201-354-N029
 * @Modifico: --
 * @Modificado: --
 * @Descripción:-- 
 * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
 * 
 */

package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCargarPaginaDesglose;
import es.indra.sicc.dtos.ped.DTOEDesglose;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONDesgloses extends EJBObject  {
	DTOCargarPaginaDesglose cargarPaginaDesglose(DTOEDesglose dto) throws MareException, RemoteException;

	DTOSalida agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto) throws MareException, RemoteException;

	DTOSalida desgloseNumeroSolicitud(DTOEDesglose dto) throws  RemoteException, MareException, RemoteException;

	DTOSalida agrupacionAcceso(DTOEDesglose dto) throws MareException, RemoteException;

	DTOSalida agrupacionEstados(DTOEDesglose dto) throws MareException, RemoteException;

	DTOSalida agrupacionContenido(DTOEDesglose dto) throws MareException, RemoteException;
}