package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.mare.common.exception.MareException;

public interface MONValidarCreditosLocal extends EJBLocalObject 
{
    Long reversionLineaCredito(DTOSolicitudValidacion dtoin) throws MareException;

    Long validarLineaCredito(DTOSolicitudValidacion dtoin) throws MareException;
}