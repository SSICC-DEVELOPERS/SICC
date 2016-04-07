package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOConcurso;

public interface MONCalcularMetasLocal extends EJBLocalObject 
{
    DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException;

    void calcularMetasTipoVentaConsultorasPerf(DTOConcurso DTOE, String idProc) throws MareException;
}