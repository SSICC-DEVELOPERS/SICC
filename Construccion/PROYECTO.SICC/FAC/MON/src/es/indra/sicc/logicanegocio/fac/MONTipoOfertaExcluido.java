/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONTipoOfertaExcluido extends EJBObject {
    void actualizarTipoOfertaExcluido(DTOTipoOfertaExcluido dtoe)
        throws RemoteException, MareException;

    DTOSalida buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dtoe)
        throws RemoteException, MareException;

    void eliminarTipoOfertaExcluido(DTOOIDs dtoe)
        throws RemoteException, MareException;
}
