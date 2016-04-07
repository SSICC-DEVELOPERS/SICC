package es.indra.sicc.dtos.ped.applet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTiposSolicitud extends DTOAuditableSICC {
  private String marca;
  private String canal;
  private String acceso;
  private Long oidTipoSolicitud;
  private String tipoSolicitud;
  private Long oidMoneda;
  private String moneda;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidSubacceso;
  private String subacceso;
  private Long oidTipoCliente;
  private DTODatosCombo[] periodos;
  private Boolean reservaStock;
  private String codAcceso;
  
  

  public DTOTiposSolicitud() {
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String newMarca) {
    marca = newMarca;
  }

  public String getCanal() {
    return canal;
  }

  public void setCanal(String newCanal) {
    canal = newCanal;
  }

  public String getAcceso() {
    return acceso;
  }

  public void setAcceso(String newAcceso) {
    acceso = newAcceso;
  }

  public Long getOidTipoSolicitud() {
    return oidTipoSolicitud;
  }

  public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
    oidTipoSolicitud = newOidTipoSolicitud;
  }

  public String getTipoSolicitud() {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(String newTipoSolicitud) {
    tipoSolicitud = newTipoSolicitud;
  }

  public Long getOidMoneda() {
    return oidMoneda;
  }

  public void setOidMoneda(Long newOidMoneda) {
    oidMoneda = newOidMoneda;
  }

  public String getMoneda() {
    return moneda;
  }

  public void setMoneda(String newMoneda) {
    moneda = newMoneda;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public String getSubacceso()
  {
    return subacceso;
  }

  public void setSubacceso(String subacceso)
  {
    this.subacceso = subacceso;
  }

  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long oidTipoCliente)
  {
    this.oidTipoCliente = oidTipoCliente;
  }

  public DTODatosCombo[] getPeriodos()
  {
    return periodos;
  }

  public void setPeriodos(DTODatosCombo[] periodos)
  {
    this.periodos = periodos;
  }

  public Boolean getReservaStock()
  {
    return reservaStock;
  }

  public void setReservaStock(Boolean reservaStock)
  {
    this.reservaStock = reservaStock;
  }

  public String getCodAcceso()
  {
    return codAcceso;
  }

  public void setCodAcceso(String codAcceso)
  {
    this.codAcceso = codAcceso;
  }
}