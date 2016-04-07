package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTOActualizarStockMinimo extends DTOBelcorp {

  public DTOActualizarStockMinimo(){
  }
  
  private Long subacceso;
  private Long periodo;

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getSubacceso()
  {
    return subacceso;
  }

  public void setSubacceso(Long subacceso)
  {
    this.subacceso = subacceso;
  }
}