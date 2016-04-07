/* DTOEscalaLiquidacion.java  
 *
 * Created on 4 de marzo de 2005, 1:14 PM		
 */


package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

/**
 *
 * @author  Sergio Platas
 */

public class DTOEscalaLiquidacion extends DTOAuditableSICC 
{
  private Long oidEscala;
  private Integer numeroOrden;
  private BigDecimal importeRangoDesde;
  private BigDecimal importeRangoHasta;
  private Float porcentajeRangoDesde;
  private Float porcentajeRangoHasta;
  private Float comisionPorcentaje;
  private Float comisionImporte;
  private String observaciones;
  private Long metodoLiquidacion;
  private Float porcentajeDeudaCancelada;

  public Long getOidEscala()
  {
    return oidEscala;
  }

  public void setOidEscala(Long oidEscala)
  {
    this.oidEscala = oidEscala;
  }

  public Integer getNumeroOrden()
  {
    return numeroOrden;
  }

  public void setNumeroOrden(Integer numeroOrden)
  {
    this.numeroOrden = numeroOrden;
  }

  public BigDecimal getImporteRangoDesde()
  {
    return importeRangoDesde;
  }

  public void setImporteRangoDesde(BigDecimal importeRangoDesde)
  {
    this.importeRangoDesde = importeRangoDesde;
  }

  public BigDecimal getImporteRangoHasta()
  {
    return importeRangoHasta;
  }

  public void setImporteRangoHasta(BigDecimal importeRangoHasta)
  {
    this.importeRangoHasta = importeRangoHasta;
  }

  public Float getPorcentajeRangoDesde()
  {
    return porcentajeRangoDesde;
  }

  public void setPorcentajeRangoDesde(Float porcentajeRangoDesde)
  {
    this.porcentajeRangoDesde = porcentajeRangoDesde;
  }

  public Float getPorcentajeRangoHasta()
  {
    return porcentajeRangoHasta;
  }

  public void setPorcentajeRangoHasta(Float porcentajeRangoHasta)
  {
    this.porcentajeRangoHasta = porcentajeRangoHasta;
  }

  public Float getComisionPorcentaje()
  {
    return comisionPorcentaje;
  }

  public void setComisionPorcentaje(Float comisionPorcentaje)
  {
    this.comisionPorcentaje = comisionPorcentaje;
  }

  public Float getComisionImporte()
  {
    return comisionImporte;
  }

  public void setComisionImporte(Float comisionImporte)
  {
    this.comisionImporte = comisionImporte;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Long getMetodoLiquidacion()
  {
    return metodoLiquidacion;
  }

  public void setMetodoLiquidacion(Long metodoLiquidacion)
  {
    this.metodoLiquidacion = metodoLiquidacion;
  }

  public Float getPorcentajeDeudaCancelada()
  {
    return porcentajeDeudaCancelada;
  }

  public void setPorcentajeDeudaCancelada(Float porcentajeDeudaCancelada)
  {
    this.porcentajeDeudaCancelada = porcentajeDeudaCancelada;
  }
}