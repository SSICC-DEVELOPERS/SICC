package es.indra.sicc.dtos.men;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOIdentUsuario extends DTOAuditableSICC
{
  private Long idUsuario;
	private String codUsuario;
	private String cadenaNombre;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
 
  public DTOIdentUsuario()
  {
  }


  public void setIdUsuario(Long idUsuario)
  {
    this.idUsuario = idUsuario;
  }


  public Long getIdUsuario()
  {
    return idUsuario;
  }


  public void setCodUsuario(String codUsuario)
  {
    this.codUsuario = codUsuario;
  }


  public String getCodUsuario()
  {
    return codUsuario;
  }


  public void setCadenaNombre(String cadenaNombre)
  {
    this.cadenaNombre = cadenaNombre;
  }


  public String getCadenaNombre()
  {
    return cadenaNombre;
  }
}