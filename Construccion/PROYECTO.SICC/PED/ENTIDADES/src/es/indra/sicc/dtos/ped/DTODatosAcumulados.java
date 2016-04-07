package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosAcumulados extends DTOBelcorp  {
  private Long demanda;
  private Double faltantes;
  private Long unidades;

  public DTODatosAcumulados() {
  }

  public Long getDemanda() {
    return demanda;
  }

  public void setDemanda(Long demanda) {
    this.demanda = demanda;
  }

  public Double getFaltantes() {
    return faltantes;
  }

  public void setFaltantes(Double faltantes) {
    this.faltantes = faltantes;
  }

  public Long getUnidades() {
    return unidades;
  }

  public void setUnidades(Long unidades) {
    this.unidades = unidades;
  }
}