/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.ccc;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ccc.DTOMovBanc;
import es.indra.sicc.dtos.ccc.DTONumerosLote;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancDepurar;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancConsultar;
import es.indra.sicc.dtos.ccc.DTONumeroLote;
import es.indra.sicc.dtos.ccc.DTOBuscarConfirmarMovBanc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;

public interface MONRecaudoEntFin extends EJBObject  {

    /** 
     * M�todo para obtener los registros que cumplen 
     * los criterios de busqueda determinados en el par�metro de entrada
     * @param dto DTOConsultarCupon3 con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
	DTOSalida consultarCupon3(DTOConsultarCupon3 dto) throws  MareException,  RemoteException;

    /** 
     * Establece a "Conciliado" cada uno de los registros que llegan de entrada
     * @param dtoOIDs DTOOIDs con los oids de los registros
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * pudo realizar la cancelaci�n
     */
	 void cancelarCupon3(DTOOIDs dtoOIDs) throws  MareException, RemoteException;

    /** 
     * M�todo para obtener las situaciones a cancelar
     * @return DTOColeccion con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos 
     */
	 DTOColeccion situacionesACancelar() throws  MareException, RemoteException;

    /** 
     * M�todo para obtener los registros que cumplen 
     * los criterios de busqueda determinados en el par�metro de entrada
     * @param dto DTOBuscarMovBancDepurar con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */	
	 DTOSalida buscarMovBancDepurar(DTOBuscarMovBancDepurar dto) throws  MareException, RemoteException;

    /** 
     * M�todo para obtener el detalle de un Movimiento Bancario
     * @param dto DTOOID con el oid del movimiento bancario
     * @return DTOSalida con los datos del registro encontrado
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontr� el registro
     */	
	 DTOSalida detalleMovBanc(DTOMovBanc dto) throws  MareException, RemoteException;

    /** 
     * M�todo para traspasar movimientos bancarios
     * @param dto DTOOIDs con los oids de los movimientos bancarios a traspasar
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron los movimientos bancarios
     */	
	 void traspasarMovBanc(DTOOIDs dto) throws  MareException, RemoteException;

    /** 
     * M�todo para obtener los registros que cumplen 
     * los criterios de busqueda determinados en el par�metro de entrada
     * @param dto DTOBuscarMovBancConsultar con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */	
	 DTOSalida buscarMovBancConsultar(DTOBuscarMovBancConsultar dto) throws  MareException, RemoteException;

   /** 
     * M�todo para realizar la confirmaci�n de movimientos bancarios 
     * @param dto DTONumerosLote con el n�mero de lote
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron registros
     */	
	 void confirmarMovBanc(DTONumerosLote dto) throws  MareException, RemoteException;

    /** 
     * M�todo para obtener los detalles de movimientos Bancarios
     * @param dto DTONumerosLote
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron registros
     */	
	 DTOSalida detalleMovBanc(DTONumeroLote dto) throws  MareException, RemoteException;

    /** 
     * M�todo para obtener los registros que cumplen 
     * los criterios de busqueda determinados en el par�metro de entrada
     * @param dto DTOBuscarConfirmarMovBanc con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */	
	 DTOSalida buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto) throws  RemoteException, MareException, RemoteException;

   DTOSalida consultarCupon3(DTOCancelarCupon3 dto) throws RemoteException, MareException;

	void simularMovBanc(DTONumerosLote dto) throws MareException, RemoteException;


}