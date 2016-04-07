package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.sicc.util.UtilidadesEJB;

public interface MONImpresionMensajesHome extends EJBHome  {
	MONImpresionMensajes create() throws RemoteException, CreateException;
}