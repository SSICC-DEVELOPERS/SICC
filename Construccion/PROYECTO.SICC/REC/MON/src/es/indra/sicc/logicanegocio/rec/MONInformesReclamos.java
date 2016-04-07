package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

public interface MONInformesReclamos extends EJBObject 
{
    DTOConsultarCabeceraReclamo consultarCabeceraReclamo(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida consultarReclamosCliente(DTOOIDPaginado dtoe) throws MareException, RemoteException;

    DTOSalida consultarDetalleReclamo(DTOOIDPaginado dtoe) throws RemoteException, MareException;
}