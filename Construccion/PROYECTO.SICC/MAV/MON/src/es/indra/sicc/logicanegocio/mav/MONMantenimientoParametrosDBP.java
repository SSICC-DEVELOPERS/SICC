package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.mav.DTOParametroDBP;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;

public interface MONMantenimientoParametrosDBP extends EJBObject  {
    DTOValoresDefectoDatosBP obtenerValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws RemoteException, MareException;

    void guardarValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws RemoteException, MareException;



}