package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOArticulo extends DTOBelcorp {
  private Long oidProductoDescuento;
  private Long oidMarca;
  private String marca;
  private Long oidUnidadNegocio;
  private String unidadNegocio;
  private Long oidNegocio;
  private String negocio;
  private Long oidSupergenerico;
  private String supergenerico;
  private Long oidGenerico;
  private String generico;
  private Long oidProducto;
  private String codigoProducto;

  public DTOArticulo() {
  }

  public Long getOidProductoDescuento() {
    return oidProductoDescuento;
  }

  public void setOidProductoDescuento(Long oidProductoDescuento) {
    this.oidProductoDescuento = oidProductoDescuento;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public Long getOidUnidadNegocio() {
    return oidUnidadNegocio;
  }

  public void setOidUnidadNegocio(Long oidUnidadNegocio) {
    this.oidUnidadNegocio = oidUnidadNegocio;
  }

  public String getUnidadNegocio() {
    return unidadNegocio;
  }

  public void setUnidadNegocio(String unidadNegocio) {
    this.unidadNegocio = unidadNegocio;
  }

  public Long getOidNegocio() {
    return oidNegocio;
  }

  public void setOidNegocio(Long oidNegocio) {
    this.oidNegocio = oidNegocio;
  }

  public String getNegocio() {
    return negocio;
  }

  public void setNegocio(String negocio) {
    this.negocio = negocio;
  }

  public Long getOidSupergenerico() {
    return oidSupergenerico;
  }

  public void setOidSupergenerico(Long oidSupergenerico) {
    this.oidSupergenerico = oidSupergenerico;
  }

  public String getSupergenerico() {
    return supergenerico;
  }

  public void setSupergenerico(String supergenerico) {
    this.supergenerico = supergenerico;
  }

  public Long getOidGenerico() {
    return oidGenerico;
  }

  public void setOidGenerico(Long oidGenerico) {
    this.oidGenerico = oidGenerico;
  }

  public String getGenerico() {
    return generico;
  }

  public void setGenerico(String generico) {
    this.generico = generico;
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
}