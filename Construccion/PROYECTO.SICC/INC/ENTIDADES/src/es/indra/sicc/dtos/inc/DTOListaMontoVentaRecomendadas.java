package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaMontoVentaRecomendadas extends DTOBelcorp 
{
  private ArrayList montosVenta; //DTOMontoVentaRecomendadas

  public ArrayList getMontosVenta()
  {
    return montosVenta;
  }

  public void setMontosVenta(ArrayList montosVenta)
  {
    this.montosVenta = montosVenta;
  }
}