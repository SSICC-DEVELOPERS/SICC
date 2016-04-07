package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONCambiosVentas extends EJBObject 
{
  DTOSalida cambiosVentas(es.indra.sicc.dtos.bel.DTOCambiosVentas dtoe) throws MareException, RemoteException;
}