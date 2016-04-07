package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarSubaccesos extends DTOSiccPaginacion  {
  
  private String codigoSubacceso;
  private String descripcionSubacceso;
  private Long oidAcceso;
  private Long oidCanal;

  public DTOEBuscarSubaccesos() {
  }

  public String getCodigoSubacceso() {
    return codigoSubacceso;
  }

  public void setCodigoSubacceso(String newCodigoSubacceso) {
    codigoSubacceso = newCodigoSubacceso;
  }

  public String getDescripcionSubacceso() {
    return descripcionSubacceso;
  }

  public void setDescripcionSubacceso(String newDescripcionSubacceso) {
    descripcionSubacceso = newDescripcionSubacceso;
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



}