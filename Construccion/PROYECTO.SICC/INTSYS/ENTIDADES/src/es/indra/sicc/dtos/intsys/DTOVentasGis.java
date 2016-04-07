package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOVentasGis extends DTOAuditableSICC 
{
   private Long oidCliente;
   private String codAcceso;
   private String codPeriodo;
   private String codAtributo2;
   private String valorAtributo2;
   private String codAtributo3;
   private String valorAtributo3; 
   private String codAtributo7;
   private String valorAtributo7;
   private String codAtributo8;
   private String valorAtributo8; 
   private String codAtributo9;
   private String valorAtributo9;
   private String codAtributo10;
   private String valorAtributo10;
  /*BELC300022766 
   * Se cambia el nombre de los atributos codAtributo4 y valAtributo4 por codAtributo3 y valAtributo3.
   */
  public DTOVentasGis()
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
  public void setCodAtributo2(String newCodAtributo2){
      codAtributo2 = newCodAtributo2;
  }

  public String getCodAtributo2() {
     return codAtributo2;
  }
  public void setValorAtributo2(String newValorAtributo2){
      valorAtributo2 = newValorAtributo2;
  }

  public String getValorAtributo2() {
     return valorAtributo2;
  }
  public void setCodAtributo3(String newCodAtributo3){
      codAtributo3 = newCodAtributo3;
  }

  public String getCodAtributo3() {
     return codAtributo3;
  }

  public void setCodAtributo7(String newCodAtributo7){
      codAtributo7 = newCodAtributo7;
  }

  public String getCodAtributo7() {
     return codAtributo7;
  }
  public void setValorAtributo7(String newValorAtributo7){
      valorAtributo7 = newValorAtributo7;
  }

  public String getValorAtributo7() {
     return valorAtributo7;
  }
  public void setCodAtributo8(String newCodAtributo8){
      codAtributo8 = newCodAtributo8;
  }

  public String getCodAtributo8() {
     return codAtributo8;
  }
  public void setValorAtributo8(String newValorAtributo8){
      valorAtributo8 = newValorAtributo8;
  }

  public String getValorAtributo8() {
     return valorAtributo8;
  }
  public void setCodAtributo9(String newCodAtributo9){
      codAtributo9 = newCodAtributo9;
  }

  public String getCodAtributo9() {
     return codAtributo9;
  }
  public void setValorAtributo9(String newValorAtributo9){
      valorAtributo9 = newValorAtributo9;
  }

  public String getValorAtributo9() {
     return valorAtributo9;
  }
  public void setCodAtributo10(String newCodAtributo10 ){
      codAtributo10 = newCodAtributo10;
  }

  public String getCodAtributo10() {
     return codAtributo10;
  }
  public void setValorAtributo10(String newValorAtributo10){
      valorAtributo10 = newValorAtributo10;
  }

  public String getValorAtributo10() {
     return valorAtributo10;
  } 


  public void setValorAtributo3(String valorAtributo3)
  {
    this.valorAtributo3 = valorAtributo3;
  }


  public String getValorAtributo3()
  {
    return valorAtributo3;
  }
  
}