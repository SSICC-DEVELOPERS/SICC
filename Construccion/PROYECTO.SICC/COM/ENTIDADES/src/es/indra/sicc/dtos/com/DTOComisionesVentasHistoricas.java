/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesVentasHistoricas
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTOComisionesVentasHistoricas
 * @version           1.0
 * @autor             Carlos Leal
 */
package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOComisionesVentasHistoricas extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidComisiones;
  private BigDecimal porcentajeIncremento;
  private BigDecimal montoIncremento;
  private Boolean devoluciones;
  private Boolean anulaciones;
    private Long oidPeriodoFinal;
    private Long oidPeriodoInicio;

  public DTOComisionesVentasHistoricas()
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

  public BigDecimal getPorcentajeIncremento()
  {
    return porcentajeIncremento;
  }

  public void setPorcentajeIncremento(BigDecimal porcentajeIncremento)
  {
    this.porcentajeIncremento = porcentajeIncremento;
  }

  public BigDecimal getMontoIncremento()
  {
    return montoIncremento;
  }

  public void setMontoIncremento(BigDecimal montoIncremento)
  {
    this.montoIncremento = montoIncremento;
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

    public Long getOidPeriodoFinal()
    {
        return oidPeriodoFinal;
    }

    public void setOidPeriodoFinal(Long oidPeriodoFinal)
    {
        this.oidPeriodoFinal = oidPeriodoFinal;
    }

    public Long getOidPeriodoInicio()
    {
        return oidPeriodoInicio;
    }

    public void setOidPeriodoInicio(Long oidPeriodoInicio)
    {
        this.oidPeriodoInicio = oidPeriodoInicio;
    }
}