package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOEValidarProducto;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONCargaMantenimientoListas extends EJBObject {
    DTOSProductoValidado validarProductos(DTOEValidarProducto dto)
        throws RemoteException, MareException;
}