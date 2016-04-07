package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;

public interface MONBuzonLocal extends EJBLocalObject 
{
    void insertarCabeceraBuzon(DTOCabecera dtoe) throws MareException;

    void insertarDetalleBuzon(DTODetalle dtoe) throws MareException;

    DTOSalida obtenerCabeceraBuzon(DTOBusqueda dtoe) throws MareException;

    DTOSalida obtenerCabeceraBuzonCombo(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerCodBuzon(DTOBelcorp dtoe) throws MareException;

    DTOSalida obtenerDetalleBuzon(DTOBusqueda dtoe) throws MareException;

    DTOSalida obtenerContactosPorCliente(DTOCliente dtoe) throws MareException;

    DTOSalida obtenerGestiones(DTOBelcorp dtoe) throws MareException;

    Long obtenerNumeroSecuencialProximoDetalle(Long oidBuzon) throws MareException;

    void procesarActividad(DTODetalle dtoe) throws MareException;

    void redirigirActividad(DTORedirigirDetalle dtoe) throws MareException;
}