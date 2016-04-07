package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarNumConcurso extends DTOBelcorp {
  private Integer indActivo;
  private Integer indRanking;

  public DTOBuscarNumConcurso() {
  }

  public Integer getIndActivo() {
    return indActivo;
  }

  public void setIndActivo(Integer indActivo) {
    this.indActivo = indActivo;
  }

  public Integer getIndRanking() {
    return indRanking;
  }

  public void setIndRanking(Integer indRanking) {
    this.indRanking = indRanking;
  }
}