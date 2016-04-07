/* DTOUsuariosCobComboPerfil
 *
 * Created on 4 de marzo de 2005, 1:25 PM		
 */
 
package es.indra.sicc.dtos.cob;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 *
 * @author  Sergio Platas
 */
 
public class DTOUsuariosCobComboPerfil extends DTOAuditableSICC 
{
  private Long tipoUsuario;
  private RecordSet usuarios;

  public Long getTipoUsuario()
  {
    return tipoUsuario;
  }

  public void setTipoUsuario(Long tipoUsuario)
  {
    this.tipoUsuario = tipoUsuario;
  }

  public RecordSet getUsuarios()
  {
    return usuarios;
  }

  public void setUsuarios(RecordSet usuarios)
  {
    this.usuarios = usuarios;
  }
}