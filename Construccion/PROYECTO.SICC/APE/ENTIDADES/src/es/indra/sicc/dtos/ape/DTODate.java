package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;
public class DTODate extends DTOSiccPaginacion{
  private Date fecha;
  public DTODate() { }
  public Date getFecha() { return fecha; }
  public void setFecha(Date fecha) { this.fecha = fecha; }  
}