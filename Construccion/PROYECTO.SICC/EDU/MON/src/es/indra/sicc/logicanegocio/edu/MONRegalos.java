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

package es.indra.sicc.logicanegocio.edu;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.edu.DTORegalo;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTOOIDRegalo;
import es.indra.sicc.dtos.edu.DTOObtieneRegalo;
import es.indra.sicc.dtos.edu.DTOConsultaRegalo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.edu.DTOEliminaRegalo;

public interface MONRegalos extends EJBObject  {
	void insertaRegalo(DTORegalo dto) throws MareException, RemoteException;

	DTOObtieneRegalo obtieneRegalo(DTOOIDRegalo dto) throws MareException, RemoteException;

	DTOSalida cargaRegalo(DTOConsultaRegalo dto) throws MareException, RemoteException;

	DTOSalida obtieneProductosRegalo(DTOOIDRegalo dto) throws MareException, RemoteException;

	void eliminaRegalo(DTOEliminaRegalo dto) throws MareException, RemoteException;

	void modificaRegalo(DTORegalo dto) throws MareException, RemoteException;

}