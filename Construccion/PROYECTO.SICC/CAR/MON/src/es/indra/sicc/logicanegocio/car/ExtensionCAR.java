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
 
package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public interface ExtensionCAR extends EJBObject 
{
  void validarInsertarSolapamientoCodEvaluacion(MareDTO datos) throws RemoteException, MareException ;

  void validarInsertarSolapamientoParamNR(MareDTO datos) throws RemoteException, MareException ;

  void  validarInsertarParamCalculoLC(MareDTO datos) throws RemoteException, MareException ;

  void  validarModSolapamientoCodEvaluacion(MareDTO datos) throws RemoteException, MareException ;

  void  validarModSolapamientoParamNR(MareDTO datos) throws RemoteException, MareException;

  void  validarModParamCalculoLC(MareDTO datos) throws RemoteException, MareException ;
}