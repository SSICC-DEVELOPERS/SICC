/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.dtos.pre.DTOMatrizCodigoRecuperacion;
import es.indra.sicc.dtos.pre.DTOEBuscarProductosVenta;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosAlternativos;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosRecuperacion;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosReemplazo;
import es.indra.sicc.util.DTOOID;


public interface MONFuncionesAdicionales extends EJBObject  {

	DTOSalida cargarRegistroMatrizCodigosAlternativos(DTOProductoVenta productoPrincipal) throws MareException, RemoteException;

	DTOMatrizCodigoRecuperacion cargarRegistroMatrizCodigosRecuperacion(DTOProductoVenta productoPrincipal) throws MareException, RemoteException;

	DTOSalida cargarRegistroMatrizCodigosReemplazo(DTOProductoVenta productoPrincipal) throws MareException, RemoteException;

	DTOSalida buscarProductosVenta(DTOEBuscarProductosVenta dto) throws MareException, RemoteException;

	void guardarMatrizCodigosAlternativos(DTOProductosVenta dto) throws MareException, RemoteException;

	void guardarMatrizCodigosRecuperacion(DTOProductosVenta dto) throws MareException, RemoteException;

	void guardarMatrizCodigosReemplazo(DTOProductosVenta dto) throws MareException, RemoteException;

	void eliminarMatricesCodigosAlternativos(DTOOIDs dto) throws MareException, RemoteException;

   void eliminarMatricesCodigosRecuperacion(DTOOIDs dto) throws MareException, RemoteException;

   void eliminarMatricesCodigosReemplazo(DTOOIDs dto) throws MareException, RemoteException;

    DTOSalida buscarMatricesCodigosAlternativos(DTOEBuscarMatrizCodigosAlternativos dto) throws RemoteException, MareException;

    DTOSalida buscarMatricesCodigosRecuperacion(DTOEBuscarMatrizCodigosRecuperacion dto) throws RemoteException, MareException;

    DTOSalida buscarMatricesCodigosReemplazo(DTOEBuscarMatrizCodigosReemplazo dto) throws RemoteException, MareException;

   DTOSalida obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE) throws RemoteException, MareException;
}