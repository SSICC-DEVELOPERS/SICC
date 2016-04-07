package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOCalcularTotales extends DTOAuditableSICC  {
  private BigDecimal precioCatalogo;
  private BigDecimal precioDemandaReal;
  private BigDecimal precioContable;
  private Long unidadesAtender;
  private Long unidadesDemandaReal;
  private Long oidSolicitud;
  private BigDecimal BaseFleteDocumento;   
    
    //jrivas 20/9/2006
    private Boolean indDevo;
    private Boolean indAnul;
    private Long oidCliente;
    private Long oidPeriodo;
    private Boolean indOC;
  private BigDecimal importeDescuento;

  public DTOCalcularTotales() {
  }

  public BigDecimal getPrecioCatalogo() {
    return precioCatalogo;
  }

  public void setPrecioCatalogo(BigDecimal newPrecioCatalogo) {
    precioCatalogo = newPrecioCatalogo;
  }

  public BigDecimal getPrecioDemandaReal() {
    return precioDemandaReal;
  }

  public void setPrecioDemandaReal(BigDecimal newPrecioDemandaReal) {
    precioDemandaReal = newPrecioDemandaReal;
  }

  public BigDecimal getPrecioContable() {
    return precioContable;
  }

  public void setPrecioContable(BigDecimal newPrecioContable) {
    precioContable = newPrecioContable;
  }

  public Long getUnidadesAtender() {
    return unidadesAtender;
  }

  public void setUnidadesAtender(Long newUnidadesAtender) {
    unidadesAtender = newUnidadesAtender;
  }

  public Long getUnidadesDemandaReal() {
    return unidadesDemandaReal;
  }

  public void setUnidadesDemandaReal(Long newUnidadesDemandaReal) {
    unidadesDemandaReal = newUnidadesDemandaReal;
  }

  public Long getOidSolicitud() {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long newOidSolicitud) {
    oidSolicitud = newOidSolicitud;
  }
  
  public BigDecimal getBaseFleteDocumento() {
    return BaseFleteDocumento;
  }  
  
  public void setBaseFleteDocumento(BigDecimal newBaseFleteDocumento) {
    BaseFleteDocumento = newBaseFleteDocumento;
  }  

    public Boolean getIndDevo()
    {
        return indDevo;
    }

    public void setIndDevo(Boolean indDevo)
    {
        this.indDevo = indDevo;
    }

    public Boolean getIndAnul()
    {
        return indAnul;
    }

    public void setIndAnul(Boolean indAnul)
    {
        this.indAnul = indAnul;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Boolean getIndOC()
    {
        return indOC;
    }

    public void setIndOC(Boolean indOC)
    {
        this.indOC = indOC;
    }

  public BigDecimal getImporteDescuento()
  {
    return importeDescuento;
  }

  public void setImporteDescuento(BigDecimal importeDescuento)
  {
    this.importeDescuento = importeDescuento;
  }
  
}