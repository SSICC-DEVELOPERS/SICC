package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaMetasTipoVenta extends DTOBelcorp 
{
  private ArrayList listaMetas;

  public ArrayList getListaMetas()
  {
    return listaMetas;
  }

  public void setListaMetas(ArrayList listaMetas)
  {
    this.listaMetas = listaMetas;
  }
}