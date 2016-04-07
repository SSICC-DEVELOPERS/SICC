package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.*;

public class DTOSubacceso extends DTOAuditableSICC{
  private Long oidSubacceso;
  private Long oidAcceso;
  private Long oidCanal;
  private String ubigeo;
  private Vector descripcionesSubacceso;
  private String codigoSubacceso;
  private String descripcionUbigeo;
  private String descripcionSubaccesoBusqueda;

  public DTOSubacceso() {
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

  public String getUbigeo() {
    return ubigeo;
  }

  public void setUbigeo(String newUbigeo) {
    ubigeo = newUbigeo;
  }
  
  public Vector getDescripcionesSubacceso() {
    return descripcionesSubacceso;
  }

  public void setDescripcionesSubacceso(Vector newDescripcionesSubacceso) {
    descripcionesSubacceso = newDescripcionesSubacceso;
  }

  public String getCodigoSubacceso() {
    return codigoSubacceso;
  }

  public void setCodigoSubacceso(String newCodigoSubacceso) {
    codigoSubacceso = newCodigoSubacceso;
  }

  public String getDescripcionUbigeo() {
    return descripcionUbigeo;
  }

  public void setDescripcionUbigeo(String newDescripcionUbigeo) {
    descripcionUbigeo = newDescripcionUbigeo;
  }

  public String getDescripcionSubaccesoBusqueda() {
    return descripcionSubaccesoBusqueda;
  }

  public void setDescripcionSubaccesoBusqueda(String newDescripcionSubaccesoBusqueda) {
    descripcionSubaccesoBusqueda = newDescripcionSubaccesoBusqueda;
  }
}