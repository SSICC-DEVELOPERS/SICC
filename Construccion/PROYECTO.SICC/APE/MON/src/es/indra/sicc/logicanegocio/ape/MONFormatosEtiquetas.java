package es.indra.sicc.logicanegocio.ape;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosEtiqueta;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;

public interface MONFormatosEtiquetas extends EJBObject {
    void insertarFormatosEtiquetas(DTODatosEtiqueta dtoe) throws MareException, RemoteException;
    DTOSalida consultarFormatosEtiquetas(DTODatosEtiqueta dtoe) throws MareException, RemoteException;
    void eliminar(DTOOIDs dtoe) throws MareException, RemoteException;

  DTOSalida obtenerProgramasEtiquetas(DTOBelcorp dtoe) throws RemoteException, MareException;
}