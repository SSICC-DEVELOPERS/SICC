package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTOEstadoMAV;
import es.indra.sicc.util.DTOOIDs;

public interface MONMantenimientoEstadosMAVLocal extends EJBLocalObject 
{
    DTOSalida buscarEstados(DTOEBuscarEstadosMAV dto) throws MareException;

    DTOEstadoMAV consultarEstado(DTOOID dto) throws MareException;

    void eliminarEstados(DTOOIDs dto) throws MareException;

    void guardarEstados(DTOEstadoMAV dto) throws MareException;
}