package es.indra.sicc.dtos.intsys;

public class DTOEnvioInterfacesIVR extends DTOEINTIVR  {
  private Long[] interfaces;

  public DTOEnvioInterfacesIVR() {
  }

  public Long[] getInterfaces() {
    return interfaces;
  }

  public void setInterfaces(Long[] interfaces) {
    this.interfaces = interfaces;
  }
}
