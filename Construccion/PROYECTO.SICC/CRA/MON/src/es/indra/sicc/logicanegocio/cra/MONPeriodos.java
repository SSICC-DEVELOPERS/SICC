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

import es.indra.sicc.dtos.mae.DTOBusquedaPeriodos;
import java.util.Collection;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.cra.DTORecalculoPeriodos;
import es.indra.sicc.dtos.cra.DTOEntradaMatrizDias;
import es.indra.sicc.util.DTOOIDs;
import java.sql.Date;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.cra.DTOBuscarPeriodos;

public interface MONPeriodos extends EJBObject  { 

    DTOSalida obtienePeriodosConsulta(DTOCriteriosPeriodo criteriosPeriodo) throws MareException, RemoteException;

    void insertaPeriodo(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

    DTOSalida obtieneDatosPeriodosCorporativos(DTOAsociadosAPeriodo asociadosAPeriodo) throws MareException, RemoteException;

    DTOSalida obtieneDatosPeriodosCorporativos(DTOEntradaMatrizDias dtoEntradaMatrizDias) throws MareException,RemoteException;

    DTOSalida obtienePeriodo(DTOAsociadosAPeriodo asociadosAPeriodo) throws RemoteException, MareException;

    void eliminaPeriodo(DTOID dtoID) throws MareException, RemoteException;

    Collection recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos,Collection collPeriodos) throws MareException,RemoteException;

    DTOSalida recuperaTodos() throws MareException, RemoteException;

    void recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos) throws MareException, RemoteException;    

    DTOSalida obtienePeriodo(Long pais, Long marca, Long canal, String anio) throws RemoteException, MareException;

    DTOSalida obtienePeriodosPMCPosteriores(Integer pais, Integer marca, Integer canal) throws MareException, RemoteException;

    DTOSalida obtienePeriodosAnteriores(DTOPeriodo dtoID) throws MareException, RemoteException;

    DTOSalida obtienePeriodoEvaluacion (Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal) throws RemoteException, MareException;

    void actualizaPeriodo(DTOPeriodo dtoEntrada) throws MareException, RemoteException;

    DTOSalida obtieneActividades(DTOID dtoEntrada) throws MareException, RemoteException;

    DTOSalida obtienePeriodosConsulta(String id, String anio, String pais) throws MareException, RemoteException;

    Boolean fechaEnPeriodo(java.sql.Date fecha,DTOPeriodo periodo) throws MareException, RemoteException;

    void insertaPeriodos(java.util.Collection periodos) throws MareException,RemoteException;

    void actualizaPeriodos(java.util.Collection collPeriodos) throws MareException, RemoteException;

    DTOPeriodo obtienePeriodoActual(Long pais, Long marca, Long canal) throws  MareException, RemoteException;

    DTOSalida obtienePeriodosCalculados(DTOAsociadosAPeriodo asociadosAPeriodo) throws MareException, RemoteException;

    void eliminaVariosPeriodos(DTOOIDs dtoOids) throws MareException, RemoteException;

    DTOSalida obtienePeriodos(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

  DTOSalida obtienePeriodosFecha(DTOPeriodo dto) throws MareException, RemoteException;

  DTOPeriodo obtienePeriodosPMCCodigo(DTOPeriodo dto) throws MareException, RemoteException;

  DTOOIDs obtienePeriodosEntre(Long oidPeriodoIni, Long oidPeriodoFin) throws RemoteException, MareException;

  Integer dayDiff(Date fecha1, Date fecha2) throws MareException, RemoteException;

  DTOSalida obtienePeriodosAnioAcceso(DTOPeriodo dto) throws MareException, RemoteException;

  DTOSalida obtenerListaPeriodosPosteriores(DTOPeriodo dto) throws RemoteException, MareException;

  DTOSalida obtienePeriodosPosterioresFechaActual(DTOID dto) throws MareException, RemoteException;

  Collection obtienePeriodosPosteriores(DTOPeriodo dtoEntrada) throws MareException, RemoteException ;

  DTOPeriodo obtienePrimerPeriodoFecha(Long pais, Long marca, Long canal, Date fecha) throws MareException, RemoteException;

    DTOOID obtenerPrimerPeriodoREP(DTOBelcorp dto) throws MareException, RemoteException;

    DTOBoolean validaPeriodosREP(DTOOIDs dto) throws MareException, RemoteException;

  DTOSalida obtenerPeriodosPosterioresActual(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

  DTOSalida obtenerPeriodosPosterioresActivos(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

  DTOSalida obtenerPeriodosEntre(DTOOIDs dtoe) throws MareException, RemoteException;

  DTOSalida obtenerListaPeriodosPosterioresMAV(DTOPeriodo dto) throws MareException, RemoteException;

    DTOSalida obtenerPeriodosEntreFechas(DTOPeriodo dtoe) throws MareException, RemoteException;

  DTOSalida obtienePeriodosRecMasivos(DTOPeriodo dtoe) throws MareException, RemoteException;

  DTOPeriodo obtieneMenorPeriodoActual(Long pais, Long marca, Long canal) throws RemoteException, MareException;

    DTOOID  obtenerCodigoPeriodoComercial(DTOPeriodo dto) throws MareException, RemoteException;

    DTOSalida obtenerFechasPeriodo(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

    DTOSalida obtienePeriodosMayorIgualActual(DTOPeriodo dtoPeriodo) throws MareException, RemoteException;

    DTOPeriodo obtienePeriodoActual(Long pais, Long marca, Long canal, Long periodo) throws MareException, RemoteException;

    Collection obtienePeriodosActuales(DTOBuscarPeriodos dtoE) throws MareException, RemoteException;

    DTOSalida obtenerAnioPeriodo(DTOOID dtoe) throws RemoteException, MareException;

    DTOID obtenerPeriodoActual(DTOID dtoe) throws MareException, RemoteException;

    DTOID obtenerPeriodoPosteriorActual(DTOID dtoe) throws MareException, RemoteException;

    DTOPeriodo obtenerPeriodo(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida obtienePeriodoActualYPosteriores(DTOID dtoe) throws MareException, RemoteException;

}
