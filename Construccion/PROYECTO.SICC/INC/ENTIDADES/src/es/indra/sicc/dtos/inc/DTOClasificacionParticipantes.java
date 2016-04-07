package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOClasificacionParticipantes extends DTOBelcorp 
{
  private ArrayList lstClasificacionParticipantes;
  private ArrayList lstParticipantes;
  private Long oidConcurso;
  private Long oidDirigidoA;

  public ArrayList getLstClasificacionParticipantes()
  {
    return lstClasificacionParticipantes;
  }

  public void setLstClasificacionParticipantes(ArrayList lstClasificacionParticipantes)
  {
    this.lstClasificacionParticipantes = lstClasificacionParticipantes;
  }

  public ArrayList getLstParticipantes()
  {
    return lstParticipantes;
  }

  public void setLstParticipantes(ArrayList lstParticipantes)
  {
    this.lstParticipantes = lstParticipantes;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidDirigidoA()
  {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA)
  {
    this.oidDirigidoA = oidDirigidoA;
  }
}