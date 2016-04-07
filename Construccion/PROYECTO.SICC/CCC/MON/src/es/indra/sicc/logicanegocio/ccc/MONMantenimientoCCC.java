package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;

public interface MONMantenimientoCCC extends EJBObject  {
	RecordSet obtenerBancos(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerProcesosActivos(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenertipoCargoProcesos(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTipoCargoCCC004(DTOBelcorp dto) throws MareException, RemoteException;
}