package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.mare.common.exception.MareException;

import java.util.ArrayList;

public interface MONProcesosPED extends EJBObject  {
  String generaNumeroDocumento(DTONumeroSolicitud dto) throws RemoteException, MareException;

  String generaSecuenciaDocumento(DTONumeroSolicitud dto) throws RemoteException, MareException;

    String ejecutarFuncionNumeroSolicitud(ArrayList arrayParametros) throws MareException, 
                                                                            RemoteException;
}
