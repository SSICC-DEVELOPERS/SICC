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
 *
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONArmadoPedidosHM extends EJBObject  {
  DTOSalida visualizarListaPicado(DTOOID dtoE) throws MareException, RemoteException;

  void  revertirArmadoPedidos(DTOOID dtoE) throws MareException, RemoteException;
}