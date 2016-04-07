package es.indra.sicc.logicanegocio.car;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import es.indra.sicc.dtos.car.DTOReevaluar;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.car.DTOCreditoRiesgo;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.car.DTONotificar;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import java.math.BigDecimal;
import es.indra.sicc.dtos.car.DTOTipoReevaluacion;
import es.indra.sicc.dtos.car.DTOReevaluarEnMasa;
import javax.mail.internet.AddressException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONCreditoRiesgo extends EJBObject 
{
  DTOCreditoRiesgo obtenerCreditoRiesgoConsultoraNueva(Long pais, Long territorioAdministrativo) throws RemoteException, MareException;

    DTOSalida cargaOrdenesNotificar(DTOBelcorp dto) throws RemoteException, MareException;

    void notificarMail(DTONotificar dto) throws RemoteException, MareException;

    void marcaNotificacion(Long oid) throws RemoteException, MareException;

    void enviarMail(String asunto, String mensaje, String direccion) throws RemoteException, MareException, AddressException;

  void reevaluarNivelRiesgoMasaOffLine(DTOFACProcesoCierre dto) throws RemoteException, MareException;

  void reevaluarLineaCreditoMasaOffLine(DTOFACProcesoCierre dto) throws RemoteException, MareException;

  void reasignarLineasCredito(DTOReevaluar dto) throws RemoteException, MareException;

  BigDecimal calcularPedidoPromedioUltimaEvaluacion(DTOCalculoPedidos dto) throws RemoteException, MareException;

  BigDecimal redondear(Long pais, BigDecimal cantidad) throws RemoteException, MareException;

  void enviarMensajeLC(Long pais, Long oidCliente, BigDecimal montoIni, BigDecimal montoFin) throws RemoteException, MareException;

    void notificarTfnoFax(DTOOIDs dto) throws RemoteException, MareException;

  void reevaluarCreditoRiesgoIndividual(DTOTipoReevaluacion dto) throws RemoteException, MareException;

  DTOSalida obtieneTipoReevaluacion(DTOBelcorp dto) throws RemoteException, MareException;

  void reevaluarNivelRiesgo(DTOReevaluar dto) throws RemoteException, MareException;

  Integer calcularPeriodosPedidoUltimaEvaluacion(DTOCalculoPedidos dto) throws RemoteException, MareException;

  void reevaluarEnMasa(DTOReevaluarEnMasa dto) throws RemoteException, MareException;

    DTOSalidaBatch reevaluarEnMasaPerf(DTOBatch dtoin) throws RemoteException, MareException;


}