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
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.util.DTOSalida;

public interface MONReasignacionCartera extends EJBObject 
{
  void reasignarCartera(DTOAsignacionesCobranza dto) throws MareException, RemoteException;

  DTOSalida buscarAsignacionesCobranza(DTOAsignacionesCobranza dto) throws MareException, RemoteException;
}