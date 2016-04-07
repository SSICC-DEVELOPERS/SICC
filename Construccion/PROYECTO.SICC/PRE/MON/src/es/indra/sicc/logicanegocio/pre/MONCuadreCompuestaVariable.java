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
 *
 */
package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.pre.DTOOferta;

public interface MONCuadreCompuestaVariable extends EJBObject  {
    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion) throws RemoteException, MareException;

    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion, DTOOferta dtoOferta) throws RemoteException, MareException;

}