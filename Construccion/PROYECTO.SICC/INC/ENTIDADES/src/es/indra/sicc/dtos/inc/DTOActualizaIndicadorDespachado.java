package es.indra.sicc.dtos.inc;

import es.indra.sicc.logicanegocio.inc.ClientePremiacion;
import es.indra.sicc.logicanegocio.inc.ClientePremiacionConcurso;

public class DTOActualizaIndicadorDespachado {
  private ClientePremiacion clientePremiacion;
  private ClientePremiacionConcurso clienteConcurso;
  private Long oidNivelPremiacion;
  private Long oidPeriodoControl;
  private Long oidCabSol;
  private Long oidGanadora;
  
  public DTOActualizaIndicadorDespachado() { }
  
  public ClientePremiacion getClientePremiacion() {
    return this.clientePremiacion;
  }
  
  public void setClientePremiacion(ClientePremiacion clientePremiacion) {
    this.clientePremiacion = clientePremiacion;
  }
  
  public ClientePremiacionConcurso getClienteConcurso() {
    return this.clienteConcurso;
  }
  
  public void setClienteConcurso(ClientePremiacionConcurso clienteConcurso) {
    this.clienteConcurso = clienteConcurso;
  }
  
  public Long getOidNivelPremiacion() {
    return this.oidNivelPremiacion;
  }
  
  public void setOidNivelPremiacion(Long oidNivelPremiacion) {
    this.oidNivelPremiacion = oidNivelPremiacion;
  }
  
  public Long getOidPeriodoControl() {
    return this.oidPeriodoControl;
  }
  
  public void setOidPeriodoControl(Long oidPeriodoControl) {
    this.oidPeriodoControl = oidPeriodoControl;
  }
  
  public Long getOidCabSol() {
    return this.oidCabSol;
  }
  
  public void setOidCabSol(Long oidCabSol) {
    this.oidCabSol = oidCabSol;
  }
  
  public Long getOidGanadora() {
    return this.oidGanadora;
  }
  
  public void setOidGanadora(Long oidGanadora) {
    this.oidGanadora = oidGanadora;
  }
  
}