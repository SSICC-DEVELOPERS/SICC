package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOImpresionEtiquetas extends DTOBelcorp {
  private Long[] oids;
  private Boolean impresa;

  public Long[] getOids()
  {
    return oids;
  }

  public void setOids(Long[] oids)
  {
    this.oids = oids;
  }

  public Boolean getImpresa()
  {
    return impresa;
  }

  public void setImpresa(Boolean impresa)
  {
    this.impresa = impresa;
  }
}