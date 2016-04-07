package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOString;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface MONMantenimientoMAE extends EJBObject  {
    DTOSalida recuperaTiposNSEPPorPais(Long oidPais, Long oidIdioma) throws RemoteException, MareException;

    DTOSalida obtenerFecha(DTOString dtoE) throws RemoteException, MareException;
}