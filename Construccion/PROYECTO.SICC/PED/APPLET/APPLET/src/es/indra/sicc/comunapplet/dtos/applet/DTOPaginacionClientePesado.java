package es.indra.sicc.comunapplet.dtos.applet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPaginacionClientePesado extends DTOAuditableSICC {
  private Long indicadorSituacion;
  private Integer tamanioPagina;

  public Long getIndicadorSituacion()
  {
    return indicadorSituacion;
  }

  public void setIndicadorSituacion(Long indicadorSituacion)
  {
    this.indicadorSituacion = indicadorSituacion;
  }

  public Integer getTamanioPagina()
  {
    return tamanioPagina;
  }

  public void setTamanioPagina(Integer tamanioPagina)
  {
    this.tamanioPagina = tamanioPagina;
  }
  
}