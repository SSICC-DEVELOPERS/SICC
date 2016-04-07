package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;

public interface MONPremiacionLocal extends EJBLocalObject 
{
    void despacharPremios(ClientePremiacion clientePremiacion) throws MareException;

    void determinarGanadorasRecomendacionConsultora(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente) throws MareException;

    DTOOIDs obtenerConcursosRecomendadosOIDs(ArrayList clientesRecomendadosGerencia) throws MareException;

    void premiarGerentes(DTOFACProcesoCierre dtoe) throws MareException;

    void premiarPorCierreZona(DTOFACProcesoCierre dtoFac) throws MareException;

    DTOEstatusSolicitud premiarPorSolicitud(DTOSolicitudValidacion solicitud) throws MareException;

    void premiarRecomendacionGerente(Long oidPais, Long oidPeriodo, Long subacceso) throws MareException;

    DTOEstatusSolicitud revertirPremiacion(DTOSolicitudValidacion solicitudValidacion) throws MareException;

    void tranformarPuntosAPremios(ClientePremiacion clientePremiacion, ArrayList concursos) throws MareException;

  ArrayList determinarGanadorasRecomendacionConsultoraCalculo(Long pais, Periodo periodo, Long cliente) throws MareException;

    void premiarPorCierrePeriodo(DTOFACProcesoCierre dtoFac) throws MareException;

    DTOEstatusSolicitud determinarGanadorasRecomendacionConsultoraMonitor(DTOSolicitudValidacion solicitud) throws MareException;

    void determinarGanadorasRecomendacionConsultoraCierreZona(DTOFACProcesoCierre dtoin) throws MareException;


}