package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOCargaParametrizacion;
import es.indra.sicc.dtos.mav.DTOParametrizacionMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONMantenimientoListas extends EJBObject {
    void cargarDatosDesdeBusinessPlanning(DTOBelcorp dto) throws RemoteException, MareException;

    DTOCargaParametrizacion cargarParametrizacion(DTOOID dto)
        throws RemoteException, MareException;

    void guardarParametrizacion(DTOParametrizacionMAV dto) throws RemoteException, MareException;
}