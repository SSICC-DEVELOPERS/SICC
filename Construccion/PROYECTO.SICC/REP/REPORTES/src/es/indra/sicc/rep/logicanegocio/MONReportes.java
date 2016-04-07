package es.indra.sicc.rep.logicanegocio;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.rep.dtos.DTOPeriodoCorporativos;
import es.indra.sicc.rep.dtos.DTOCriteriosReportes;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.dtos.DTOValidaCodigoVenta;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;


import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.rep.dtos.DTOBusquedaRapidaProductos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.rep.dtos.DTOEstructuraFacturacion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.rep.dtos.DTORecargaComisiones;

public interface MONReportes extends EJBObject 
{
  DTOString lanzarBatch(DTOReporte dtoin) throws RemoteException, MareException;

  DTOReporte verReporte(DTOString codRep) throws RemoteException, MareException;

  DTOSalida consultarEstados(DTOCriteriosReportes dtoin) throws MareException, RemoteException;

    DTOBoolean validaCodigoVenta(DTOValidaCodigoVenta dto) throws MareException, RemoteException;

    DTOSalida obtenerPeriodosCorporativos(DTOPeriodoCorporativos dto) throws MareException, RemoteException;

    DTOSalida obtenerZonasParaListaOculta(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida busquedaRapidaProductos(DTOBusquedaRapidaProductos dto) throws MareException, RemoteException;

    DTOSalida periodosCronogramaTotalGrupo(DTOPeriodo dto) throws MareException, RemoteException;

    DTOSalida obtenerModulos(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerMarcaProducto(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerPeriodosEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException, RemoteException;

    DTOSalida obtenerZonasEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException, RemoteException;

    DTOSalida obtener5PeriodosPosteriores(DTOPeriodo dto) throws RemoteException, MareException;

    DTOSalida obtenerOperacionesSinAnulaciones(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerConsursosMarcas(DTOString dto) throws MareException, RemoteException;

  DTOSalida obtenerPeriodosConcurso(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtener4PeriodosPosteriores(DTOOID dto) throws MareException, RemoteException;

  DTOSalida recargaComisiones(DTORecargaComisiones dto) throws MareException, RemoteException;

  DTOSalida obtenerMoneda(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida cargarPeriodosREP(DTOPeriodo dto) throws MareException, RemoteException;

  DTOSalida recargarRegionesRep(DTOString dto) throws MareException, RemoteException;

  DTOSalida recargarZonasRep(DTOString dto) throws MareException, RemoteException;

  DTOSalida recargarSeccionesRep(DTOString dto) throws MareException, RemoteException;

  DTOSalida recargarTerritoriosRep(DTOString dto) throws MareException, RemoteException;

  DTOSalida recargarTerritoriosSeccionesRep(DTOString dto) throws MareException, RemoteException;

  DTOSalida recargarNivelesConcursos(DTOString dto) throws MareException, RemoteException;

    DTOSalida recargaNumerosDescuentosRep(DTOString dto) throws MareException, RemoteException;

    DTOSalida recargaTipoSolicitudPorClaseRep(DTOString dto) throws MareException, RemoteException;

    DTOSalida recargarRegionesParaListaCanalRep(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

    DTOSalida recargarGerentesRegionRep(DTOString dto) throws MareException, RemoteException;

}