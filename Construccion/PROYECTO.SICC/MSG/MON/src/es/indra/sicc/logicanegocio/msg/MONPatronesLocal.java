package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.msg.DTOInicioFin;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.util.DTOBelcorp;

public interface MONPatronesLocal extends EJBLocalObject 
{
    DTOPatron actualizarPatron(DTOPatron DTOE) throws MareException;

    DTOSalida buscarPatrones(DTOPatron DTOE) throws MareException;

    DTOPatron copiarPatron(DTOPatron DTOE) throws MareException;

    void desplazarSeccionesAbajo(DTOInicioFin DTOE) throws MareException;

    void desplazarSeccionesArriba(DTOInicioFin DTOE) throws MareException;

    void eliminarMensajesSeccion(DTOOID DTOE) throws MareException;

    void eliminarPatron(DTOOIDs DTOE) throws MareException;

    void eliminarSeccion(DTOOID DTOE) throws MareException;

    Boolean esPatronOrigen(Long oidPatron) throws MareException;

    void guardarMensaje(Long oidPatronSeccion, DTOMensajeSeccion DTOE) throws MareException;

    DTOPatron guardarPatron(DTOPatron DTOE) throws MareException;

    DTOOID guardarSeccion(DTOSeccion DTOE) throws MareException;

    void insertarSeccion(DTOSeccion DTOE) throws MareException;

    void modificarSeccion(DTOSeccion DTOE) throws MareException;

    DTOPatron obtenerDetallePatron(DTOOID DTOE) throws MareException;

    DTOSalida obtenerFormularios(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerMediosEnvioPorPais(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerMetacaracterEstructura(DTOBelcorp DTOE) throws MareException;

    DTOPatron obtenerPatron(DTOOID DTOE) throws MareException;

    DTOSalida obtenerPatronesOrigen(DTOBelcorp DTOE) throws MareException;

    DTOSeccion obtenerSeccion(DTOOID DTOE) throws MareException;

    DTOSalida obtenerSecciones(DTOOID DTOE) throws MareException;

    DTOSalida obtenerTodosPatrones(DTOBelcorp DTOE) throws MareException;
}