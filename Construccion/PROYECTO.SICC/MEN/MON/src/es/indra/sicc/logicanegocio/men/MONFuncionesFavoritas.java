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

package es.indra.sicc.logicanegocio.men;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.men.DTOCargaFavoritos;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.dtos.men.DTOEntradaSeleccionarFuncionesFavoritas;
import es.indra.sicc.dtos.men.DTOFavoritos;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
/**
 * Sistema:       Belcorp
 * Modulo:        MEN
 * Componente:    MONFuncionesFavoritas - Interfaz remota
 * Fecha:         01/04/2003
 * 
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */

public interface MONFuncionesFavoritas extends EJBObject {
	void insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF) throws RemoteException, MareException;

	DTOSalida consultaFavorito(DTOEntradaObtieneFuncion dtoEOF) throws RemoteException, MareException;

	DTOSalida obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe) throws RemoteException, MareException;

	DTOCargaFavoritos consultaFavoritos(DTOBelcorp dto) throws RemoteException, MareException;

	DTOString insertaFavoritos(DTOFavoritos dto) throws RemoteException, MareException;

}