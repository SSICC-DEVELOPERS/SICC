package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.mae.DTODataCodigoAnterior;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;

public interface MONCodigosAnteriores extends EJBObject 
{
  DTOSalida buscarCodigoAnterior(DTODataCodigoAnterior dto) throws RemoteException, MareException;

  void eliminarCodigosAnteriores(DTOOIDs dto) throws RemoteException, MareException;

  void guardarCodigoAnterior(DTODataCodigoAnterior dto) throws RemoteException, MareException;
}