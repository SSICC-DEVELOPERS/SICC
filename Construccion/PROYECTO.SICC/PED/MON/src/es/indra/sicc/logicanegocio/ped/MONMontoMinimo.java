package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOMontoMinimo;
import es.indra.sicc.util.DTOSalida;

public interface MONMontoMinimo extends EJBObject  {

    void elimina(DTOOIDs dto) throws MareException, RemoteException;

    void guarda(DTOMontoMinimo dto) throws  RemoteException, MareException, RemoteException;

    DTOSalida consulta(DTOMontoMinimo dto) throws  RemoteException, MareException, RemoteException;

    DTOMontoMinimo consultaDetalles(DTOOID dto) throws  RemoteException, MareException, RemoteException;


}