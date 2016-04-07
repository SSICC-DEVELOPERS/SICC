package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocLegal;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOClienteSolicitud;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;

public interface MONImpresionSICCLocal extends EJBLocalObject 
{
    void generarDocFactura(DTOFACConsolidado datosConsolidado) throws MareException;

    void enviarFantasmas(ArrayList listaFantasma, Long idSpool, Integer numSecuenciaImpresion, ArrayList listaDocumentos) throws MareException;

    DTODocumento componerDoc(DTODocLegal datosDoc, DTOClienteSolicitud dtoClie) throws MareException;

    DTODocLegal componerDatosCCC(DTOFACConsolidado datosConsolidado, DTODocLegal miDTODocNoLegal) throws MareException;

    DTODocumento getDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal) throws MareException;

    void imprimirDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal, Long oidImpresoraVirtual, Integer secuencia, Long oidSubacceso) throws MareException;

    ArrayList obtenerPatronDocumento(Long oidForm, Long oidPeriodo) throws MareException;

    void generarDocFacturaColombia(DTOFACConsolidado datosConsolidado) throws MareException;
}