package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.dtos.cob.DTOAccionCobranza;
import es.indra.sicc.util.DTOOID;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cob.DTOBuscarAccionesCobranza;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;

public interface MONAccionesCobranza extends EJBObject 
{
  DTOSalida buscarAccionesCobranza(DTOBuscarAccionesCobranza dto) throws RemoteException, MareException;

    DTOSalida obtenerAccionesCobranza(DTOBelcorp dto) throws MareException, RemoteException;

    DTOAccionCobranza obtenerAccionCobranza(DTOOID dtoE) throws RemoteException, MareException;
}