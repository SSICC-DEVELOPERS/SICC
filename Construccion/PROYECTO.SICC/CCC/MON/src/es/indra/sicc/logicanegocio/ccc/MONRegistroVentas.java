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
import es.indra.sicc.dtos.ccc.DTORegistroVentas;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas;
import es.indra.sicc.dtos.ccc.DTONumRegistros;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ccc.DTOFecha;
import es.indra.sicc.util.DTOBelcorp;

public interface MONRegistroVentas extends EJBObject  {
	void guardarRegistroVentas(DTORegistroVentas dto) throws  MareException, RemoteException;

	void eliminarRegistrosVentas(DTOOIDs dto) throws  MareException, RemoteException;

	DTONumRegistros cerrarRegistrosVentas(DTOBuscarRegistroVentas dto) throws  MareException, RemoteException;

	DTOSalida buscarRegistroVentas(DTOBuscarRegistroVentas dto) throws RemoteException, MareException;

	DTOSalida buscarRegistroVentas(DTOOID dto) throws RemoteException, MareException;

	DTONumRegistros reabrirRegistrosVentas(DTOFecha dtoe) throws RemoteException, MareException;

	DTOSalida obtenerTasasImpuestoPorPais(DTOBelcorp dtoe) throws  MareException, RemoteException;

	DTOSalida obtenerCoeficienteImpuesto(DTOOID dto) throws MareException, RemoteException;

    void update(DTORegistroVentas dtoe) throws MareException, RemoteException;

    DTOSalida creacionFichero(DTOBuscarRegistroVentas dto) throws MareException, 
                                                                  RemoteException;
}
