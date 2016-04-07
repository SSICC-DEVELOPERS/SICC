package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOApplet extends DTOAuditableSICC {
  private Object dto;
  private String userName;

  public Object getDto()
  {
    return dto;
  }

  public void setDto(Object dto)
  {
    this.dto = dto;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}