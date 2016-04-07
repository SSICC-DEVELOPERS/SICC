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

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.cra.DTOActividadesEliminar;
import es.indra.sicc.dtos.cra.DTODepartamentosProcesos;
import es.indra.sicc.dtos.cra.DTOMensajes;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.Date;

import javax.ejb.EJBObject;
import java.util.ArrayList;


/**
 * Sistema:         Belcorp
 * Modulo:          CRA - Cronograma de Actividades
 * Componente:      MONMantenimientoActividadBean - Clase Bean
 * Fecha:           04/11/2003
 * Observaciones: Basado en Modelo de Componentes SICC-DMCO-CRA-201-300.zip
 * Este componente realiza el ABMC de Actividades
 *
 * @version         1.0
 * @author          Gustavo De Marzi
 */
public interface MONMantenimientoActividad extends EJBObject {
    void insertaActividad(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    DTOSalida buscaPorCriterio(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    void actualizaActividad(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    void eliminaActividad(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    DTOSalida obtenerProcesosDisponibles(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    DTOSalida obtenerProcesosAsignados (DTOActividad dtoActividad)
        throws MareException, RemoteException;

    DTOSalida obtenerActividadesPosteriores(DTOActividad dtoActividad)
        throws MareException, RemoteException;

    Date obtieneSiguienteFechaActividad(DTOActividad dtoActividad)
        throws RemoteException, MareException;

    void enviaMensajes(ArrayList mensajes)
        throws RemoteException, MareException;

   /* void eliminaActividades(DTOActividadesEliminar dto)
        throws MareException, RemoteException;*/

    DTODepartamentosProcesos obtenerDatosInsercion(DTOActividad dto)
        throws MareException, RemoteException;

    DTOSalida obtieneActividades(DTOActividad dto)
        throws MareException, RemoteException;

    DTOSalida obtieneClasesActividades(DTOBelcorp dto)
        throws MareException, RemoteException;

    void eliminaActividades(DTOOIDs dto) throws MareException, RemoteException;

    String obtieneSiguienteHoraActividad(DTOActividad dtoActividad) throws MareException, RemoteException;

  DTOSalida obtieneActividadesPorTipoSolicitud(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerInfoActividad(DTOOID dtoOidActividad) throws MareException, RemoteException;
}
