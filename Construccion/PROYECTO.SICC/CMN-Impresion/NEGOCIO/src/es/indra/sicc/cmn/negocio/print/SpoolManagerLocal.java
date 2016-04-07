package es.indra.sicc.cmn.negocio.print;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.mare.common.exception.MareException;

public interface SpoolManagerLocal extends EJBLocalObject 
{
    Long addPrintableDocuments(DTODocumento dtoDocumento, Long idSpool) throws MareException;

    void closeSpool(Long idSpool) throws MareException;

    void nextActivate(Long idSpool) throws MareException;

    Long openSpool(Long subacceso) throws MareException;

    void closeQueue(PrinterConfiguration pc) throws MareException;

    Long openSpoolEtiquetas(Long subacceso, Long impresoraEtiquetas) throws MareException;

    void closeSpoolEtiquetas(Long idSpool) throws MareException;

    void closeSpoolColombia(Long idSpool) throws MareException;

    void closeQueueColombia(PrinterConfiguration pc) throws MareException;

}