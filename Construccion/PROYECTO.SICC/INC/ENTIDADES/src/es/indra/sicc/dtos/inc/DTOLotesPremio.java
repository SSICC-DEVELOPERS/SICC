package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOLotesPremio  extends DTOBelcorp {
  private Long oidLotePremio;
  private Integer numeroPremio;
  private String descripcionLote;
  ArrayList lstProductosLote;

  public DTOLotesPremio() {
  }

  public Long getOidLotePremio() {
    return oidLotePremio;
  }

  public void setOidLotePremio(Long oidLotePremio) {
    this.oidLotePremio = oidLotePremio;
  }

  public Integer getNumeroPremio() {
    return numeroPremio;
  }

  public void setNumeroPremio(Integer numeroPremio) {
    this.numeroPremio = numeroPremio;
  }

  public String getDescripcionLote() {
    return descripcionLote;
  }

  public void setDescripcionLote(String descripcionLote) {
    this.descripcionLote = descripcionLote;
  }

  public ArrayList getLstProductosLote() {
    return lstProductosLote;
  }

  public void setLstProductosLote(ArrayList lstProductosLote) {
    this.lstProductosLote = lstProductosLote;
  }
}