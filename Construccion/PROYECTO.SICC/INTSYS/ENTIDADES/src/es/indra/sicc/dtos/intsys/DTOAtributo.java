package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOAtributo extends DTOAuditableSICC 
{
  
  private Long oidCliente;
  private String codAcceso;
  private String codPeriodo;
  private String codAtributo;
  private String valorAtributo;
  
  public DTOAtributo()
  {
  }
  
   public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }


  public Long getOidCliente() {
    return oidCliente;
  }
  
  public void setCodAcceso(String newCodAcceso){
      codAcceso = newCodAcceso;
  }

  public String getCodAcceso() {
     return codAcceso;
  }
  
  public void setCodPeriodo(String newCodPeriodo){
      codPeriodo = newCodPeriodo;
  }

  public String getCodPeriodo() {
     return codPeriodo;
  }
  
  public void setCodAtributo(String newCodAtributo){
      codAtributo = newCodAtributo;
  }

  public String getCodAtributo() {
     return codAtributo;
  }
  
  public void setValorAtributo(String newValorAtributo){
      valorAtributo = newValorAtributo;
  }

  public String getValorAtributo() {
     return valorAtributo;
  }  
}