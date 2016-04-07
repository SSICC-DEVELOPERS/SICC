package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOProductosLote  extends DTOBelcorp {
  private Long oidProductoLote;
  private Long oidProducto;
  private String codigoProducto;
  private Integer numeroUnidades;
  private BigDecimal precioPublico;
  private Boolean indDespachaArticulo;
  private String codVentaFicticio;
  
  //vbongiov --14/09/2007
  private Boolean indCentroServGar;
  private Long oidCentroServGar;
  private Integer numMeses;
  private String observaciones;
  private String indTipoEntrega;
  private Long oidCentroServEntrega;
  private String descCentSerGar;
  private String descCentSerEntrega;
  
  // vbongiov -- Cambio 20090930 -- 16/07/2009
  private String descProducto;

  public DTOProductosLote() {
  }

  public Long getOidProductoLote() {
    return oidProductoLote;
  }

  public void setOidProductoLote(Long oidProductoLote) {
    this.oidProductoLote = oidProductoLote;
  }

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public Integer getNumeroUnidades() {
    return numeroUnidades;
  }

  public void setNumeroUnidades(Integer numeroUnidades) {
    this.numeroUnidades = numeroUnidades;
  }

  public BigDecimal getPrecioPublico() {
    return precioPublico;
  }

  public void setPrecioPublico(BigDecimal precioPublico) {
    this.precioPublico = precioPublico;
  }

  public Boolean getIndDespachaArticulo() {
    return indDespachaArticulo;
  }

  public void setIndDespachaArticulo(Boolean indDespachaArticulo) {
    this.indDespachaArticulo = indDespachaArticulo;
  }

  public String getCodVentaFicticio() {
    return codVentaFicticio;
  }

  public void setCodVentaFicticio(String codVentaFicticio) {
    this.codVentaFicticio = codVentaFicticio;
  }
  
  public Boolean getIndCentroServGar() {
    return indCentroServGar;
  }

  public void setIndCentroServGar(Boolean indCentroServGar) {
    this.indCentroServGar = indCentroServGar;
  }

  public Long getOidCentroServGar() {
    return oidCentroServGar;
  }

  public void setOidCentroServGar(Long oidCentroServGar) {
    this.oidCentroServGar = oidCentroServGar;
  }

  public Integer getNumMeses() {
    return numMeses;
  }

  public void setNumMeses(Integer numMeses) {
    this.numMeses = numMeses;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getIndTipoEntrega() {
    return indTipoEntrega;
  }

  public void setIndTipoEntrega(String indTipoEntrega) {
    this.indTipoEntrega = indTipoEntrega;
  }

  public Long getOidCentroServEntrega() {
    return oidCentroServEntrega;
  }

  public void setOidCentroServEntrega(Long oidCentroServEntrega) {
    this.oidCentroServEntrega = oidCentroServEntrega;
  }

  public String getDescCentSerGar() {
    return descCentSerGar;
  }

  public void setDescCentSerGar(String descCentSerGar) {
    this.descCentSerGar = descCentSerGar;
  }

  public String getDescCentSerEntrega() {
    return descCentSerEntrega;
  }

  public void setDescCentSerEntrega(String descCentSerEntrega) {
    this.descCentSerEntrega = descCentSerEntrega;
  }
  
  public String getDescProducto() {
    return descProducto;
  }

  public void setDescProducto(String descProducto) {
    this.descProducto = descProducto;
  }
}
