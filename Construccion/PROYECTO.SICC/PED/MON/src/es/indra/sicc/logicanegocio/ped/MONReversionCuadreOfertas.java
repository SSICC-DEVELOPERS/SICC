package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONReversionCuadreOfertas extends EJBObject  {
    DTOEstatusSolicitud revertirCuadreOfertas(DTOSolicitudValidacion dtoe) throws RemoteException, MareException;
}