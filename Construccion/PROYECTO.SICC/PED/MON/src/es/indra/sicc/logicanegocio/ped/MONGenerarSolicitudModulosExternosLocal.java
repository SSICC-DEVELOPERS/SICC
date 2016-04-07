package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import java.util.Vector;

public interface MONGenerarSolicitudModulosExternosLocal extends EJBLocalObject 
{
    DTOOID generaSolicitud(DTOCabeceraSolicitud dto) throws MareException;

    Vector generarPosiciones(Vector dtosCabecera) throws MareException;

    Vector generarSolicitudes(Vector dtosCabecera) throws MareException;
}