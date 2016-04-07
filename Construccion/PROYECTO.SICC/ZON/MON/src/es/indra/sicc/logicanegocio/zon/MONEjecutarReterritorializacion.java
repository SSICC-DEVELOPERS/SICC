package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacion;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacionCab;

public interface MONEjecutarReterritorializacion extends EJBObject  {
  DTOSalida recuperarNivelesSocioEconomicosBelcorp() throws RemoteException, MareException;

  DTOSalida recargaConsultoras(DTOOID dtoe) throws RemoteException, MareException;

  void lanzarEjecutarReterritorializacion(DTOEjecutarReterritorializacion dtoe) throws RemoteException, MareException;


  DTOString buscarUAPadre(DTOOID dtoe) throws RemoteException, MareException;


}