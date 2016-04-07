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
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ccc.DTOCruzarCupon3conCupon1;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOColeccion;

public interface MONGestionCuponTramite extends EJBObject  {
	void cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto) throws MareException, RemoteException;

	DTOSalida consultarCupon3(DTOConsultarCupon3 dto) throws MareException, RemoteException;

	DTOSalida consultarCupon3(DTOCancelarCupon3 dto) throws RemoteException, MareException;

	void cancelarCupon3(DTOOIDs dtoOIDs) throws MareException, RemoteException;

	DTOColeccion situacionesACancelar() throws MareException, RemoteException;

	void eliminarCupon3(DTOOIDs dto) throws MareException, RemoteException;
}