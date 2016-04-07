package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

public interface MONInformeFaltantes extends EJBObject  {
  DTOInformeFaltantes ejecuta(DTOEInformeFaltantes DTO) throws MareException, RemoteException;

  CNInformeFaltantes obtieneControl() throws MareException, RemoteException;

  DTOOID cargaValidarFaltantes(DTOBelcorp dto) throws MareException, RemoteException;
}