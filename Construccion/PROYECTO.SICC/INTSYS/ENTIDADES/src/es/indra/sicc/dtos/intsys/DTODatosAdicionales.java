package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosAdicionales extends DTOAuditableSICC 
{
   private Long oidCliente;
   private String codPeriodo;
   private String codAcceso;
   private String codAtributo11;
   private String valorAtributo11;
   private String codAtributo12;
   private String valorAtributo12;
  
  
  public DTODatosAdicionales()
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
  public void setCodAtributo11(String newCodAtributo11){
      codAtributo11 = newCodAtributo11;
  }

  public String getCodAtributo11() {
     return codAtributo11;
  }
  public void setValorAtributo11(String newValorAtributo11){
      valorAtributo11= newValorAtributo11;
  }

  public String getValorAtributo11() {
     return valorAtributo11;
  }
  public void setCodAtributo12(String newCodAtributo12){
      codAtributo12 = newCodAtributo12;
  }

  public String getCodAtributo12() {
     return codAtributo12;
  }
  public void setValorAtributo12(String newValorAtributo12){
      valorAtributo12 = newValorAtributo12;
  }

  public String getValorAtributo12() {
     return valorAtributo12;
  }
  
}