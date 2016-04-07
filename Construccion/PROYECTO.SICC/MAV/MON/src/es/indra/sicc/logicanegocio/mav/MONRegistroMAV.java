package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOAgrupacionEnvios;
import es.indra.sicc.dtos.mav.DTOCargaPaginaRegistrosMAV;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOECBRegistrosMAV;
import es.indra.sicc.dtos.mav.DTOLineaCombo;
import es.indra.sicc.dtos.mav.DTOProcesoDetalleMAV;
import es.indra.sicc.dtos.mav.DTORegistrosMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONRegistroMAV extends EJBObject {
    DTOSalida buscarEnviosMAVATC(DTOECBRegistrosMAV dto) throws RemoteException, MareException;

    DTOSalida buscarEnviosMAVATD(DTOECBRegistrosMAV dto) throws RemoteException, MareException;

    DTOSalida buscarEnviosMAVProductos(DTOECBRegistrosMAV dto)
        throws RemoteException, MareException;

    DTOSalida detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto)
        throws RemoteException, MareException;

    void guardarRegistrosMAV(DTORegistrosMAV dto) throws RemoteException, MareException;

    void generarInformacionMAV(MareDTO dto) throws RemoteException, MareException;

    void generarEnvioMAV(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio)
        throws RemoteException, MareException;

    DTOCargaPaginaRegistrosMAV cargaPaginaRegistrosMAV(DTOBelcorp dto)
        throws RemoteException, MareException;

    DTOProcesoDetalleMAV procesarLineaDetalleMAV(DTODetalleMAV dto, Long peirodo, Long actividad, Boolean simulacion)
        throws RemoteException, MareException;

    Boolean validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion)
        throws RemoteException, MareException;

    Boolean validarVinculosEnvioMAV(Long oid) throws RemoteException, MareException;

    DTOLineaCombo recuperarTipoClienteActividad(DTOOID dto)
        throws RemoteException, MareException;

  DTODetalleMAV comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo) throws RemoteException, MareException;
}