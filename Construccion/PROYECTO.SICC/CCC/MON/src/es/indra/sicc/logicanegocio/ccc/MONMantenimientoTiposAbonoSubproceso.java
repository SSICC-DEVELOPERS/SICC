package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarTiposAbonoSubproceso;
import es.indra.sicc.dtos.ccc.DTOMantenimientoTiposAbonoSubproceso;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOBoolean;

public interface MONMantenimientoTiposAbonoSubproceso extends EJBObject 
{
 void insertarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto) throws MareException, RemoteException;

 DTOBoolean eliminarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto) throws RemoteException, MareException;
 
 RecordSet obtenerTiposAbono(DTOBelcorp dto) throws MareException, RemoteException;
 
 RecordSet obtenerCuentasContables(DTOBelcorp dto) throws MareException, RemoteException;
 
 DTOSalida buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto) throws MareException, RemoteException;

}