package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import java.util.ArrayList;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.dto.DTOSimulacionDescuento;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.dto.DTOSolicitudDescuento;

public interface MONCalcularDTOLocal extends EJBLocalObject 
{
    DTOSBaseAplicacion buscarBaseAplicacionMasEspecifica(DTOSolicitudPosicionDescuento posicion, ArrayList basesAplicables) throws MareException;

    DTOSimulacionDescuento simularDescuentos(DTOSimulacionDescuento dto) throws MareException;

    DTOSolicitudDescuento validarDescuentos(DTOSolicitudValidacion dto) throws MareException;
}