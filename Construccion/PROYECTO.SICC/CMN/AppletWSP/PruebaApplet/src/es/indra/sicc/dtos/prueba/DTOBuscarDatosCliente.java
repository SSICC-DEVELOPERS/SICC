package es.indra.sicc.dtos.prueba;

import java.io.Serializable;

public class DTOBuscarDatosCliente extends DTOAbstractoApplet implements Serializable{
  private String oidPais;
  private Long codClie;

  public String getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(String oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getCodClie()
  {
    return codClie;
  }

  public void setCodClie(Long codClie)
  {
    this.codClie = codClie;
  }

}