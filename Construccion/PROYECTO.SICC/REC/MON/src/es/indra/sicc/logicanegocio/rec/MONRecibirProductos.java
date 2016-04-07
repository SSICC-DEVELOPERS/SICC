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

import es.indra.sicc.dtos.rec.DTOBuscarProductosReclamados;
import es.indra.sicc.dtos.rec.DTORecibirProductos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MONRecibirProductos extends EJBObject  {
    DTOSalida buscarProductosReclamados(DTOBuscarProductosReclamados dto) throws MareException, RemoteException;

    void recibirProductos(DTORecibirProductos dto) throws RemoteException, MareException;

    void generarSolicitud(ArrayList lineas, DTOOID dtoOid) throws RemoteException, MareException;
}