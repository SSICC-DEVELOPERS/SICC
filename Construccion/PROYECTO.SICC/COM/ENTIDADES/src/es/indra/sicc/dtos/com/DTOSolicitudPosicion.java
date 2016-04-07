package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOSolicitudPosicion extends DTOAuditableSICC  {
    
    private Long oid;
    private Long oidProducto;
    private BigDecimal precioCatalogoTotalLocal;
    private BigDecimal precioFacturaTotalLocal;
    private BigDecimal precioNetoTotalLocal;
    private Boolean indControlStock;
    private Boolean indControlLiquidacion;
    private Long unidadesDemandaReal;
    private Long unidadesAtendidas;
    private BigDecimal precioCatalogoUnitLocal;
    private BigDecimal precioFacturaUnitLocal;
    private BigDecimal precioNetoUnitLocal;
    
    public DTOSolicitudPosicion() {
    }


    public void setOid(Long oid) {
        this.oid = oid;
    }


    public Long getOid() {
        return oid;
    }


    public void setPrecioCatalogoTotalLocal(BigDecimal precioCatalogoTotalLocal) {
        this.precioCatalogoTotalLocal = precioCatalogoTotalLocal;
    }


    public BigDecimal getPrecioCatalogoTotalLocal() {
        return precioCatalogoTotalLocal;
    }


    public void setPrecioFacturaTotalLocal(BigDecimal precioFacturaTotalLocal) {
        this.precioFacturaTotalLocal = precioFacturaTotalLocal;
    }


    public BigDecimal getPrecioFacturaTotalLocal() {
        return precioFacturaTotalLocal;
    }


    public void setPrecioNetoTotalLocal(BigDecimal precioNetoTotalLocal) {
        this.precioNetoTotalLocal = precioNetoTotalLocal;
    }


    public BigDecimal getPrecioNetoTotalLocal() {
        return precioNetoTotalLocal;
    }


    public void setIndControlStock(Boolean indControlStock) {
        this.indControlStock = indControlStock;
    }


    public Boolean getIndControlStock() {
        return indControlStock;
    }


    public void setIndControlLiquidacion(Boolean indControlLiquidacion) {
        this.indControlLiquidacion = indControlLiquidacion;
    }


    public Boolean getIndControlLiquidacion() {
        return indControlLiquidacion;
    }


    public void setUnidadesDemandaReal(Long unidadesDemandaReal) {
        this.unidadesDemandaReal = unidadesDemandaReal;
    }


    public Long getUnidadesDemandaReal() {
        return unidadesDemandaReal;
    }


    public void setUnidadesAtendidas(Long unidadesAtendidas) {
        this.unidadesAtendidas = unidadesAtendidas;
    }


    public Long getUnidadesAtendidas() {
        return unidadesAtendidas;
    }


    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }


    public Long getOidProducto() {
        return oidProducto;
    }

  public BigDecimal getPrecioCatalogoUnitLocal()
  {
    return precioCatalogoUnitLocal;
  }

  public void setPrecioCatalogoUnitLocal(BigDecimal precioCatalogoUnitLocal)
  {
    this.precioCatalogoUnitLocal = precioCatalogoUnitLocal;
  }

  public BigDecimal getPrecioFacturaUnitLocal()
  {
    return precioFacturaUnitLocal;
  }

  public void setPrecioFacturaUnitLocal(BigDecimal precioFacturaUnitLocal)
  {
    this.precioFacturaUnitLocal = precioFacturaUnitLocal;
  }

  public BigDecimal getPrecioNetoUnitLocal()
  {
    return precioNetoUnitLocal;
  }

  public void setPrecioNetoUnitLocal(BigDecimal precioNetoUnitLocal)
  {
    this.precioNetoUnitLocal = precioNetoUnitLocal;
  }
}