package es.indra.sicc.rep.logicanegocio;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.rep.dtos.DTOCriteriosReportes;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.dtos.DTOReportID;
import es.indra.mare.common.exception.MareException;

public interface MONFrontReport extends EJBObject 
{
  DTOSalida buscarReportes(DTOCriteriosReportes dtoin) throws MareException, RemoteException;

  DTOReporte getReporte(DTOOID dtoin) throws MareException, RemoteException;

  DTOReportID startReport(DTOReporte dtoin) throws MareException, RemoteException;
}