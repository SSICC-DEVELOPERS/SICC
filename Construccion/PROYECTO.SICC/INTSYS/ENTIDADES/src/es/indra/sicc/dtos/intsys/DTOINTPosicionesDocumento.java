package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTPosicionesDocumento extends DTOBelcorp  {
  private String codigoItem;
  private String unidadesPorAtender;
  private String indicadorDentroFueraCaja;

  public DTOINTPosicionesDocumento() {
  }

  public String getCodigoItem() {
    return codigoItem;
  }

  public void setCodigoItem(String codigoItem) {
    this.codigoItem = codigoItem;
  }

  public String getUnidadesPorAtender() {
    return unidadesPorAtender;
  }

  public void setUnidadesPorAtender(String unidadesPorAtender) {
    this.unidadesPorAtender = unidadesPorAtender;
  }

  public String getIndicadorDentroFueraCaja() {
    return indicadorDentroFueraCaja;
  }

  public void setIndicadorDentroFueraCaja(String indicadorDentroFueraCaja) {
    this.indicadorDentroFueraCaja = indicadorDentroFueraCaja;
  }
}