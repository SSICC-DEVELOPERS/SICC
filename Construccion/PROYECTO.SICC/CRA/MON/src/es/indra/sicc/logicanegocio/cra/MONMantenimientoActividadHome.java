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

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


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
public interface MONMantenimientoActividadHome extends EJBHome {
    MONMantenimientoActividad create() throws RemoteException, CreateException;
}
