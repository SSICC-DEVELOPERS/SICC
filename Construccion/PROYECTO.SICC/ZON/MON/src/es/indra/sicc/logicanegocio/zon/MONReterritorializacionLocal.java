package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOFicheroRezonificacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import java.util.HashMap;
import java.util.ArrayList;

public interface MONReterritorializacionLocal extends EJBLocalObject 
{
  DTOFicheroRezonificacion lanzarReterritorializacion(DTOFicheroDisp infoFichero) throws MareException;

  void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws MareException;

  DTOSalidaBatch reterritorializacion(DTOBatch dtoBatch) throws MareException;

  void actualizarClientesUnidadesAdminyStatus(ArrayList clientes, Long pais, Long marca, Long canal, 
      Long periodoInicio, Long periodoFin, Long regionOrigen, Long regionDestino, Long territorioAdmOrigen, Long territorioAdmDestino) throws MareException;
}