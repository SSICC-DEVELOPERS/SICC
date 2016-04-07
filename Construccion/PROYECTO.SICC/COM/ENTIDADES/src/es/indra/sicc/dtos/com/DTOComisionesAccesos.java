/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesAccesos
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTOComisionesAccesos
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOComisionesAccesos extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidComisiones;
  private Long oidPlantillaComisionesAccesos;

  public DTOComisionesAccesos()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidComisiones()
  {
    return oidComisiones;
  }

  public void setOidComisiones(Long oidComisiones)
  {
    this.oidComisiones = oidComisiones;
  }

  public Long getOidPlantillaComisionesAccesos()
  {
    return oidPlantillaComisionesAccesos;
  }

  public void setOidPlantillaComisionesAccesos(Long oidPlantillaComisionesAccesos)
  {
    this.oidPlantillaComisionesAccesos = oidPlantillaComisionesAccesos;
  }
}