package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONMantenimientoFactoresConversion extends EJBObject  {
  void actualizarFactoresConversion(DTOFactoresConversion dtoe) throws MareException, RemoteException;

  DTOSalida buscarFactoresConversion(DTOFactoresConversion dtoe) throws MareException, RemoteException;

  void eliminarFactoresConversion(DTOOIDs dtoe) throws MareException, RemoteException;

  DTOSalida obtenerMagnitudes(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida otenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe) throws RemoteException, MareException;
}