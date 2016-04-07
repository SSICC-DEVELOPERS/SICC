package es.indra.sicc.dtos.prueba;
import java.io.Serializable;

public class DTOTiposSolicitud extends DTOAbstractoApplet implements Serializable{
  private String marca;
  private String canal;
  private String acceso;
  private Long oidTipoSolicitud;
  private String tipoSolicitud;
  private Long oidMoneda;
  private String moneda;

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
}