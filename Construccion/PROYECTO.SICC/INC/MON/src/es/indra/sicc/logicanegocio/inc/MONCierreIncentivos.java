package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONCierreIncentivos
        extends EJBObject {
    void cerrarIncentivos(DTOFACProcesoCierre dtoin) throws MareException, RemoteException;

  DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException, RemoteException;

    void actualizarResumenPedidos(DTOFACProcesoCierre dtoe) throws MareException, 
                                                                   RemoteException;

    void actualizarPedidosIncentivo(DTOFACProcesoCierre dtoe) throws MareException, 
                                                                     RemoteException;
}
