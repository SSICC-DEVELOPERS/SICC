package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.inc.DTOBusquedaFaltantes;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;

public interface MONBolsaFaltantesLocal extends EJBLocalObject 
{
    DTOSalida buscarPremiosFaltantes(DTOBusquedaFaltantes dtoEnt) throws MareException;

    void guardarAsignacionFaltantes(DTOPremioSustitutivo dtosus) throws MareException;

    ArrayList obtenerProductosConStock(DTOPremioSustitutivo dtoSus, Faltante faltante) throws MareException;

    DTOSalida obtenerSituacionRegistro(DTOBelcorp dtoe) throws MareException;

    DTOSalida obtenerTipoCambio(DTOBelcorp DTOE) throws MareException;

    DTOEstatusSolicitud procesarBolsaFaltantes(DTOSolicitudValidacion dtoSolicitud) throws MareException;

    void procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe) throws MareException;

    DTOSalida recuperarCodConcursos(DTOBelcorp dto) throws MareException;
}