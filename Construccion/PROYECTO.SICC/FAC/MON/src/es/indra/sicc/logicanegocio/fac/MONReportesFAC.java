package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.fac.DTOFACReporte;

public interface MONReportesFAC extends EJBObject 
{
  void validarSegmentoZona(DTOFACReporte dtoe) throws MareException, RemoteException;

  void generarNivelesSegmentoConsultora(DTOFACReporte dtoe) throws MareException, RemoteException;

  void eliminarRegistrosSegmentosZonasClientes(DTOFACReporte dtoe) throws MareException, RemoteException;
}