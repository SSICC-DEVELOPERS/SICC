package es.indra.sicc.dtos.car;
import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosEvaluacionNR extends DTOBelcorp  {
  private Long codigoParametro;
  private Long valPeso;
  private Long valEscalaMinima;
  private Long valMinimo;
  private Long valMaximo;

  public DTOParametrosEvaluacionNR() {
  }

  public Long getCodigoParametro() {
    return codigoParametro;
  }

  public void setCodigoParametro(Long codigoParametro) {
    this.codigoParametro = codigoParametro;
  }

  public Long getValPeso() {
    return valPeso;
  }

  public void setValPeso(Long valPeso) {
    this.valPeso = valPeso;
  }

  public Long getValEscalaMinima() {
    return valEscalaMinima;
  }

  public void setValEscalaMinima(Long valEscalaMinima) {
    this.valEscalaMinima = valEscalaMinima;
  }

  public Long getValMinimo() {
    return valMinimo;
  }

  public void setValMinimo(Long valMinimo) {
    this.valMinimo = valMinimo;
  }

  public Long getValMaximo() {
    return valMaximo;
  }

  public void setValMaximo(Long valMaximo) {
    this.valMaximo = valMaximo;
  }
}