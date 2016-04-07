package es.indra.sicc.cmn.negocio.batch;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;
/**
 * @author SCS
 */
public class DTOConsolaBatch extends DTOSiccPaginacion 
{
  private String codProc;
  private Date fechaDesde;
  private Date fechaHasta;
  private Long estatus;
  private boolean usuario;

  public DTOConsolaBatch()
  {
  }
  
  public String getCodProc() {
    return codProc;
  }
  public void setCodProc(String newCodProc) {
    codProc = newCodProc;
  }
  
  public Date getFechaDesde()
  {
    return fechaDesde;
  }

  public void setFechaDesde(Date fechaDesde)
  {
    this.fechaDesde = fechaDesde;
  }

  public Date getFechaHasta()
  {
    return fechaHasta;
  }

  public void setFechaHasta(Date fechaHasta)
  {
    this.fechaHasta = fechaHasta;
  }

  public boolean getUsuario()
  {
    return usuario;
  }

  public void setUsuario(boolean usuario)
  {
    this.usuario = usuario;
  }

  public Long getEstatus()
  {
    return estatus;
  }

  public void setEstatus(Long estatus)
  {
    this.estatus = estatus;
  }
  
}