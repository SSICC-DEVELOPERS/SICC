/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOPlantillaDetalle
 * Fecha:             08/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334
 * Descripcion:       DTOPlantillaDetalle
 * @version           1.0
 * @autor             Marta Aurora Montiel
 */
package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.Date;

public class DTOPlantillaDetalle extends DTOAuditableSICC 
{
  public Long oidPlantilla;
  public Long codPlantilla;
  public String descripcion; 
  public Long oidCanal;
  public String estado;
  public String canal;
  public Date fechaUltimoEstado;
  public Long[] arrayPais;
  public Long[] arrayAcceso;
  public Long[] arrayMarca;
  public Long oidTipoComision;
  public String comparativo;  
  public String tratamientoDiferencial;
  public DTOI18nSICC[] attriTraducible;
    
  
  public DTOPlantillaDetalle()
  {
  }

  public Long[] getArrayAcceso()
  {
    return arrayAcceso;
  }

  public void setArrayAcceso(Long[] arrayAcceso)
  {
    this.arrayAcceso = arrayAcceso;
  }

  public Long[] getArrayMarca()
  {
    return arrayMarca;
  }

  public void setArrayMarca(Long[] arrayMarca)
  {
    this.arrayMarca = arrayMarca;
  }

  public Long[] getArrayPais()
  {
    return arrayPais;
  }

  public void setArrayPais(Long[] arrayPais)
  {
    this.arrayPais = arrayPais;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getCodPlantilla()
  {
    return codPlantilla;
  }

  public void setCodPlantilla(Long codPlantilla)
  {
    this.codPlantilla = codPlantilla;
  }

  public String getComparativo()
  {
    return comparativo;
  }

  public void setComparativo(String comparativo)
  {
    this.comparativo = comparativo;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }
  
  public String getCanal()
  {
    return canal;
  }

  public void setCanal(String canal)
  {
    this.canal = canal;
  }

  public String getEstado()
  {
    return estado;
  }

  public void setEstado(String estado)
  {
    this.estado = estado;
  }

  public Date getFechaUltimoEstado()
  {
    return fechaUltimoEstado;
  }

  public void setFechaUltimoEstado(Date fechaUltimoEstado)
  {
    this.fechaUltimoEstado = fechaUltimoEstado;
  }
  
  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }

  public Long getOidTipoComision()
  {
    return oidTipoComision;
  }

  public void setOidTipoComision(Long oidTipoComision)
  {
    this.oidTipoComision = oidTipoComision;
  }

  public String getTratamientoDiferencial()
  {
    return tratamientoDiferencial;
  }

  public void setTratamientoDiferencial(String tratamientoDiferencial)
  {
    this.tratamientoDiferencial = tratamientoDiferencial;
  }
  
   public void setAttriTraducible(DTOI18nSICC[] newAttriTraducible) {
        attriTraducible = newAttriTraducible;
    }
  
   public DTOI18nSICC[] getAttriTraducible() {
        return attriTraducible;
    }
  
}