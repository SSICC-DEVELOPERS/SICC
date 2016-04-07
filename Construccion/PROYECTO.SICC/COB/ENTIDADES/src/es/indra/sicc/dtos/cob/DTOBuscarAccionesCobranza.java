/* DTOBuscarAccionesCobranza.java
 	 *
	 * Created on 3 de marzo de 2005, 5:38 PM
*/

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 *
 * @author  Sergio Platas
 */

public class DTOBuscarAccionesCobranza extends DTOSiccPaginacion 
{
  private Boolean paginacion;

  public Boolean getPaginacion()
  {
    return paginacion;
  }

  public void setPaginacion(Boolean paginacion)
  {
    this.paginacion = paginacion;
  }

}