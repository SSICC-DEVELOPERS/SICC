/* DTOEBuscarCompromisosPago.java  
 *
 * Created on 3 de marzo de 2005, 6:07 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 *
 * @author  Sergio Platas
 */
 
public class DTOEBuscarCompromisosPago extends DTOSiccPaginacion 
{
  private Long oidGestionCobranza;
  private Boolean paginado;

  public Long getOidGestionCobranza()
  {
    return oidGestionCobranza;
  }

  public void setOidGestionCobranza(Long oidGestionCobranza)
  {
    this.oidGestionCobranza = oidGestionCobranza;
  }

  public Boolean getPaginado()
  {
    return paginado;
  }

  public void setPaginado(Boolean paginado)
  {
    this.paginado = paginado;
  }
}