package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;

public interface MONZONLogLocal extends EJBLocalObject 
{
  public static final int CANT_CARACTERES_MENSAJE_ERROR = 512;
  
  void agregarDetalle(Long oid, String typeProc, String mensaje, Object datos) throws MareException;

  Long crearLogProceso(String valTipoProc) throws MareException;

  DTOManagerFileResult obtenerResultado(Long oId, String typProc) throws MareException;

  void reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje) throws MareException;
}