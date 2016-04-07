package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCodProducto extends DTOBelcorp  {

  private Long   oidProd;  
  private String codProd;

  public DTOCodProducto() {
  }


  public void setOidProd(Long oidProd) {
    this.oidProd = oidProd;
  }


  public Long getOidProd() {
    return oidProd;
  }


  public void setCodProd(String codProd) {
    this.codProd = codProd;
  }


  public String getCodProd() {
    return codProd;
  }


}