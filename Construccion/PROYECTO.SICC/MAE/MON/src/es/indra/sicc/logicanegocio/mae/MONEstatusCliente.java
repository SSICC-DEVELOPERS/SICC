package es.indra.sicc.logicanegocio.mae;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;



import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import javax.ejb.FinderException;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mae.DTOCierreRegion;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import java.util.ArrayList;
import es.indra.sicc.dtos.cra.DTOPeriodo;



public interface MONEstatusCliente extends EJBObject {
    String asignarEstatusInicial(ClienteDatosAdicionalesLocal clienteDatosAdicionalesLocal, Long periodoActual, ArrayList tiposClientes, DTOAuditableSICC dtoAudi) throws RemoteException, MareException;

    void TestEstatusInicial(Long cliente, Long perio, ArrayList tiposClientes)
        throws FinderException, MareException, RemoteException;

  DTOSalida obtenerPosiblesEstatusCliente(DTOBelcorp dto) throws MareException, RemoteException;

    void comprobarEstadoCliente(Long cliente) throws MareException, RemoteException;
	 void evaluarIndicadorActivo(DTOCierreRegion dtoCierre) throws RemoteException, MareException;

    void asignarEstatusLotes(DTOCierreRegion dtoCierre, String IDProc) throws RemoteException, MareException;

  void lanzarEvaluarIndicadorActivo(DTOFACProcesoCierre dto) throws RemoteException, MareException;

  void lanzarActualizacionEstatusClientes(DTOFACProcesoCierre dto) throws RemoteException, MareException, InterruptedException ;

  void actualizarEstatusRangoClientes(DTOBatch dtoBatch) throws RemoteException, MareException;

  void reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe) throws MareException, RemoteException;

  DTOSalidaBatch reasignarEstatusEnLotesBatch(DTOBatch dtoBatch) throws MareException, RemoteException;

  DTOSalida obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe) throws RemoteException, MareException;


	
}

