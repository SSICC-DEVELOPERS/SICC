package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUsuario extends DTOAuditableSICC 
{
  private String idUsuario;
  private String paisDefecto;
  private String pais;

  public DTOUsuario()
  {
  }

  public String getIdUsuario()
  {
    return idUsuario;
  }

  public void setIdUsuario(String newIdUsuario)
  {
    idUsuario = newIdUsuario;
  }

  public String getPaisDefecto()
  {
    return paisDefecto;
  }

  public void setPaisDefecto(String newPaisDefecto)
  {
    paisDefecto = newPaisDefecto;
  }

  public String getPais()
  {
    return pais;
  }

  public void setPais(String newPais)
  {
    pais = newPais;
  }
}