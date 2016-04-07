/* DTOSimulacionLiquidacion.java  
 *
 * Created on 4 de marzo de 2005, 1:21 PM		
 */
 
package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 *
 * @author  Sergio Platas
 */

public class DTOSimulacionLiquidacion extends DTOAuditableSICC 
{
  private Boolean simulacion;
  private DTOSimulacionComisiones[] liquidaciones;

  public Boolean getSimulacion()
  {
    return simulacion;
  }

  public void setSimulacion(Boolean simulacion)
  {
    this.simulacion = simulacion;
  }

  public DTOSimulacionComisiones[] getLiquidaciones()
  {
    return liquidaciones;
  }

  public void setLiquidaciones(DTOSimulacionComisiones[] liquidaciones)
  {
    this.liquidaciones = liquidaciones;
  }
}