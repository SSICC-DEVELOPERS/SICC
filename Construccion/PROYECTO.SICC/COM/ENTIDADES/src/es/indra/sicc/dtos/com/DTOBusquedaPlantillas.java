/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOBusquedaPlantillas
 * Fecha:             08/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334
 * Descripcion:       DTOBusquedaPlantillas
 * @version           1.0
 * @autor             Marta Aurora Montiel
 */
package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBusquedaPlantillas extends DTOSiccPaginacion 
{
  public Long codPlantilla;
  public String descripcion;
  public Long oidMarca;
  public Long oidCanal;
  public Long oidAcceso;
  public Long oidEstado;
  private Long oidPaisPlanti;
  
  public DTOBusquedaPlantillas()
  {
  }

  public Long getCodPlantilla()
  {
    return codPlantilla;
  }

  public void setCodPlantilla(Long codPlantilla)
  {
    this.codPlantilla = codPlantilla;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidEstado()
  {
    return oidEstado;
  }

  public void setOidEstado(Long oidEstado)
  {
    this.oidEstado = oidEstado;
  }

  public Long getOidPaisPlanti()
  {
    return oidPaisPlanti;
  }

  public void setOidPaisPlanti(Long oidPaisPlanti)
  {
    this.oidPaisPlanti = oidPaisPlanti;
  }


}