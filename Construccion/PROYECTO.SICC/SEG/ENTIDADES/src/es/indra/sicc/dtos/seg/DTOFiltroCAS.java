package es.indra.sicc.dtos.seg;
import es.indra.sicc.util.DTOBelcorp;

public class DTOFiltroCAS extends DTOBelcorp 
{
  private Boolean bcanales;
  private Boolean baccesos;
  private Boolean bsubaccesos;

  public DTOFiltroCAS() {
  }

  public Boolean getBcanales()  {
    return bcanales;
  }

  public void setBcanales(Boolean newBcanales)  {
    bcanales = newBcanales;
  }

  public Boolean getBaccesos()  {
    return baccesos;
  }

  public void setBaccesos(Boolean newBaccesos)  {
    baccesos = newBaccesos;
  }

  public Boolean getBsubaccesos()  {
    return bsubaccesos;
  }

  public void setBsubaccesos(Boolean newBsubaccesos)  {
    bsubaccesos = newBsubaccesos;
  }


  
}