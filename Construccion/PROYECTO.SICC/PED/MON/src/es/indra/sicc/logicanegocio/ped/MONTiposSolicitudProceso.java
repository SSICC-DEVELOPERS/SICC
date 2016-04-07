package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;


public interface MONTiposSolicitudProceso extends EJBObject {
    void guarda(DTOTipoSolicitudProceso dto)
        throws MareException, RemoteException;

    DTOSalida consulta(DTOTipoSolicitudProceso dto)
        throws MareException, RemoteException;

    DTOTipoSolicitudProceso consultaDetalles(DTOOID dto)
        throws MareException, RemoteException;

    void elimina(DTOOIDs dto) throws RemoteException, MareException;

  DTOSalida obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto) throws RemoteException, MareException;
}
