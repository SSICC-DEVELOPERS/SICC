package es.indra.sicc.logicanegocio.ped;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOColeccion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ped.DTOValoresPorDefecto;
import es.indra.sicc.util.DTOOIDs;

public interface MONValoresPorDefecto extends EJBObject  {
    void guarda(DTOColeccion dto) throws RemoteException, MareException;
    DTOSalida consulta(DTOValoresPorDefecto dto) throws RemoteException, MareException;
    void eliminar(DTOOIDs dto) throws RemoteException, MareException;
    void modifica(DTOColeccion dto) throws RemoteException, MareException;
}