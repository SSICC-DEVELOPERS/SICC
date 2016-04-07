package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOPremios extends DTOBelcorp 
{
  private ArrayList nivelesPremiacion;

  public ArrayList getNivelesPremiacion()
  {
    return nivelesPremiacion;
  }

  public void setNivelesPremiacion(ArrayList nivelesPremiacion)
  {
    this.nivelesPremiacion = nivelesPremiacion;
  }
}