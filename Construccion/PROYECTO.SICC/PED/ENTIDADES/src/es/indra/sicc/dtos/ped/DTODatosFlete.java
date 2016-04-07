package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTODatosFlete extends DTOAuditableSICC  {
  private BigDecimal solRecargoFleteLocal;
  private BigDecimal solbaseFleteLocal;
  private BigDecimal montoFijo;
  private BigDecimal fleteMinimo;
  private BigDecimal fleteMaximo;
  private Double tasa;
  private BigDecimal contraEntrega;
  private Long clasificacion;
  private Long tipoClasificacion;
  private BigDecimal flete;
  private String codCliente;
  private String codTipoSolicitud;
  
  // Cambio 20090916 - dmorello, 14/07/2009
  private Long oidFlete;

  public DTODatosFlete() {
  }

  public BigDecimal getSolRecargoFleteLocal() {
    return solRecargoFleteLocal;
  }

  public void setSolRecargoFleteLocal(BigDecimal newSolRecargoFleteLocal) {
    solRecargoFleteLocal = newSolRecargoFleteLocal;
  }

  public BigDecimal getSolbaseFleteLocal() {
    return solbaseFleteLocal;
  }

  public void setSolbaseFleteLocal(BigDecimal newSolbaseFleteLocal) {
    solbaseFleteLocal = newSolbaseFleteLocal;
  }

  public BigDecimal getMontoFijo() {
    return montoFijo;
  }

  public void setMontoFijo(BigDecimal newMontoFijo) {
    montoFijo = newMontoFijo;
  }

  public BigDecimal getFleteMinimo() {
    return fleteMinimo;
  }

  public void setFleteMinimo(BigDecimal newFleteMinimo) {
    fleteMinimo = newFleteMinimo;
  }

  public BigDecimal getFleteMaximo() {
    return fleteMaximo;
  }

  public void setFleteMaximo(BigDecimal newFleteMaximo) {
    fleteMaximo = newFleteMaximo;
  }

  public Double getTasa() {
    return tasa;
  }

  public void setTasa(Double newTasa) {
    tasa = newTasa;
  }

  public BigDecimal getContraEntrega() {
    return contraEntrega;
  }

  public void setContraEntrega(BigDecimal newContraEntrega) {
    contraEntrega = newContraEntrega;
  }

  public Long getClasificacion() {
    return clasificacion;
  }

  public void setClasificacion(Long newClasificacion) {
    clasificacion = newClasificacion;
  }

  public Long getTipoClasificacion() {
    return tipoClasificacion;
  }

  public void setTipoClasificacion(Long newTipoClasificacion) {
    tipoClasificacion = newTipoClasificacion;
  }

  public BigDecimal getFlete() {
    return flete;
  }

  public void setFlete(BigDecimal newFlete) {
    flete = newFlete;
  }

  public String getCodCliente() {
    return codCliente;
  }

  public void setCodCliente(String newCodCliente) {
    codCliente = newCodCliente;
  }

  public String getCodTipoSolicitud() {
    return codTipoSolicitud;
  }

  public void setCodTipoSolicitud(String newCodTipoSolicitud) {
    codTipoSolicitud = newCodTipoSolicitud;
  }

    public void setOidFlete(Long oidFlete) {
        this.oidFlete = oidFlete;
    }

    public Long getOidFlete() {
        return oidFlete;
    }
}
