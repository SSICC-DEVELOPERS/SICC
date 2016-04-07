package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCabeceraReporte extends DTOAuditableSICC  {
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
  private Long solicitud;
  private String codigoVenta;
  private DTOMovimiento[] movimientoCategoria;
  private DTOMovimiento[] movimientoProducto;

  public DTOCabeceraReporte() {
  }

  public Long getAcceso() {
    return acceso;
  }

  public void setAcceso(Long newAcceso) {
    acceso = newAcceso;
  }

  public String getTxtAcceso() {
    return txtAcceso;
  }

  public void setTxtAcceso(String newTxtAcceso) {
    txtAcceso = newTxtAcceso;
  }

  public Long getSubacceso() {
    return subacceso;
  }

  public void setSubacceso(Long newSubacceso) {
    subacceso = newSubacceso;
  }

  public Long getUnidadNegocio() {
    return unidadNegocio;
  }

  public void setUnidadNegocio(Long newUnidadNegocio) {
    unidadNegocio = newUnidadNegocio;
  }

  public String getTxtUnidadNegocio() {
    return txtUnidadNegocio;
  }

  public void setTxtUnidadNegocio(String newTxtUnidadNegocio) {
    txtUnidadNegocio = newTxtUnidadNegocio;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

  public String getTxtPeriodo() {
    return txtPeriodo;
  }

  public void setTxtPeriodo(String newTxtPeriodo) {
    txtPeriodo = newTxtPeriodo;
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long newCanal) {
    canal = newCanal;
  }

  public String getTxtCanal() {
    return txtCanal;
  }

  public void setTxtCanal(String newTxtCanal) {
    txtCanal = newTxtCanal;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long newMarca) {
    marca = newMarca;
  }

  public String getTxtMarca() {
    return txtMarca;
  }

  public void setTxtMarca(String newTxtMarca) {
    txtMarca = newTxtMarca;
  }

  public String getTxtPais() {
    return txtPais;
  }

  public void setTxtPais(String newTxtPais) {
    txtPais = newTxtPais;
  }

  public Long getSolicitud() {
    return solicitud;
  }

  public void setSolicitud(Long newSolicitud) {
    solicitud = newSolicitud;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }

  public DTOMovimiento[] getMovimientoCategoria() {
    return movimientoCategoria;
  }

  public void setMovimientoCategoria(DTOMovimiento[] newMovimientoCategoria) {
    movimientoCategoria = newMovimientoCategoria;
  }

  public DTOMovimiento[] getMovimientoProducto() {
    return movimientoProducto;
  }

  public void setMovimientoProducto(DTOMovimiento[] newMovimientoProducto) {
    movimientoProducto = newMovimientoProducto;
  }  
}