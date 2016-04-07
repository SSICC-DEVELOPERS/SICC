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
 
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONConfiguracionBalanceo extends EJBObject 
{
  void guardarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConfiguracion) throws MareException, RemoteException;

  DTOSalida obtenerFuncionDistribucion(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida consultarConfiguracionBalanceo(DTOMantenerConfiguracionBalanceo dtoConsulta) throws MareException, RemoteException;

  void eliminarConfiguracionBalanceo(DTOOIDs dtoe) throws MareException, RemoteException;
}