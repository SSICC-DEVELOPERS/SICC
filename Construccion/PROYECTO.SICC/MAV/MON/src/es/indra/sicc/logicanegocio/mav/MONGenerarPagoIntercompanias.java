package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOGenerarPagoIntercompanias;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONGenerarPagoIntercompanias extends EJBObject {
    void generarPagoIntercompanias(DTOGenerarPagoIntercompanias dto)
        throws RemoteException, MareException;
}