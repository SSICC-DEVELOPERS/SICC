package es.indra.sicc.cmn.negocio.busqueda;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBusquedaGenerica;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;

public interface MONBusquedaGenerica extends EJBObject 
{
  DTOSalida RealizarBusqueda(DTOBusquedaGenerica dto) throws MareException, RemoteException;
}