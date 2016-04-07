package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionCantidades extends DTOAuditableSICC {

    private Long unidadesDemandadas;
    private Boolean limiteVenta;
    private Boolean controlStock;
    private Boolean controlLiquidacion;
    private Long unidadesPorAtender;
    private Long unidadesComprometidas;
    private Long unidadesAtendidas;


  public void setUnidadesDemandadas(Long unidadesDemandadas)
  {
    this.unidadesDemandadas = unidadesDemandadas;
  }


  public Long getUnidadesDemandadas()
  {
    return unidadesDemandadas;
  }


  public void setLimiteVenta(Boolean limiteVenta)
  {
    this.limiteVenta = limiteVenta;
  }


  public Boolean getLimiteVenta()
  {
    return limiteVenta;
  }


  public void setControlStock(Boolean controlStock)
  {
    this.controlStock = controlStock;
  }


  public Boolean getControlStock()
  {
    return controlStock;
  }


  public void setControlLiquidacion(Boolean controlLiquidacion)
  {
    this.controlLiquidacion = controlLiquidacion;
  }


  public Boolean getControlLiquidacion()
  {
    return controlLiquidacion;
  }


  public void setUnidadesPorAtender(Long unidadesPorAtender)
  {
    this.unidadesPorAtender = unidadesPorAtender;
  }


  public Long getUnidadesPorAtender()
  {
    return unidadesPorAtender;
  }


  public void setUnidadesComprometidas(Long unidadesComprometidas)
  {
    this.unidadesComprometidas = unidadesComprometidas;
  }


  public Long getUnidadesComprometidas()
  {
    return unidadesComprometidas;
  }


  public void setUnidadesAtendidas(Long unidadesAtendidas)
  {
    this.unidadesAtendidas = unidadesAtendidas;
  }


  public Long getUnidadesAtendidas()
  {
    return unidadesAtendidas;
  }
    
}