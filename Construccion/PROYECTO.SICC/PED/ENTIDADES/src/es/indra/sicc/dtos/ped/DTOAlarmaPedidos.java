package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOAlarmaPedidos extends DTOSiccPaginacion  {
  private Date fechaIni;
  private Date fechaFin;

  public DTOAlarmaPedidos() {
  }

  public Date getFechaIni() {
    return fechaIni;
  }

  public void setFechaIni(Date newFechaIni) {
    fechaIni = newFechaIni;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin) {
    fechaFin = newFechaFin;
  }
}