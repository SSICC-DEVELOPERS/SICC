/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTODatosComision
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTODatosComision
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTODatosComision extends DTOAuditableSICC 
{
  private Long oidComision;
  private Long oidCanal;
  private Long oidMarcaPlantilla;
  private ArrayList productos;

  public DTODatosComision()
  {
  }

  public Long getOidComision()
  {
    return oidComision;
  }

  public void setOidComision(Long oidComision)
  {
    this.oidComision = oidComision;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarcaPlantilla()
  {
    return oidMarcaPlantilla;
  }

  public void setOidMarcaPlantilla(Long oidMarcaPlantilla)
  {
    this.oidMarcaPlantilla = oidMarcaPlantilla;
  }

  public ArrayList getProductos()
  {
    return productos;
  }

  public void setProductos(ArrayList productos)
  {
    this.productos = productos;
  }
}