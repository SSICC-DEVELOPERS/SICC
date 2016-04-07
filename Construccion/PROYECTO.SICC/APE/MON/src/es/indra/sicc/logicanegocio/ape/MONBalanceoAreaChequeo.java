/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOParamBalanceoAreaChequeo;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;


public interface MONBalanceoAreaChequeo extends EJBObject  {
  void guardarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws MareException, RemoteException;

  void eliminarParamBalanceoAreaChequeo(DTOOIDs dtoE) throws MareException, RemoteException;

  DTOSalida consultarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws RemoteException, MareException;

  DTOSalida obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws MareException, RemoteException;

  DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) throws MareException, RemoteException;
  
}