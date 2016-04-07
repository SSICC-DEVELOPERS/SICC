package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTODatosMensaje;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;


public interface MONGenerarMensajes extends EJBObject {
    DTOBuzonMensajes generarMensaje(DTODatosMensaje dto) throws RemoteException, MareException;

    Long obtenerAlmacen(Long oidPais) throws RemoteException, MareException;

    Boolean hayStockSuficiente(Long pais, Long producto, Long almacen, Long unidadesDemandadas)
        throws RemoteException, MareException;
}