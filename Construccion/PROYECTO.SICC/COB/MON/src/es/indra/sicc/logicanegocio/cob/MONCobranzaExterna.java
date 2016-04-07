package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cob.DTOCriteriosBusquedaLiquidacionCom;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOSimulacionLiquidacion;
import es.indra.sicc.dtos.cob.DTOSimulacionComisiones;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOUsuariosYGruposCOB;

public interface MONCobranzaExterna extends EJBObject 
{
  DTOSalida listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada) throws MareException, RemoteException;

  DTOSimulacionLiquidacion simulacionLiquidacion(DTOSimulacionLiquidacion dto) throws MareException, RemoteException;

  Float calcularPorcentajeDeudaCancelada(DTOSimulacionComisiones dto) throws MareException, RemoteException;

  BigDecimal calcularImporteDeudaAsignadaEtapaAnterior(DTOSimulacionComisiones dto) throws MareException, RemoteException;

  Long obtenerEtapaAnterior(Long etapa) throws MareException, RemoteException;

    DTOUsuariosYGruposCOB cargarUsuariosYGruposCOB(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerGruposUsuariosCOB(DTOBelcorp dto) throws MareException, RemoteException;
}