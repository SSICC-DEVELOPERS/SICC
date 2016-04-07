package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.ejb.EJBLocalObject;

public interface MONSecuenciacionAPPLocal extends EJBLocalObject  {
    DTOSalidaBatch recepcionarSecuenciacionAPPBatch(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException;

}