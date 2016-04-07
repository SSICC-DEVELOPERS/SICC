package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONProcesoEnvioAgregadosSolicitud extends EJBObject {
    DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;



}