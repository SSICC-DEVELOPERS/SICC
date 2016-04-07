package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMovimiento extends DTOAuditableSICC  {
  private Long almacen;
  private String txtAlmacen;
  private Long negocio;
  private String txtNegocio;
  private Boolean indDiario;
  private Boolean indAhorro;
  private Long demanda;
  private Long stockDisponible;
  private Double faltante;
  private Long unidades;
  private Long posicion;
  private Long producto;
  private String txtProducto;

  public DTOMovimiento() {
  }

  public Long getAlmacen() {
    return almacen;
  }

  public void setAlmacen(Long newAlmacen) {
    almacen = newAlmacen;
  }

  public String getTxtAlmacen() {
    return txtAlmacen;
  }

  public void setTxtAlmacen(String newTxtAlmacen) {
    txtAlmacen = newTxtAlmacen;
  }

  public Long getNegocio() {
    return negocio;
  }

  public void setNegocio(Long newNegocio) {
    negocio = newNegocio;
  }

  public String getTxtNegocio() {
    return txtNegocio;
  }

  public void setTxtNegocio(String newTxtNegocio) {
    txtNegocio = newTxtNegocio;
  }

  public Boolean getIndDiario() {
    return indDiario;
  }

  public void setIndDiario(Boolean newIndDiario) {
    indDiario = newIndDiario;
  }

  public Boolean getIndAhorro() {
    return indAhorro;
  }

  public void setIndAhorro(Boolean newIndAhorro) {
    indAhorro = newIndAhorro;
  }

  public Long getDemanda() {
    return demanda;
  }

  public void setDemanda(Long newDemanda) {
    demanda = newDemanda;
  }

  public Long getStockDisponible() {
    return stockDisponible;
  }

  public void setStockDisponible(Long newStockDisponible) {
    stockDisponible = newStockDisponible;
  }

  public Double getFaltante() {
    return faltante;
  }

  public void setFaltante(Double newFaltante) {
    faltante = newFaltante;
  }

  public Long getUnidades() {
    return unidades;
  }

  public void setUnidades(Long newUnidades) {
    unidades = newUnidades;
  }

  public Long getPosicion() {
    return posicion;
  }

  public void setPosicion(Long newPosicion) {
    posicion = newPosicion;
  }

  public Long getProducto() {
    return producto;
  }

  public void setProducto(Long newProducto) {
    producto = newProducto;
  }

  public String getTxtProducto() {
    return txtProducto;
  }

  public void setTxtProducto(String newTxtProducto) {
    txtProducto = newTxtProducto;
  }
}