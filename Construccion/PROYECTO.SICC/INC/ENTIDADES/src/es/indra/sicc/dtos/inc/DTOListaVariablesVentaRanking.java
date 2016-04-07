package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaVariablesVentaRanking extends DTOBelcorp 
{
  private ArrayList listaVariables; //DTOVariablesVentaRankingConcurso[]

  public DTOListaVariablesVentaRanking()
  {
  }

  public ArrayList getListaVariables()
  {
    return listaVariables;
  }

  public void setListaVariables(ArrayList listaVariables)
  {
    this.listaVariables = listaVariables;
  }
}