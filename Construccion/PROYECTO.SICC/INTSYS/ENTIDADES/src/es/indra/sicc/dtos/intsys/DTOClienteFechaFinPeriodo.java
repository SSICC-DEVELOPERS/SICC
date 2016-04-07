package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;


public class DTOClienteFechaFinPeriodo extends DTOAuditableSICC
{
  private Long oidCliente;
  private Date fechaHasta;
  private String codPeriodo;
  

  public DTOClienteFechaFinPeriodo()
  {
  }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }


  public Long getOidCliente() {
    return oidCliente;
  }
  
  public void setFechaHasta(Date newFechaHasta) {
    this.fechaHasta = newFechaHasta;
  }


  public Date getFechaHasta() {
    return fechaHasta;
  }
  
   public void setCodPeriodo(String newCodPeriodo){
      codPeriodo = newCodPeriodo;
  }

  public String getCodPeriodo() {
     return codPeriodo;
  }
  
  
}