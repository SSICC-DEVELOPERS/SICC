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
package es.indra.sicc.logicanegocio.cra;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.sicc.util.DTOSalida;

public interface MONUtilidadesCRA extends EJBObject  {
  DTOSalida obtieneRegiones(DTOGrupoZonas dto) throws RemoteException;

  DTOSalida obtieneZonas(DTOGrupoZonas dto) throws RemoteException;
}