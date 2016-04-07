/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.rec.DTOResultadosChequeo;

public interface MONResultadoChequeo extends EJBObject  {
    DTOSalida buscarSolicitudesCliente(DTOOIDPaginado dto) throws MareException, RemoteException;

    DTOSalida obtenerResultadosChequeo(DTOBelcorp dto) throws MareException, RemoteException;

/* gPineda cdos 09/05/06
 * Incidencia BELC300021334: Se modifica el parametro de entrada para recibir un dto
 * (creado por esta incidencia) que contiene un array de dtos
 */
  void actualizaResultadoChequeo(DTOResultadosChequeo dto) throws RemoteException, MareException;

  DTOSalida obtenerPosicionesSolicitudChequeo(DTOOIDPaginado dto) throws RemoteException, MareException;
}