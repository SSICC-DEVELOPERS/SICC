package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalObject;
import java.math.BigDecimal;


public interface LineaDocumentoContableLocal extends EJBLocalObject  {
    Long getCabecera();

    void setCabecera(Long newCabecera);

    Integer getCatalogo();

    void setCatalogo(Integer newCatalogo);

    BigDecimal getImporteDescuentoSinImpuestoTotalDocumento();

    void setImporteDescuentoSinImpuestoTotalDocumento(BigDecimal newImporteDescuentoSinImpuestoTotalDocumento);

    BigDecimal getImporteDescuentoSinImpuestosTotalLocal();

    void setImporteDescuentoSinImpuestosTotalLocal(BigDecimal newImporteDescuentoSinImpuestosTotalLocal);

    BigDecimal getImporteDescuentoSinImpuestosUnitarioDocumento();

    void setImporteDescuentoSinImpuestosUnitarioDocumento(BigDecimal newImporteDescuentoSinImpuestosUnitarioDocumento);

    BigDecimal getImporteDescuentoSinImpuestosUnitarioLocal();

    void setImporteDescuentoSinImpuestosUnitarioLocal(BigDecimal newImporteDescuentoSinImpuestosUnitarioLocal);

    BigDecimal getImporteDescuentoTotalDocumento();

    void setImporteDescuentoTotalDocumento(BigDecimal newImporteDescuentoTotalDocumento);

    BigDecimal getImporteDescuentoTotalLocal();

    void setImporteDescuentoTotalLocal(BigDecimal newImporteDescuentoTotalLocal);

    BigDecimal getImporteDescuentoUnitarioDocumento();

    void setImporteDescuentoUnitarioDocumento(BigDecimal newImporteDescuentoUnitarioDocumento);

    BigDecimal getImporteDescuentoUnitarioLocal();

    void setImporteDescuentoUnitarioLocal(BigDecimal newImporteDescuentoUnitarioLocal);

    BigDecimal getImporteImpuestoTotalDocumento();

    void setImporteImpuestoTotalDocumento(BigDecimal newImporteImpuestoTotalDocumento);

    BigDecimal getImporteImpuestoTotalLocal();

    void setImporteImpuestoTotalLocal(BigDecimal newImporteImpuestoTotalLocal);

    BigDecimal getImporteImpuestoUnitarioDocumento();

    void setImporteImpuestoUnitarioDocumento(BigDecimal newImporteImpuestoUnitarioDocumento);

    BigDecimal getImporteImpuestoUnitarioLocal();

    void setImporteImpuestoUnitarioLocal(BigDecimal newImporteImpuestoUnitarioLocal);

    String getIndicadorDentroFueraCajaBolsa();

    void setIndicadorDentroFueraCajaBolsa(String newIndicadorDentroFueraCajaBolsa);

    Boolean getIndicadorNoImprimible();

    void setIndicadorNoImprimible(Boolean newIndicadorNoImprimible);

    Long getMoneda();

    void setMoneda(Long newMoneda);

    Integer getNumeroLinea();

    void setNumeroLinea(Integer newNumeroLinea);

    Long getOid();

    void setOid(Long newOid);

    Integer getPagina();

    void setPagina(Integer newPagina);

    BigDecimal getPorcentajeDescuento();

    void setPorcentajeDescuento(BigDecimal newPorcentajeDescuento);

    Long getPosicionSolicitud();

    void setPosicionSolicitud(Long newPosicionSolicitud);

    BigDecimal getPrecioCatalogoTotalDocumento();

    void setPrecioCatalogoTotalDocumento(BigDecimal newPrecioCatalogoTotalDocumento);

    BigDecimal getPrecioCatalogoTotalLocal();

    void setPrecioCatalogoTotalLocal(BigDecimal newPrecioCatalogoTotalLocal);

    BigDecimal getPrecioCatalogoTotalLocalUnidadesDemandaReal();

    void setPrecioCatalogoTotalLocalUnidadesDemandaReal(BigDecimal newPrecioCatalogoTotalLocalUnidadesDemandaReal);

    BigDecimal getPrecioCatalogoUnitarioDocumento();

    void setPrecioCatalogoUnitarioDocumento(BigDecimal newPrecioCatalogoUnitarioDocumento);

    BigDecimal getPrecioCatalogoUnitarioLocal();

    void setPrecioCatalogoUnitarioLocal(BigDecimal newPrecioCatalogoUnitarioLocal);

    BigDecimal getPrecioContableTotalDocumento();

    void setPrecioContableTotalDocumento(BigDecimal newPrecioContableTotalDocumento);

    BigDecimal getPrecioContableTotalLocal();

    void setPrecioContableTotalLocal(BigDecimal newPrecioContableTotalLocal);

    BigDecimal getPrecioContableUnitarioDocumento();

    void setPrecioContableUnitarioDocumento(BigDecimal newPrecioContableUnitarioDocumento);

    BigDecimal getPrecioContableUnitarioLocal();

    void setPrecioContableUnitarioLocal(BigDecimal newPrecioContableUnitarioLocal);

    BigDecimal getPrecioFacturaTotalDocumento();

    void setPrecioFacturaTotalDocumento(BigDecimal newPrecioFacturaTotalDocumento);

    BigDecimal getPrecioFacturaTotalLocal();

    void setPrecioFacturaTotalLocal(BigDecimal newPrecioFacturaTotalLocal);

    BigDecimal getPrecioFacturaUnitarioDocumento();

    void setPrecioFacturaUnitarioDocumento(BigDecimal newPrecioFacturaUnitarioDocumento);

    BigDecimal getPrecioFacturaUnitarioLocal();

    void setPrecioFacturaUnitarioLocal(BigDecimal newPrecioFacturaUnitarioLocal);

    BigDecimal getPrecioNetoTotalDocumento();

    void setPrecioNetoTotalDocumento(BigDecimal newPrecioNetoTotalDocumento);

    BigDecimal getPrecioNetoTotalLocal();

    void setPrecioNetoTotalLocal(BigDecimal newPrecioNetoTotalLocal);

    BigDecimal getPrecioNetoUnitarioDocumento();

    void setPrecioNetoUnitarioDocumento(BigDecimal newPrecioNetoUnitarioDocumento);

    BigDecimal getPrecioNetoUnitarioLocal();

    void setPrecioNetoUnitarioLocal(BigDecimal newPrecioNetoUnitarioLocal);

    Float getPrecioSinImpuestosTotalDocumento();

    void setPrecioSinImpuestosTotalDocumento(Float newPrecioSinImpuestosTotalDocumento);

    BigDecimal getPrecioSinImpuestosTotalLocal();

    void setPrecioSinImpuestosTotalLocal(BigDecimal newPrecioSinImpuestosTotalLocal);

    BigDecimal getPrecioSinImpuestosUnitarioDocumento();

    void setPrecioSinImpuestosUnitarioDocumento(BigDecimal newPrecioSinImpuestosUnitarioDocumento);

    BigDecimal getPrecioSinImpuestosUnitarioLocal();

    void setPrecioSinImpuestosUnitarioLocal(BigDecimal newPrecioSinImpuestosUnitarioLocal);

    BigDecimal getPrecioTotalTotalDocumento();

    void setPrecioTotalTotalDocumento(BigDecimal newPrecioTotalTotalDocumento);

    BigDecimal getPrecioTotalTotalLocal();

    void setPrecioTotalTotalLocal(BigDecimal newPrecioTotalTotalLocal);

    BigDecimal getPrecioTotalUnitarioDocumento();

    void setPrecioTotalUnitarioDocumento(BigDecimal newPrecioTotalUnitarioDocumento);

    BigDecimal getPrecioTotalUnitarioLocal();

    void setPrecioTotalUnitarioLocal(BigDecimal newPrecioTotalUnitarioLocal);

    Long getProducto();

    void setProducto(Long newProducto);

    Integer getUnidadesAtendidas();

    void setUnidadesAtendidas(Integer newUnidadesAtendidas);
}