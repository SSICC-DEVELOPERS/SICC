package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public interface ExtensionCARLocal extends EJBLocalObject 
{
    void validarInsertarParamCalculoLC(MareDTO datos) throws MareException;

    void validarInsertarSolapamientoCodEvaluacion(MareDTO datos) throws MareException;

    void validarInsertarSolapamientoParamNR(MareDTO datos) throws MareException;

    void validarModParamCalculoLC(MareDTO datos) throws MareException;

    void validarModSolapamientoCodEvaluacion(MareDTO datos) throws MareException;

    void validarModSolapamientoParamNR(MareDTO datos) throws MareException;
}