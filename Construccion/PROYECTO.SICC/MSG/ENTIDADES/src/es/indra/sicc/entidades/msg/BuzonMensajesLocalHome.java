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
package es.indra.sicc.entidades.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.auditoria.EJBLocalHomeSICCAuditable;

import java.rmi.RemoteException;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;


public interface BuzonMensajesLocalHome extends EJBLocalHomeSICCAuditable {

	BuzonMensajesLocal create( Long paramNumeroSecuencial,Long paramOidCliente,Long paramOidMensaje,Long paramModulo) throws CreateException, MareException;

	BuzonMensajesLocal findByPrimaryKey( Long paramBuzonMensaPK) throws FinderException;

	Collection findAll() throws  FinderException, RemoteException;

  BuzonMensajesLocal findByUk(Long oidMensaje, Long oidCliente, Long numSecu) throws FinderException, RemoteException;


}