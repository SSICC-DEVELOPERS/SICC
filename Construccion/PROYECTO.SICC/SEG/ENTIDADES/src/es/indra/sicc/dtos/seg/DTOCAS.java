package es.indra.sicc.dtos.seg;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCAS extends DTOBelcorp
{
  private RecordSet Canales;
  private RecordSet Accesos;
  private RecordSet Subaccesos;

  public DTOCAS()  {
  }

  public RecordSet getCanales()  {
    return Canales;
  }

  public void setCanales(RecordSet newCanales)  {
    Canales = newCanales;
  }

  public RecordSet getAccesos()  {
    return Accesos;
  }

  public void setAccesos(RecordSet newAccesos)  {
    Accesos = newAccesos;
  }

  public RecordSet getSubaccesos()  {
    return Subaccesos;
  }

  public void setSubaccesos(RecordSet newSubaccesos)  {
    Subaccesos = newSubaccesos;
  }
}