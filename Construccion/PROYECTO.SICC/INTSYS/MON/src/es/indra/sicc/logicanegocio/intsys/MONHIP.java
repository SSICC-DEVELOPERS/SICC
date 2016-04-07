package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import es.indra.sicc.dtos.intsys.DTOHIPRecepcionar;

import es.indra.mare.common.exception.MareException;

public interface MONHIP extends EJBObject 
{
  DTOSalidaBatch recepcionaRegistroVentasBatch(DTOHIPRecepcionar DTOE) throws MareException, RemoteException;

  DTOSalidaBatch recepcionarRegistroVentas(DTOBatch DTOE) throws MareException, RemoteException;
}