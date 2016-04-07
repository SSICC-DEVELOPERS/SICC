package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import java.util.HashMap;


public interface MONGenerarPosicionSolicitud extends EJBObject  {

  DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado) throws RemoteException, MareException;

  DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta) throws RemoteException, MareException;

  DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dtoSolicitudCabecera, HashMap hashCodigoVenta) throws MareException, RemoteException;

  DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dto) throws MareException, RemoteException;

}