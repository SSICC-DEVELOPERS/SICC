package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.msg.DTOBuscarConsultoras;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOBuscarConsultorasInicial;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.msg.DTODatosConsultora;
import es.indra.sicc.util.DTOOID;

public interface MONConsultorasLocal extends EJBLocalObject 
{
    DTOSalida buscarListaConsultoras(DTOBuscarConsultoras DTOE) throws MareException;

    DTOSalida cargarListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE) throws MareException;

    DTOSalida consultarConsultoras(DTOBuscarConsultoras DTOE) throws MareException;

    void eliminarDatosConsultora(DTOOIDs DTOE) throws MareException;

    void insertarDatosConsultora(DTODatosConsultora DTOE) throws MareException;

    void modificarDatosConsultora(DTODatosConsultora DTOE) throws MareException;

    DTODatosConsultora obtenerDatosConsultora(DTOOID DTOE) throws MareException;
}