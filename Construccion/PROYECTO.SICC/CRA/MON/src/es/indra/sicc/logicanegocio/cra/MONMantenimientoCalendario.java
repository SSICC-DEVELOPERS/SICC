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
package es.indra.sicc.logicanegocio.cra;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cra.DTOCalendario;
import es.indra.sicc.util.DTOSalida;
import java.sql.Date;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOSalidaCalendario;

public interface MONMantenimientoCalendario extends EJBObject 
{
  void insertaFeriado(DTOCalendario dto) throws  MareException, RemoteException;


  void modificaFeriado(DTOCalendario dto) throws  MareException, RemoteException;

  void eliminaFeriado(DTOCalendario dto) throws  MareException, RemoteException;

  Date buscaDiaNoFestivo(Date fecha) throws  MareException, RemoteException;

  Integer calculaNumeroFestivos(Date fechaInicio, Integer intervalo) throws  MareException, RemoteException;


  DTOSalidaCalendario recuperaFeriado(DTOCalendario dto) throws RemoteException, MareException;
}