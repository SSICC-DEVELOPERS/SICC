/* DTOUsuariosPerfil.java
 *
 * Created on 4 de marzo de 2005, 1:28 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.util.DTOBelcorp;

/**
 *
 * @author  Sergio Platas
 */
 
public class DTOUsuariosPerfil extends DTOBelcorp 
{
  private String loginUsuario;
  private Long oidUsuario;

  public String getLoginUsuario()
  {
    return loginUsuario;
  }

  public void setLoginUsuario(String loginUsuario)
  {
    this.loginUsuario = loginUsuario;
  }

  public Long getOidUsuario()
  {
    return oidUsuario;
  }

  public void setOidUsuario(Long oidUsuario)
  {
    this.oidUsuario = oidUsuario;
  }
}