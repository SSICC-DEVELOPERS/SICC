package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
public class DTOParametrosConsultorasRanking extends DTOBelcorp {

  private Long oidParametrosConsultoras;
  private Long oidBaseCalculo;
  private Long oidTipoVenta;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  
  public DTOParametrosConsultorasRanking()
  {
  }
  
  public Long getOidParametrosConsultoras() {
    return oidParametrosConsultoras;
  }

  public void setOidParametrosConsultoras(Long oidParametrosConsultoras) {
    this.oidParametrosConsultoras = oidParametrosConsultoras;
  }
  
  public Long getOidBaseCalculo() {
    return oidBaseCalculo;
  }

  public void setOidBaseCalculo(Long oidBaseCalculo) {
    this.oidBaseCalculo = oidBaseCalculo;
  }

  public Long getOidTipoVenta() {
    return oidTipoVenta;
  }

  public void setOidTipoVenta(Long oidTipoVenta) {
    this.oidTipoVenta = oidTipoVenta;
  }

  public Long getOidPeriodoDesde() {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde) {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta() {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta) {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }
  
  
  
}