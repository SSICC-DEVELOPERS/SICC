package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTONumeroSolicitud extends DTOAuditableSICC {
  private Integer anyo;
  private Integer ultimoNumSolicitud;
  private Long oid;
  private Long oidSubacceso;
  private Long oidAcceso;
  private Long oidCanal;
  private String operacion;
  private String codCanal;
  private String codAcceso;
  private String codSubacceso;
  private String codPais;

  public DTONumeroSolicitud() {
  }

  public Integer getAnyo() {
    return anyo;
  }

  public void setAnyo(Integer newAnyo) {
    anyo = newAnyo;
  }

  public Integer getUltimoNumSolicitud() {
    return ultimoNumSolicitud;
  }

  public void setUltimoNumSolicitud(Integer newUltimoNumSolicitud) {
    ultimoNumSolicitud = newUltimoNumSolicitud;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Long getOidSubacceso() {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long newOidSubacceso) {
    oidSubacceso = newOidSubacceso;
  }

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal) {
    oidCanal = newOidCanal;
  }

  public String getOperacion() {
    return operacion;
  }

  public void setOperacion(String newOperacion) {
    operacion = newOperacion;
  }

  public String getCodCanal()
  {
    return codCanal;
  }

  public void setCodCanal(String newCodCanal)
  {
    codCanal = newCodCanal;
  }

  public String getCodAcceso()
  {
    return codAcceso;
  }

  public void setCodAcceso(String newCodAcceso)
  {
    codAcceso = newCodAcceso;
  }

  public String getCodSubacceso()
  {
    return codSubacceso;
  }

  public void setCodSubacceso(String newCodSubacceso)
  {
    codSubacceso = newCodSubacceso;
  }

  public String getCodPais()
  {
    return codPais;
  }

  public void setCodPais(String newCodPais)
  {
    codPais = newCodPais;
  }
}