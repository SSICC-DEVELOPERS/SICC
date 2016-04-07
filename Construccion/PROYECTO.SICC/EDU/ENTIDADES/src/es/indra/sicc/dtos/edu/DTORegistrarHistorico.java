package es.indra.sicc.dtos.edu;
import es.indra.sicc.util.DTOBelcorp;

public class DTORegistrarHistorico extends DTOBelcorp 
{
  private DTOParticipante[] validos;
  private Long oidCurso;
  private Long oidTipoCurso;

  public DTORegistrarHistorico()
  {
  }

 
  public DTOParticipante[] getValidos()
  {
    return validos;
  }

  public void setValidos(DTOParticipante[] validos)
  {
    this.validos = validos;
  }

  public Long getOidCurso()
  {
    return oidCurso;
  }

  public void setOidCurso(Long oidCurso)
  {
    this.oidCurso = oidCurso;
  }
  
   public Long getOidTipoCurso()
  {
    return oidTipoCurso;
  }

  public void setOidTipoCurso(Long oidTipoCurso)
  {
    this.oidTipoCurso = oidTipoCurso;
  }
}