package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;



public class DTONivelesPremiacion extends DTOBelcorp 
{
  private DTONivelPremiacion[] listaNiveles; 
  private Integer numeroPremioMax;

  public DTONivelesPremiacion()
  {
  }

  public DTONivelPremiacion[] getListaNiveles()
  {
    return listaNiveles;
  }

  public void setListaNiveles(DTONivelPremiacion[] listaNiveles)
  {
    this.listaNiveles = listaNiveles;
  }

  public Integer getNumeroPremioMax() {
    return numeroPremioMax;
  }

  public void setNumeroPremioMax(Integer numeroPremioMax) {
    this.numeroPremioMax = numeroPremioMax;
  }
}