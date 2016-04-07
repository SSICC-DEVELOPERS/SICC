package es.indra.sicc.dtos.prueba;

import java.io.Serializable;

public class DTOObtenerCargaInicial extends DTOAbstractoApplet implements Serializable{
  private String user;
  private Long oidPais;

  public String getUser()
  {
    return user;
  }

  public void setUser(String user)
  {
    this.user = user;
  }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

}