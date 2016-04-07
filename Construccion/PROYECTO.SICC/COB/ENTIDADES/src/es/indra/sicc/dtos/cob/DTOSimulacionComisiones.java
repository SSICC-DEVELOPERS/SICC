/* DTOSimulacionComisiones  
 *
 * Created on 4 de marzo de 2005, 1:17 PM		
 */
 
package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author  Sergio Platas
 */

public class DTOSimulacionComisiones extends DTOAuditableSICC 
{
  private Long oidUsuario;
  private Long oidLiquidacion;
  private Long oidBaseEscala;
  private Long oidEtapa;
  private Long oidPeriodo;
  private Float rangoDesde;
  private Float rangoHasta;
  private BigDecimal importeDesde;
  private BigDecimal importeHasta;
  private Float comisionPorc;
  private BigDecimal comisionImporte;
  private BigDecimal importeDeuCancelada;
  private BigDecimal importeDeuAsignada;
  private String idLiquidacion;
  private Date fechaCalculo;
  private String metodoLiquidacion;
  private Long oidMetodoLiquidacion;
  private String codigoUsuario;
  private String etapa;
  private String marca;
  private String canal;
  private BigDecimal comisionCalculada;
  private String periodo;
  private String codCliente;
  private String idLiquidacionDesc;
  private BigDecimal importeDeuAsignadaEtapaAnt;

  public Long getOidUsuario()
  {
    return oidUsuario;
  }

  public void setOidUsuario(Long oidUsuario)
  {
    this.oidUsuario = oidUsuario;
  }

  public Long getOidLiquidacion()
  {
    return oidLiquidacion;
  }

  public void setOidLiquidacion(Long oidLiquidacion)
  {
    this.oidLiquidacion = oidLiquidacion;
  }

  public Long getOidBaseEscala()
  {
    return oidBaseEscala;
  }

  public void setOidBaseEscala(Long oidBaseEscala)
  {
    this.oidBaseEscala = oidBaseEscala;
  }

  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Float getRangoDesde()
  {
    return rangoDesde;
  }

  public void setRangoDesde(Float rangoDesde)
  {
    this.rangoDesde = rangoDesde;
  }

  public Float getRangoHasta()
  {
    return rangoHasta;
  }

  public void setRangoHasta(Float rangoHasta)
  {
    this.rangoHasta = rangoHasta;
  }

  public BigDecimal getImporteDesde()
  {
    return importeDesde;
  }

  public void setImporteDesde(BigDecimal importeDesde)
  {
    this.importeDesde = importeDesde;
  }

  public BigDecimal getImporteHasta()
  {
    return importeHasta;
  }

  public void setImporteHasta(BigDecimal importeHasta)
  {
    this.importeHasta = importeHasta;
  }

  public Float getComisionPorc()
  {
    return comisionPorc;
  }

  public void setComisionPorc(Float comisionPorc)
  {
    this.comisionPorc = comisionPorc;
  }

  public BigDecimal getComisionImporte()
  {
    return comisionImporte;
  }

  public void setComisionImporte(BigDecimal comisionImporte)
  {
    this.comisionImporte = comisionImporte;
  }

  public BigDecimal getImporteDeuCancelada()
  {
    return importeDeuCancelada;
  }

  public void setImporteDeuCancelada(BigDecimal importeDeuCancelada)
  {
    this.importeDeuCancelada = importeDeuCancelada;
  }

  public BigDecimal getImporteDeuAsignada()
  {
    return importeDeuAsignada;
  }

  public void setImporteDeuAsignada(BigDecimal importeDeuAsignada)
  {
    this.importeDeuAsignada = importeDeuAsignada;
  }

  public String getIdLiquidacion()
  {
    return idLiquidacion;
  }

  public void setIdLiquidacion(String idLiquidacion)
  {
    this.idLiquidacion = idLiquidacion;
  }

  public Date getFechaCalculo()
  {
    return fechaCalculo;
  }

  public void setFechaCalculo(Date fechaCalculo)
  {
    this.fechaCalculo = fechaCalculo;
  }

  public String getMetodoLiquidacion()
  {
    return metodoLiquidacion;
  }

  public void setMetodoLiquidacion(String metodoLiquidacion)
  {
    this.metodoLiquidacion = metodoLiquidacion;
  }

  public Long getOidMetodoLiquidacion()
  {
    return oidMetodoLiquidacion;
  }

  public void setOidMetodoLiquidacion(Long oidMetodoLiquidacion)
  {
    this.oidMetodoLiquidacion = oidMetodoLiquidacion;
  }

  public String getCodigoUsuario()
  {
    return codigoUsuario;
  }

  public void setCodigoUsuario(String codigoUsuario)
  {
    this.codigoUsuario = codigoUsuario;
  }

  public String getEtapa()
  {
    return etapa;
  }

  public void setEtapa(String etapa)
  {
    this.etapa = etapa;
  }

  public String getMarca()
  {
    return marca;
  }

  public void setMarca(String marca)
  {
    this.marca = marca;
  }

  public String getCanal()
  {
    return canal;
  }

  public void setCanal(String canal)
  {
    this.canal = canal;
  }

  public BigDecimal getComisionCalculada()
  {
    return comisionCalculada;
  }

  public void setComisionCalculada(BigDecimal comisionCalculada)
  {
    this.comisionCalculada = comisionCalculada;
  }





  public String getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(String periodo)
  {
    this.periodo = periodo;
  }

  public String getCodCliente()
  {
    return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
    this.codCliente = codCliente;
  }

  public String getIdLiquidacionDesc()
  {
    return idLiquidacionDesc;
  }

  public void setIdLiquidacionDesc(String idLiquidacionDesc)
  {
    this.idLiquidacionDesc = idLiquidacionDesc;
  }

  public BigDecimal getImporteDeuAsignadaEtapaAnt()
  {
    return importeDeuAsignadaEtapaAnt;
  }

  public void setImporteDeuAsignadaEtapaAnt(BigDecimal importeDeuAsignadaEtapaAnt)
  {
    this.importeDeuAsignadaEtapaAnt = importeDeuAsignadaEtapaAnt;
  }
}