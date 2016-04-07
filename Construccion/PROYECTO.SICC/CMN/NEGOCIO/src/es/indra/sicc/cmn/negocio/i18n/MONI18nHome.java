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
 
package es.indra.sicc.cmn.negocio.i18n;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

/**
 * Sistema:           Belcorp
 * Modulo:            CMN - Requisitos Generales
 * Componente:        MONI18nBean - Clase Bean
 * Fecha:             03/12/2003
 * Observaciones:     Basado en Modelo de Componentes SICC-DMCO-GEN-201-310
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 
public interface MONI18nHome extends EJBHome {
    MONI18n create() throws RemoteException, CreateException;
}