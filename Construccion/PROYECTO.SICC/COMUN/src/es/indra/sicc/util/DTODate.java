package es.indra.sicc.util;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;

public class DTODate extends DTOAuditableSICC
{
  private Date fecha;

  public DTODate()
  {
  }

  public Date getFecha()
  {
    return fecha;
  }

  public void setFecha(Date fecha)
  {
    this.fecha = fecha;
  }
  
  
}