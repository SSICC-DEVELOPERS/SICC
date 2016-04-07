package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOBuscarCargaBP;
import es.indra.sicc.dtos.mav.DTOCargaBP;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.cra.DTOPeriodo;


public interface MONBusinessPlanning extends EJBObject {
    DTOSalida obtieneDetallesMAV(DTODetalleMAV dto) throws RemoteException, MareException;

    DTODetalleMAV obtieneDetalleMAV(DTOOID dto) throws RemoteException, MareException;

    void cargaTextosDetalle(DTODetalleMAV dto) throws RemoteException, MareException;

    DTOSProductoValidado actualizaDetalleMAV(DTODetalleMAV dto)
        throws RemoteException, MareException;

    DTOSProductoValidado validaProducto(DTODetalleMAV dto) throws RemoteException, MareException;

    DTOCargaBP cargaPaginaBP(DTOBuscarCargaBP dto) throws RemoteException, MareException;

  DTOSalida obtenerPeriodosRangoAnual(DTOPeriodo dtoPeriodo) throws RemoteException, MareException;

    void desactivaDetalleMAV(DTOOID dto) throws MareException, RemoteException;

    DTOSalida descProducto(DTODetalleMAV dtoe) throws MareException, 
                                                      RemoteException;
}
