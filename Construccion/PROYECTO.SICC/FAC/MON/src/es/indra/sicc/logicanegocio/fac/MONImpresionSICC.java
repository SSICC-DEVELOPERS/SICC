package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
//import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOLoteImpresion;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocLegal;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableCabecera;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOClienteSolicitud;

public interface MONImpresionSICC extends EJBObject  {
	void generarDocFactura(DTOFACConsolidado datosConsolidado) throws RemoteException, MareException;

	DTODocumento getDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal) throws RemoteException, MareException;

	void imprimirDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal, Long oidImpresoraVirtual, Integer secuencia, Long oidSubacceso) throws RemoteException, MareException;

	DTODocumento visualizarDocumentoFacturacion(DTOOID oidDocumentoContable, Long subacceso) throws RemoteException, MareException;

	DTODocumento componerDoc(DTODocLegal datosDoc, DTOClienteSolicitud dtoClie) throws RemoteException, MareException;

	DTODocLegal componerDatosCCC(DTOFACConsolidado datosConsolidado, DTODocLegal miDTODocNoLegal) throws RemoteException, MareException;

  DTOFACDocumentoContableCabecera rellenarDTOFACDocumentoNoLegal(RecordSet entrada, DTOFACDocumentoContableCabecera dtoEntrada, DTOFACConsolidado datosConsolidado) throws RemoteException;

    ArrayList obtenerPatronDocumento(Long oidForm, Long oidPeriodo) throws RemoteException, MareException;

    DTODocumento visualizarDocumentoFacturacion(DTOOID dtoOid) throws MareException, RemoteException;

    void enviarFantasmas(ArrayList listaFantasma, Long idSpool, Integer numSecuenciaImpresion, ArrayList listaDocumentos) throws RemoteException, MareException;

    void generarDocFacturaColombia(DTOFACConsolidado datosConsolidado) throws MareException, RemoteException;


}