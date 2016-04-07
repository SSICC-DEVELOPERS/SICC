package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import java.util.HashMap;

public interface MONReestructuracionPrimeraFaseLocal extends EJBLocalObject 
{
  DTOSalidaBatch rezonificar(DTOBatch dtoBatch) throws MareException;

  void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws MareException;
}