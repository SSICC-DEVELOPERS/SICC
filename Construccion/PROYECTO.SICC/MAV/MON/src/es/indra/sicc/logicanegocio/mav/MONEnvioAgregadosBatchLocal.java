package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import es.indra.sicc.dtos.mav.DTODetalleMAV;

public interface MONEnvioAgregadosBatchLocal extends EJBLocalObject 
{
    DTOEstatusSolicitud  validarAgregados(DTOSolicitudValidacion dto) throws MareException;

    void insertarProductosMasivos(DTODetalleMAV[] detallesNoEncontrados, DTOSolicitudValidacion dto) throws MareException;
}