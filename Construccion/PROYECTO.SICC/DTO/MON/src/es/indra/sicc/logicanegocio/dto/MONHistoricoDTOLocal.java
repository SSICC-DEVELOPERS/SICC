package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.dto.DTOEBuscarClientesDTO;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTOEBuscarDetalleSolicitudDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarSolicitudesClienteDTO;
import java.util.ArrayList;

public interface MONHistoricoDTOLocal extends EJBLocalObject 
{
    void borrarHistoricoSolicitud(DTOOID dto) throws MareException;

    DTOSalida buscarClientesDTO(DTOEBuscarClientesDTO dto) throws MareException;

    DTOSalida buscarDetalleSolicitudDTO(DTOEBuscarDetalleSolicitudDTO dto) throws MareException;

    DTOSalida buscarSolicitudesPorClienteDTO(DTOEBuscarSolicitudesClienteDTO dto) throws MareException;

    void generarHistoricoDescuentos(ArrayList historicosDescuentos, Long oidPais, Long oidSolicitud) throws MareException;
}