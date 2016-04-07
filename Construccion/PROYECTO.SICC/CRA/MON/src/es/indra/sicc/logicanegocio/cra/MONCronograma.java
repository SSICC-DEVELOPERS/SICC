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
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.cra.DTOBuscarActividadOrigen;
import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import java.sql.Date;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTOCronogramaFecha;
import es.indra.sicc.dtos.cra.DTONuevasActividadesCronograma;
import java.sql.Timestamp;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import es.indra.sicc.dtos.cra.DTOGenerarCronogramaporZonas;
import java.util.ArrayList;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOCalcularFechaPrevista;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTODate;

public interface MONCronograma extends EJBObject  {
  void actualizaCronograma(DTOCronograma dto) throws MareException, RemoteException;

  DTOCronograma compruebaFacturacion(DTOCronograma dto) throws MareException, RemoteException;

  DTOBoolean existeCronograma(DTOCronograma dto) throws MareException, RemoteException;

  DTOCronograma generaCronograma(DTOCronograma dto) throws MareException, RemoteException;

  DTOCronograma obtieneCronograma(DTOCronograma dto) throws MareException, RemoteException;

  ICNCronograma obtieneCronogramaTipo(DTOCronograma dto) throws MareException, RemoteException;

  DTOSalida obtieneZonasPorGrupo(DTOOID dto) throws MareException, RemoteException;

  void eliminaTareasActividad(DTOOID dto) throws MareException, RemoteException;

  void eliminaCronograma(DTOCronograma dto) throws MareException, RemoteException;

  DTOCronogramaFecha obtieneFechaInicioCronograma(Long zona, Long periodo, Long actividad) throws RemoteException, MareException;

  DTOGrupoCronograma obtieneReferenciadas(DTOActividadGrupo dto) throws RemoteException, MareException;

  DTOSalida obtieneNuevasActividadesCronograma(DTONuevasActividadesCronograma DTOE) throws MareException, RemoteException;

  DTOSalida buscarFechasFacPorZona(DTOOID dto) throws MareException, RemoteException;

  Timestamp obtenerMayorFechaFacturacion(DTOOID dto) throws MareException, RemoteException;

  DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException, RemoteException;

  ArrayList obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo) throws MareException, RemoteException;

    DTOSalida obtenerGrupoZonas(DTOPeriodo dto) throws RemoteException, MareException;

    DTOSalida obtenerZonas(DTOOID dto) throws RemoteException, MareException;

    DTOBoolean validarGeneracion(DTOGenerarCronogramaporZonas dto) throws MareException, RemoteException;

    void generarCronogramaporZonas(DTOGenerarCronogramaporZonas dto) throws MareException, RemoteException;

    DTOSalida obtenerActividadOrigenDeOtroPeriodo(DTOBuscarActividadOrigen dtoe) throws RemoteException, MareException;

    DTODate calcularFechaPrevista(DTOCalcularFechaPrevista dtoe) throws MareException, RemoteException;
    
    DTOSalida obtenerMensajesCRA(DTOBelcorp dto) throws MareException, RemoteException;

}