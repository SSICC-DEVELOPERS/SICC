package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialDAT;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

public interface MONINTDAT extends EJBObject  {

    DTOSalidaBatch enviarTiposCurso(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarGenericoDatamart(DTOINTCargaInicialDAT dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaClientes(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarEmpresas(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarFechaProceso(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarUnidadesGeograficas(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarUnidadesGeograficasCampania(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarInformacionGerentesRegionales(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarInformacionGerentesZona(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarInformacionLideres(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarHomologacionEstatusClientes(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTiposOferta(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaZonas(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarCapacitacionesClientes(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarCapacitacionGerentes(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarEstatusZona(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarProductosReemplazo(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTiemposCampania(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarSaldosCobranza(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarFechaCierreCampania(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarCampanias(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarMatrizCampania(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarBoletasDespacho(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarRegiones(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarSecciones(DTOBatch dtoBatch) throws  MareException, RemoteException;

    DTOSalidaBatch enviarZonasRealesPorRegion(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarAccesos(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarInformacionCampania(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarInformacionPedidosPorDia(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarEstatusClientes(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarTransaccionesCliente(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarResumenTxPorSeccion(DTOBatch dtoBatch) throws MareException, RemoteException;

   DTOSalidaBatch enviarResumenTxPorZona(DTOBatch dtoBatch) throws MareException, RemoteException;

   void enviarEstatusClientesPorCierreZona(DTOFACProcesoCierre dtoe) throws MareException, RemoteException;

    DTOSalidaBatch enviarHistoriaCambiosTerritorio(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalida obtenerInterfacesDAT(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalidaBatch enviarRegionesCerradas(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarMaestroHijasDuplas(DTOBatch dtoBatch) throws MareException, RemoteException;


}