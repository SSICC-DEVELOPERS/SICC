package es.indra.sicc.logicanegocio.seg;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.seg.ParametrosClaveDTO;
/*import es.indra.sicc.dtos.seg.ConsultaParametrizacionClaveSDTO;
import es.indra.sicc.dtos.seg.ParametrizacionClaveEDTO;
import es.indra.sicc.dtos.seg.ParametrizacionClaveSDTO;*/

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONMantenimientoParametrosClave extends EJBObject 
{
  ParametrosClaveDTO consulta() throws MareException, RemoteException;

  void modifica(ParametrosClaveDTO dtoe) throws MareException, RemoteException;
}