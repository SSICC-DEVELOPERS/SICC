package es.indra.sicc.dtos.car;
import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosCalculo extends DTOBelcorp  {
  private Long oid;
  private Long nivelRiesgo;
  private Long valTope;
  private Long valFactorCalculo;
  private String indVariacionLineaCredito;

  public DTOParametrosCalculo() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getNivelRiesgo() {
    return nivelRiesgo;
  }

  public void setNivelRiesgo(Long nivelRiesgo) {
    this.nivelRiesgo = nivelRiesgo;
  }

  public Long getValTope() {
    return valTope;
  }

  public void setValTope(Long valTope) {
    this.valTope = valTope;
  }

  public Long getValFactorCalculo() {
    return valFactorCalculo;
  }

  public void setValFactorCalculo(Long valFactorCalculo) {
    this.valFactorCalculo = valFactorCalculo;
  }

  public String getIndVariacionLineaCredito() {
    return indVariacionLineaCredito;
  }

  public void setIndVariacionLineaCredito(String indVariacionLineaCredito) {
    this.indVariacionLineaCredito = indVariacionLineaCredito;
  }
}