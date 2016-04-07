package es.indra.sicc.comunapplet.dtos.applet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.exception.MareException;

public class DTOException extends DTOAuditableSICC
{
  private MareException exception;
  private String descripcion;
  private int codigo;
  
  public DTOException()
  {
  }

  public MareException getException()
  {
    return exception;
  }

  public void setException(MareException exception)
  {
    this.exception = exception;
  }
  
  public void setDescripcion(String d) 
  {
    this.descripcion = d;
  }
  
  public String getDescripcion() 
  {
    return this.descripcion;
  }
  
  public void setCodigo(int i) 
  {
    this.codigo = i;
  }
  
  public int getCodigo() 
  {
    return this.codigo;
  }
}