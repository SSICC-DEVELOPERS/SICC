package es.indra.sicc.logicanegocio.cra;
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
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.cra.util.Actividad;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;


public interface MONQuartz extends EJBObject  {
  void ScheduleAdd(Actividad actividad) throws RemoteException, MareException;

  void ScheduleRemove(Actividad actividad) throws RemoteException, MareException;

  Actividad ScheduleFind(Long codigoActividad, Date fechaEjecucion) throws RemoteException, MareException;


}