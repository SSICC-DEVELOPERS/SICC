package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACDocumentoSubacceso;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.fac.DTOApFormPagE;
import java.util.ArrayList;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACPosicionDocContable;
import java.util.Hashtable;
import es.indra.sicc.util.DTOOIDs;

public interface MONTratamientosContablesLocal extends EJBLocalObject 
{
    DTOFACDocumentoSubacceso activarNuevoRangoNumeracionOficial(DTOFACCabeceraSolicitud consolidado, Long tipoDocumentoLegal) throws MareException;

    void actualizarStockSeguimiento(DTOFACConsolidado dtoConsolidado) throws MareException;

    DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoe) throws MareException;

    ArrayList generarApuntesFormaPago(DTOApFormPagE dtoE, int numDecimales) throws MareException;

    void generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable) throws MareException;

    void generarRegistroCC(DTOFACConsolidado dtoConso) throws MareException;

    void generarRegistroUnicoVenta(DTOFACConsolidado dtoConsolidado) throws MareException;

    void grabarDocumentoContable(DTOFACConsolidado dtoConsolidado) throws MareException;

    Hashtable recuperarTiposDocumento(DTOFACConsolidado dtoConsolidado) throws MareException;

    ArrayList seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento) throws MareException;    

    void grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado) throws MareException;

    void regenerarCuentaCorriente(DTOOIDs tiposSolicitud) throws MareException;

    Hashtable actualizarNumeroDocumentoLegal(DTOFACCabeceraSolicitud consolidado, Hashtable hashTiposDocumento, Long clave, Long oidTipoPrograma, Long oidDocumLegalRef) throws MareException;

    void generarRegistroCC2(DTOFACConsolidado dtoConso) throws MareException;
}
