package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOEstadisticasDigitacion;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;

public interface MONEstadisticasDigitacion extends EJBObject  {
	DTOOID guardarEstadisticas(DTOEstadisticasDigitacion DTOE) throws MareException, RemoteException;
}