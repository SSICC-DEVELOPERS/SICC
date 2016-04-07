package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCursoExigidoPremiacion extends DTOBelcorp 
{
  private Long oidCursoExigido;
  private Long oidTipoCurso;
  private String tipoCurso;

  public Long getOidCursoExigido()
  {
    return oidCursoExigido;
  }

  public void setOidCursoExigido(Long oidCursoExigido)
  {
    this.oidCursoExigido = oidCursoExigido;
  }

  public Long getOidTipoCurso()
  {
    return oidTipoCurso;
  }

  public void setOidTipoCurso(Long oidTipoCurso)
  {
    this.oidTipoCurso = oidTipoCurso;
  }

  public String getTipoCurso()
  {
    return tipoCurso;
  }

  public void setTipoCurso(String tipoCurso)
  {
    this.tipoCurso = tipoCurso;
  }
}