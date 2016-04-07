package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;

public class DTOMovimientoDiario extends DTOBelcorp  {
  private Long acceso;
  private String txtAcceso;
  private Long subacceso;
  private Long unidadNegocio;
  private String txtUnidadNegocio;
  private Long periodo;
  private String txtPeriodo;
  private Long canal;
  private String txtCanal;
  private Long marca;
  private String txtMarca;
  private String txtPais;
  private Long almacen;
  private String txtAlmacen;
  private Long negocio;
  private String txtNegocio;
  private Boolean indDiario;
  private Boolean indAhorro;
  private Long unidades;
  private Long stockDisponible;
  private Double faltante;
  private Long demanda;  
  private Long posicion;
  private Long producto;
  private String txtProducto;
  private Double umbral;

  public DTOMovimientoDiario() {
  }

  public Long getAcceso() {
    return acceso;
  }

  public void setAcceso(Long acceso) {
    this.acceso = acceso;
  }

  public String getTxtAcceso() {
    return txtAcceso;
  }

  public void setTxtAcceso(String txtAcceso) {
    this.txtAcceso = txtAcceso;
  }

  public Long getSubacceso() {
    return subacceso;
  }

  public void setSubacceso(Long subacceso) {
    this.subacceso = subacceso;
  }

  public Long getUnidadNegocio() {
    return unidadNegocio;
  }

  public void setUnidadNegocio(Long unidadNegocio) {
    this.unidadNegocio = unidadNegocio;
  }

  public String getTxtUnidadNegocio() {
    return txtUnidadNegocio;
  }

  public void setTxtUnidadNegocio(String txtUnidadNegocio) {
    this.txtUnidadNegocio = txtUnidadNegocio;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long periodo) {
    this.periodo = periodo;
  }

  public String getTxtPeriodo() {
    return txtPeriodo;
  }

  public void setTxtPeriodo(String txtPeriodo) {
    this.txtPeriodo = txtPeriodo;
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long canal) {
    this.canal = canal;
  }

  public String getTxtCanal() {
    return txtCanal;
  }

  public void setTxtCanal(String txtCanal) {
    this.txtCanal = txtCanal;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long marca) {
    this.marca = marca;
  }

  public String getTxtMarca() {
    return txtMarca;
  }

  public void setTxtMarca(String txtMarca) {
    this.txtMarca = txtMarca;
  }

  public String getTxtPais() {
    return txtPais;
  }

  public void setTxtPais(String txtPais) {
    this.txtPais = txtPais;
  }

  public Long getAlmacen() {
    return almacen;
  }

  public void setAlmacen(Long almacen) {
    this.almacen = almacen;
  }

  public String getTxtAlmacen() {
    return txtAlmacen;
  }

  public void setTxtAlmacen(String txtAlmacen) {
    this.txtAlmacen = txtAlmacen;
  }

  public Long getNegocio() {
    return negocio;
  }

  public void setNegocio(Long negocio) {
    this.negocio = negocio;
  }

  public String getTxtNegocio() {
    return txtNegocio;
  }

  public void setTxtNegocio(String txtNegocio) {
    this.txtNegocio = txtNegocio;
  }

  public Boolean getIndDiario() {
    return indDiario;
  }

  public void setIndDiario(Boolean indDiario) {
    this.indDiario = indDiario;
  }

  public Boolean getIndAhorro() {
    return indAhorro;
  }

  public void setIndAhorro(Boolean indAhorro) {
    this.indAhorro = indAhorro;
  }

  public Long getUnidades() {
    return unidades;
  }

  public void setUnidades(Long unidades) {
    this.unidades = unidades;
  }

  public Long getStockDisponible() {
    return stockDisponible;
  }

  public void setStockDisponible(Long stockDisponible) {
    this.stockDisponible = stockDisponible;
  }

  public Double getFaltante() {
    return faltante;
  }

  public void setFaltante(Double faltante) {
    this.faltante = faltante;
  }

  public Long getDemanda() {
    return demanda;
  }

  public void setDemanda(Long demanda) {
    this.demanda = demanda;
  }

  public Long getPosicion() {
    return posicion;
  }

  public void setPosicion(Long posicion) {
    this.posicion = posicion;
  }

  public Long getProducto() {
    return producto;
  }

  public void setProducto(Long producto) {
    this.producto = producto;
  }

  public String getTxtProducto() {
    return txtProducto;
  }

  public void setTxtProducto(String txtProducto) {
    this.txtProducto = txtProducto;
  }

  public Double getUmbral() {
    return umbral;
  }

  public void setUmbral(Double umbral) {
    this.umbral = umbral;
  }  
}