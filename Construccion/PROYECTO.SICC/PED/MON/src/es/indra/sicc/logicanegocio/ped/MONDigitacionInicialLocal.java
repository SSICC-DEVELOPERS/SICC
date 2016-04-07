package es.indra.sicc.logicanegocio.ped;

import java.util.ArrayList;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.dto.DTOBuscarSolicitudesDTO;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.dtos.ped.DTOPeriodoDocumentoReferencia;

public interface MONDigitacionInicialLocal extends EJBLocalObject 
{
    DTOSalida buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe) throws MareException;

    DTOCabeceraSolicitud grabarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud guardarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOSalida obtenerAccesoFisico(DTOBelcorp DTOE) throws MareException;

    DTOPeriodoDocumentoReferencia obtenerPeriodoDocumentoReferencia(DTOOID dtoe) throws MareException;

    DTOSalida obtenerTipoDespacho(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTiposSolicitudDigitacionVD(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTiposSolicitudPaisNoConsolidados(DTOBelcorp dtoe) throws MareException;

    DTOValoresDefecto obtenerValoresDefecto(DTOValoresDefecto DTOE) throws MareException;

    String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException;
}
