package es.indra.sicc.entidades.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.auditoria.EJBLocalHomeSICCAuditable;

import java.rmi.RemoteException;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


public interface DetalleMAVLocalHome extends EJBLocalHomeSICCAuditable {
    DetalleMAVLocal create(Double precioEstandar, Double precio, Long oidTipoCliente, Long oidPeriodo, Double precioContable) throws MareException, CreateException;

    DetalleMAVLocal findByPrimaryKey(Long primaryKey) throws FinderException;

    Collection findAll() throws  FinderException, RemoteException ;
}
