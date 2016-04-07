package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.ArrayList;

public interface MONGenerarPosicionSolicitudLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado) throws MareException;

    DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta) throws MareException;

    DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dtoSolicitudCabecera, HashMap hashCodigoVenta) throws MareException;
    
    DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dto) throws MareException;

    ArrayList generarPosicionesCuadre(DTOCabeceraSolicitud dto, ArrayList posiciones) throws MareException;
}