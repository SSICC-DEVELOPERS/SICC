package es.indra.sicc.logicanegocio.car;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import java.math.BigDecimal;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import javax.mail.internet.AddressException;
import es.indra.sicc.dtos.car.DTONotificar;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.car.DTOCreditoRiesgo;
import es.indra.sicc.dtos.car.DTOReevaluar;
import es.indra.sicc.dtos.car.DTOTipoReevaluacion;
import es.indra.sicc.dtos.car.DTOReevaluarEnMasa;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONCreditoRiesgoLocal extends EJBLocalObject 
{
    BigDecimal calcularPedidoPromedioUltimaEvaluacion(DTOCalculoPedidos dto) throws MareException;

    Integer calcularPeriodosPedidoUltimaEvaluacion(DTOCalculoPedidos dto) throws MareException;

    DTOSalida cargaOrdenesNotificar(DTOBelcorp dto) throws MareException;

    void enviarMail(String asunto, String mensaje, String direccion) throws MareException, AddressException;

    void enviarMensajeLC(Long pais, Long oidCliente, BigDecimal montoIni, BigDecimal montoFin) throws MareException;

    void marcaNotificacion(Long oid) throws MareException;

    void notificarMail(DTONotificar dto) throws MareException;

    void notificarTfnoFax(DTOOIDs dto) throws MareException;

    DTOCreditoRiesgo obtenerCreditoRiesgoConsultoraNueva(Long pais, Long territorioAdministrativo) throws MareException;

    DTOSalida obtieneTipoReevaluacion(DTOBelcorp dto) throws MareException;

    void reasignarLineasCredito(DTOReevaluar dto) throws MareException;

    BigDecimal redondear(Long pais, BigDecimal cantidad) throws MareException;

    void reevaluarCreditoRiesgoIndividual(DTOTipoReevaluacion dto) throws MareException;

    void reevaluarEnMasa(DTOReevaluarEnMasa dto) throws MareException;

    void reevaluarLineaCreditoMasaOffLine(DTOFACProcesoCierre dto) throws MareException;

    void reevaluarNivelRiesgo(DTOReevaluar dto) throws MareException;

    void reevaluarNivelRiesgoMasaOffLine(DTOFACProcesoCierre dto) throws MareException;

    DTOSalidaBatch reevaluarEnMasaPerf(DTOBatch dtoin) throws MareException;
}