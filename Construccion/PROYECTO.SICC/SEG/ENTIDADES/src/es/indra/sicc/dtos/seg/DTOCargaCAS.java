package es.indra.sicc.dtos.seg;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCargaCAS extends DTOBelcorp
{
  private DTOFiltroCAS filtro;
  private DTOFiltroCAS todos;

  public DTOCargaCAS()  {
  }

  public DTOFiltroCAS getFiltro()  {
    return filtro;
  }

  public void setFiltro(DTOFiltroCAS newFiltro)  {
    filtro = newFiltro;
  }

  public DTOFiltroCAS getTodos()  {
    return todos;
  }

  public void setTodos(DTOFiltroCAS newTodos)  {
    todos = newTodos;
  }


  
}