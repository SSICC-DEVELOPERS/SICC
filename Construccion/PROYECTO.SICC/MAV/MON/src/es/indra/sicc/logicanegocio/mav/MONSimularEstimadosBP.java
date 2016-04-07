package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.mav.DTOCampaniaEstimadosBP;
import es.indra.sicc.dtos.mav.DTODetalleCampaniaEstimadosBP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONSimularEstimadosBP extends EJBObject {
    DTOSalida cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto)
        throws RemoteException, MareException;

    DTOSalida cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto)
        throws RemoteException, MareException;

    DTODetalleCampaniaEstimadosBP cargarFormularioRecalculo(DTOOID dto)
        throws RemoteException, MareException;

    DTODetalleCampaniaEstimadosBP recalcularDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto)
        throws RemoteException, MareException;

    Long consultarUnidadesDisponibles(Long pais, Long producto)
        throws RemoteException, MareException;

    void actualizarDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto) 
        throws MareException, RemoteException;
}