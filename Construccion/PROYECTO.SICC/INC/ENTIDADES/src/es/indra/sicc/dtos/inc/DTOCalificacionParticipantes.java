package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOCalificacionParticipantes extends DTOBelcorp 
{
  private ArrayList lstCalificacionParticipantes;
  private ArrayList lstParticipantes;
  private Long oidDirigidoA;
  private Long oidConcurso;

  public ArrayList getLstCalificacionParticipantes()
  {
    return lstCalificacionParticipantes;
  }

  public void setLstCalificacionParticipantes(ArrayList lstCalificacionParticipantes)
  {
    this.lstCalificacionParticipantes = lstCalificacionParticipantes;
  }

  public ArrayList getLstParticipantes()
  {
    return lstParticipantes;
  }

  public void setLstParticipantes(ArrayList lstParticipantes)
  {
    this.lstParticipantes = lstParticipantes;
  }

  public Long getOidDirigidoA()
  {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA)
  {
    this.oidDirigidoA = oidDirigidoA;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }
}