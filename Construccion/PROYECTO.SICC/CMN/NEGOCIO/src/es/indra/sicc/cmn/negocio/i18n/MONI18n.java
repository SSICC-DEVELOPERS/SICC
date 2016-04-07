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
 
package es.indra.sicc.cmn.negocio.i18n;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.util.DTOSalida;

import es.indra.mare.common.exception.MareException;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CMN - Requisitos Generales
 * Componente:        MONI18nBean - Clase Bean
 * Fecha:             03/12/2003
 * Observaciones:     Basado en Modelo de Componentes SICC-DMCO-GEN-201-310
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 
public interface MONI18n extends EJBObject {

    DTOSalida recuperarTraducciones(String entidad, Long pk) throws MareException, RemoteException;

    void insertarTraducciones(String entidad, Long oid, Vector valores) throws MareException, RemoteException;

    void eliminarTraducciones(String Entidad, Long oidPK) throws MareException, RemoteException;

	DTOSalida recuperarTraducciones(String entidad, Long oid, Long idioma) throws MareException, RemoteException;

	DTOSalida recuperarTraducciones(String entidad, Long oid, Long idioma, Byte atributo) throws MareException, RemoteException;
  void actualizaTraducciones (String entidad, Long oid, Vector valores) throws MareException , RemoteException;

}