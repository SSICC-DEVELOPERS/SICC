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
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasDtoRecargo;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.sicc.dtos.ccc.DTONumero;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOEntidad;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface MONGenerarDtoRecargo extends EJBObject  {
	DTOSalida obtenerSubprocesosPorCodigoProceso(DTOCodigoProceso dto) throws MareException, RemoteException;

	DTOSalida buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dto) throws MareException, RemoteException;

	void confirmarDtoRecargo(DTOBuscarCuotasDtoRecargo dto) throws MareException, RemoteException;

	DTOEntidad[] agrupar(RecordSet resultado) throws RemoteException, MareException;

	DTONumero obtenerSiguienteNumeroDtoRecargo(DTOBelcorp dto) throws MareException, RemoteException;
}