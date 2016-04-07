package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.dtos.com.DTOBusquedaAccesosPlantilla;
import es.indra.sicc.dtos.com.DTOBusquedaPlantillas;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.com.DTOPlantillaDetalle;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public interface MONPlantillasCom extends EJBObject 
{
  DTOSalida obtenerTipoComision(DTOBelcorp dtoe) throws RemoteException, MareException;

  DTOSalida obtenerPlantillasCom(DTOSiccPaginacion dtoe) throws RemoteException, MareException;

  DTOSalida obtenerEstadoPlantilla(DTOBelcorp dtoe) throws RemoteException, MareException;

  void eliminarPlantillasCom(DTOOIDs dtoe) throws RemoteException, MareException;

  Boolean comprobarEstadoComision(Long oid) throws RemoteException, MareException;

    DTOPlantillaDetalle obtenerDetallePlantilla(DTOOID dtoe) throws MareException, RemoteException;

    void insertarPlantillaCom(DTOPlantillaDetalle dtoe) throws MareException, RemoteException;


    DTOSalida obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe) throws MareException, RemoteException;

    DTOPlantillaDetalle copiarPlantillaCom(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe) throws MareException, RemoteException;
}