package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import  javax.ejb.DuplicateKeyException;
import java.math.BigDecimal;

public interface LineaDocumentoContableLocalHome extends EJBLocalHome  {
    LineaDocumentoContableLocal create() throws CreateException;

    LineaDocumentoContableLocal findByPrimaryKey(Long primaryKey) throws FinderException;

    LineaDocumentoContableLocal create(Long cabecera, Integer unidadesAtendidas, Long posicionSolicitud, Long producto,/* Long moneda,*/ Integer numeroLinea) throws CreateException, DuplicateKeyException;

    LineaDocumentoContableLocal create(BigDecimal precioTotalTotalDocumento, BigDecimal precioNetoTotalDocumento, BigDecimal importeImpuestoTotalDocumento, BigDecimal importeDescuentoSinImpuestoTotalDocumento, BigDecimal importeDescuentoTotalDocumento, BigDecimal precioFacturaTotalDocumento, BigDecimal precioCatalogoTotalDocumento, BigDecimal precioTotalUnitarioDocumento, BigDecimal importeImpuestoUnitarioDocumento, BigDecimal precioNetoUnitarioDocumento, 
	BigDecimal importeDescuentoSinImpuestosUnitarioDocumento, BigDecimal importeDescuentoUnitarioDocumento, BigDecimal porcentajeDescuento, BigDecimal precioSinImpuestosUnitarioDocumento, BigDecimal precioFacturaUnitarioDocumento, BigDecimal precioContableUnitarioDocumento, BigDecimal precioCatalogoUnitarioDocumento, BigDecimal precioTotalTotalLocal, BigDecimal importeImpuestoTotalLocal, BigDecimal precioNetoTotalLocal, BigDecimal importeDescuentoSinImpuestosTotalLocal, BigDecimal importeDescuentoTotalLocal, BigDecimal precioSinImpuestosTotalLocal, BigDecimal precioFacturaTotalLocal, BigDecimal precioCatalogoTotalLocalUnidadesDemandaReal, BigDecimal precioCatalogoTotalLocal, BigDecimal precioContableTotalLocal, BigDecimal precioTotalUnitarioLocal, BigDecimal importeImpuestoUnitarioLocal, BigDecimal precioNetoUnitarioLocal, BigDecimal importeDescuentoSinImpuestosUnitarioLocal, BigDecimal importeDescuentoUnitarioLocal, BigDecimal precioSinImpuestosUnitarioLocal, BigDecimal precioFacturaUnitarioLocal, BigDecimal precioContableUnitarioLocal, BigDecimal precioCatalogoUnitarioLocal, String indicadorDentroFueraCajaBolsa, Integer numeroLinea, Integer unidadesAtendidas, Boolean indicadorNoImprimible, Float precioSinImpuestosTotalDocumento, Integer catalogo, Integer pagina, Long cabecera, Long producto, Long moneda, Long posicionSolicitud, BigDecimal precioContableTotalDocumento) throws CreateException, DuplicateKeyException;
}