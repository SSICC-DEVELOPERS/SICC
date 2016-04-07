package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORecargaComisiones extends DTOAuditableSICC  {
  Long marca;
  Long canal;
  String periodos;
  
  public DTORecargaComisiones() { 
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long canal) {
    this.canal = canal;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long marca) {
    this.marca = marca;
  }

  public String getPeriodos() {
    return periodos;
  }

  public void setPeriodos(String periodos) {
    this.periodos = periodos;
  }
}