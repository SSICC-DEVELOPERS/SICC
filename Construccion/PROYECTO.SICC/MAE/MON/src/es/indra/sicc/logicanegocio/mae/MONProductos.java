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
 */
package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mae.DTOCombosBusquedaMateriales;
import es.indra.sicc.dtos.mae.DTOCombosMateriales;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;

/**
 * 
 *  pperanzola - 20/10/2005 - [1] se modifica según el modelo GCC-PRE-MAE-INT-001
 */
public interface MONProductos extends EJBObject 
{
    DTOCombosBusquedaMateriales rellenarCombosBusquedaMateriales(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida buscar(DTOBusquedaMateriales dto) throws MareException, RemoteException;

    void actualizar(DTOProducto dto) throws MareException, RemoteException;

    DTOProducto consultar(DTOOID dto) throws RemoteException, MareException;

    DTOCombosMateriales relllenarCombosMateriales(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida obtenerGenericosPorPais(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida obtenerSuperGenericosPorPais(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida obtenerUnidadesNegocioPorPais(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida obtenerNegocioPorPais(DTOBelcorp dto) throws MareException, RemoteException;

	Long obtenerOidProducto(Long pais, String codigoSAP) throws MareException, RemoteException;

	RecordSet obtenerProductosPais(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerEstatusPorPais(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerLineasProductoPorPais(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException, RemoteException;

  DTOSalida detalleInformacionProducto(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerProductosPais2(DTOBelcorp dto) throws MareException, RemoteException;

    String obtenerCUV(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerProgramasFidelizacion(DTOBelcorp dto) throws MareException, RemoteException;//[1]


}