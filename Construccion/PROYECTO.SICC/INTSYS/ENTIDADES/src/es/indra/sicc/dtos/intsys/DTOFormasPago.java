package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOFormasPago extends DTOBelcorp  {

  private Long oidFP;  
  private String codFP;

  public DTOFormasPago() {
  }


  public void setOidFP(Long oidFP) {
    this.oidFP = oidFP;
  }


  public Long getOidFP() {
    return oidFP;
  }


  public void setCodFP(String codFP) {
    this.codFP = codFP;
  }


  public String getCodFP() {
    return codFP;
  }
}