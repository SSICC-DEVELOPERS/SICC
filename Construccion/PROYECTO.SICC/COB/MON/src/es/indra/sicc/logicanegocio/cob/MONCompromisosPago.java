package es.indra.sicc.logicanegocio.cob;

import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;

public interface MONCompromisosPago extends EJBObject 
{
    DTOSalida buscarCompromisosPago(DTOEBuscarCompromisosPago dto) throws MareException, RemoteException;
}