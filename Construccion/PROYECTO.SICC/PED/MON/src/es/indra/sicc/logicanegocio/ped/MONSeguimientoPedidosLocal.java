package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos;
import es.indra.sicc.util.DTOSalida;
import java.util.Date;
import es.indra.sicc.util.DTOBelcorp;

public interface MONSeguimientoPedidosLocal extends EJBLocalObject 
{
    void actualizarSeguimientoPedidos(DTOSeguimientoPedidos dto) throws MareException;

    void actualizarConsolidado(Long consolidado) throws MareException;

    DTOSalida buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos dto) throws MareException;

    void eliminarHitosPosteriores(DTOSeguimientoPedidos DTOE) throws MareException;

    void guardarSeguimientoPedidos(Long solicitud, Long consolidado, Long hitoSeguimiento, Long tipoDocumento, String numeroDocumento, Date fecha, Boolean indCompleto) throws MareException;

    DTOSalida obtenerHitosSeguimiento(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerTiposDocumentoSeguimiento(DTOBelcorp dto) throws MareException;
}