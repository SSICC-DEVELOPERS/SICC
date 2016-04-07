/* DTOEBuscarCobranzaExterna.java  
 *
 * Created on 3 de marzo de 2005, 5:49 PM		
 */
 
package es.indra.sicc.dtos.cob;

/**
 *
 * @author  Sergio Platas
 */

public class DTOEBuscarCobranzaExterna extends DTOEBuscarHistoricoCobranza 
{
  protected Long usuarioCobranza;
  protected Long grupoUsuarioCobranza;
  protected Long tipoCargo;
  protected String etapasDeuda;

  public Long getUsuarioCobranza()
  {
    return usuarioCobranza;
  }

  public void setUsuarioCobranza(Long usuarioCobranza)
  {
    this.usuarioCobranza = usuarioCobranza;
  }

  public Long getGrupoUsuarioCobranza()
  {
    return grupoUsuarioCobranza;
  }

  public void setGrupoUsuarioCobranza(Long grupoUsuarioCobranza)
  {
    this.grupoUsuarioCobranza = grupoUsuarioCobranza;
  }

  public Long getTipoCargo()
  {
    return tipoCargo;
  }

  public void setTipoCargo(Long tipoCargo)
  {
    this.tipoCargo = tipoCargo;
  }

  public String getEtapasDeuda()
  {
    return etapasDeuda;
  }

  public void setEtapasDeuda(String etapasDeuda)
  {
    this.etapasDeuda = etapasDeuda;
  }
}