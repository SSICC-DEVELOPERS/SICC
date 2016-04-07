package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOPremioArticulo  extends DTOBelcorp {
  private Long oidPremioArticulo;
  private Integer numeroUnidadesPremioArticulo;
  private ArrayList lstLotesPremio;

  public DTOPremioArticulo() {
  }

  public Long getOidPremioArticulo() {
    return oidPremioArticulo;
  }

  public void setOidPremioArticulo(Long oidPremioArticulo) {
    this.oidPremioArticulo = oidPremioArticulo;
  }

  public Integer getNumeroUnidadesPremioArticulo() {
    return numeroUnidadesPremioArticulo;
  }

  public void setNumeroUnidadesPremioArticulo(Integer numeroUnidadesPremioArticulo) {
    this.numeroUnidadesPremioArticulo = numeroUnidadesPremioArticulo;
  }

  public ArrayList getLstLotesPremio() {
    return lstLotesPremio;
  }

  public void setLstLotesPremio(ArrayList lstLotesPremio) {
    this.lstLotesPremio = lstLotesPremio;
  }
}