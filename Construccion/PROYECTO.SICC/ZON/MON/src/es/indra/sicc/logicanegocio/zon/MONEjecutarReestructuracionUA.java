package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.zon.DTOCodUA;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUA;
import es.indra.sicc.util.DTOString;

public interface MONEjecutarReestructuracionUA extends EJBObject  {
  DTOSalida recargaUAInferior(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

  DTOCodUA buscarCodUA(DTOCodUA dtoe) throws RemoteException, MareException;

  DTOString lanzarEjecutarReestructuracionUA(DTOEjecutarReestructuracionUA dtoe) throws RemoteException, MareException;
}