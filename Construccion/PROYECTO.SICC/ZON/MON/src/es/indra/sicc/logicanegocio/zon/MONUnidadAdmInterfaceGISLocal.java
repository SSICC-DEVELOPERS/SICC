package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;

public interface MONUnidadAdmInterfaceGISLocal extends EJBLocalObject 
{
  void procesar(Long idProc, String filePath, String typeProc, String filename) throws MareException;
}