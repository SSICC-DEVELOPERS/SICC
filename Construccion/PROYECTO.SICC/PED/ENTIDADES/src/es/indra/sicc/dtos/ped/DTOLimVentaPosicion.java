package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOLimVentaPosicion extends DTOAuditableSICC  {
  private Long oidPosicion;
  private Long numLimVenta;
  private String codVenta;
  private String codCliente;
  private Long numUniDemandadas;
  private Long numUniPorAtender;
    private String descripcionProducto;

  public DTOLimVentaPosicion() {
  }

  public Long getOidPosicion() {
    return oidPosicion;
  }

  public void setOidPosicion(Long newOidPosicion) {
    oidPosicion = newOidPosicion;
  }

  public Long getNumLimVenta() {
    return numLimVenta;
  }

  public void setNumLimVenta(Long newNumLimVenta) {
    numLimVenta = newNumLimVenta;
  }

  public String getCodVenta() {
    return codVenta;
  }

  public void setCodVenta(String newCodVenta) {
    codVenta = newCodVenta;
  }

  public String getCodCliente() {
    return codCliente;
  }

  public void setCodCliente(String newCodCliente) {
    codCliente = newCodCliente;
  }

  public Long getNumUniDemandadas() {
    return numUniDemandadas;
  }

  public void setNumUniDemandadas(Long newNumUniDemandadas) {
    numUniDemandadas = newNumUniDemandadas;
  }

  public Long getNumUniPorAtender() {
    return numUniPorAtender;
  }

  public void setNumUniPorAtender(Long newNumUniPorAtender) {
    numUniPorAtender = newNumUniPorAtender;
  }

    public String getDescripcionProducto()
    {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto)
    {
        this.descripcionProducto = descripcionProducto;
    }

  
}