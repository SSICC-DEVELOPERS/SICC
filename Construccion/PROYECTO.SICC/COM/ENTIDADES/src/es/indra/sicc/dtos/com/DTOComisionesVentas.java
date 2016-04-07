/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesVentas
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTOComisionesVentas
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOComisionesVentas extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidComisiones;
  private Boolean calculoIncobrables;
  private Boolean calculoIncobrablesFechaEmision;
  private Boolean calculoIncobrablesFechaVencimiento;
  private Integer diasIncobrables;
  private Boolean devoluciones;
  private Boolean anulaciones;
  private Boolean faltantesNoAnunciados;
  private BigDecimal porcentajeComision;
  private BigDecimal importeFijoComision;
  private Long oidTipoComisionVenta;
  private Long oidTipoComisionVentaIncremental;
  private Long oidFormula;

  public DTOComisionesVentas()
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

  public Boolean getCalculoIncobrables()
  {
    return calculoIncobrables;
  }

  public void setCalculoIncobrables(Boolean calculoIncobrables)
  {
    this.calculoIncobrables = calculoIncobrables;
  }

  public Boolean getCalculoIncobrablesFechaEmision()
  {
    return calculoIncobrablesFechaEmision;
  }

  public void setCalculoIncobrablesFechaEmision(Boolean calculoIncobrablesFechaEmision)
  {
    this.calculoIncobrablesFechaEmision = calculoIncobrablesFechaEmision;
  }

  public Boolean getCalculoIncobrablesFechaVencimiento()
  {
    return calculoIncobrablesFechaVencimiento;
  }

  public void setCalculoIncobrablesFechaVencimiento(Boolean calculoIncobrablesFechaVencimiento)
  {
    this.calculoIncobrablesFechaVencimiento = calculoIncobrablesFechaVencimiento;
  }

  public Integer getDiasIncobrables()
  {
    return diasIncobrables;
  }

  public void setDiasIncobrables(Integer diasIncobrables)
  {
    this.diasIncobrables = diasIncobrables;
  }

  public Boolean getDevoluciones()
  {
    return devoluciones;
  }

  public void setDevoluciones(Boolean devoluciones)
  {
    this.devoluciones = devoluciones;
  }

  public Boolean getAnulaciones()
  {
    return anulaciones;
  }

  public void setAnulaciones(Boolean anulaciones)
  {
    this.anulaciones = anulaciones;
  }

  public Boolean getFaltantesNoAnunciados()
  {
    return faltantesNoAnunciados;
  }

  public void setFaltantesNoAnunciados(Boolean faltantesNoAnunciados)
  {
    this.faltantesNoAnunciados = faltantesNoAnunciados;
  }

  public BigDecimal getPorcentajeComision()
  {
    return porcentajeComision;
  }

  public void setPorcentajeComision(BigDecimal porcentajeComision)
  {
    this.porcentajeComision = porcentajeComision;
  }

  public BigDecimal getImporteFijoComision()
  {
    return importeFijoComision;
  }

  public void setImporteFijoComision(BigDecimal importeFijoComision)
  {
    this.importeFijoComision = importeFijoComision;
  }

  public Long getOidTipoComisionVenta()
  {
    return oidTipoComisionVenta;
  }

  public void setOidTipoComisionVenta(Long oidTipoComisionVenta)
  {
    this.oidTipoComisionVenta = oidTipoComisionVenta;
  }

  public Long getOidTipoComisionVentaIncremental()
  {
    return oidTipoComisionVentaIncremental;
  }

  public void setOidTipoComisionVentaIncremental(Long oidTipoComisionVentaIncremental)
  {
    this.oidTipoComisionVentaIncremental = oidTipoComisionVentaIncremental;
  }

  public Long getOidFormula()
  {
    return oidFormula;
  }

  public void setOidFormula(Long oidFormula)
  {
    this.oidFormula = oidFormula;
  }
}