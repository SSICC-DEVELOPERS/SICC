package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.intsys.DTOOCRCadenasInsercionSolicitudes;
import java.util.HashMap;

public interface MONOCRLocal extends EJBLocalObject 
{
  DTOOCRCadenasInsercionSolicitudes cargarSolicitud(DTOCabeceraSolicitud dtoS) throws MareException;

  void ejecutarInsercionSolicitudes(StringBuffer cadenasInsercionSolicitudes) throws MareException;

  void insertarSolicitudesOnLine(HashMap hashOnLine) throws Exception;

    DTOCabeceraSolicitud generaNumeroSolicitudCabecera(DTOCabeceraSolicitud dtoCabecera) throws MareException;
}
