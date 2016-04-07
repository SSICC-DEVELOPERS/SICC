package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;

public interface MONAsignacionesCobranza extends EJBObject 
{
  DTOSalida obtenerCriteriosOrdenacionTC(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida buscarAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws RemoteException, MareException;

  DTOOID obtenerSubTipoClienteIVR(DTOOID oid) throws MareException, RemoteException;

    DTOString obtenerTotalesAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws MareException, RemoteException;
}