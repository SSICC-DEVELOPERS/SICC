package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajePrograma extends DTOAuditableSICC 
{
  private String proceso;
  private String programaAsociado;

  public String getProceso()
  {
    return proceso;
  }

  public void setProceso(String newProceso)
  {
    proceso = newProceso;
  }

  public String getProgramaAsociado()
  {
    return programaAsociado;
  }

  public void setProgramaAsociado(String newProgramaAsociado)
  {
    programaAsociado = newProgramaAsociado;
  }
}