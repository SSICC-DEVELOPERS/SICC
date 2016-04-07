/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOBusquedaAccesosPlantilla
 * Fecha:             08/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334
 * Descripcion:       DTOBusquedaAccesosPlantilla
 * @version           1.0
 * @autor             Marta Aurora Montiel
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOBusquedaAccesosPlantilla extends DTOAuditableSICC 
{
  public Long codigo;
  public Long oidCanal;

  public DTOBusquedaAccesosPlantilla()
  {
  }

  public Long getCodigo()
  {
    return codigo;
  }

  public void setCodigo(Long codigo)
  {
    this.codigo = codigo;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }
}