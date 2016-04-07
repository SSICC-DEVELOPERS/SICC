package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosGeneralesConcursoRanking extends DTOBelcorp 
{
  private Long oid;
  private Long oidPeriodoCalificacion;
  private Long oidPeriodoPremiacion;
  private Long oidNivelAgrupamiento;
  private Long oidTipoRanking;
  private Long oidTipoExigencia;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidPeriodoCalificacion()
  {
    return oidPeriodoCalificacion;
  }

  public void setOidPeriodoCalificacion(Long oidPeriodoCalificacion)
  {
    this.oidPeriodoCalificacion = oidPeriodoCalificacion;
  }

  public Long getOidPeriodoPremiacion()
  {
    return oidPeriodoPremiacion;
  }

  public void setOidPeriodoPremiacion(Long oidPeriodoPremiacion)
  {
    this.oidPeriodoPremiacion = oidPeriodoPremiacion;
  }

  public Long getOidNivelAgrupamiento()
  {
    return oidNivelAgrupamiento;
  }

  public void setOidNivelAgrupamiento(Long oidNivelAgrupamiento)
  {
    this.oidNivelAgrupamiento = oidNivelAgrupamiento;
  }

  public Long getOidTipoRanking()
  {
    return oidTipoRanking;
  }

  public void setOidTipoRanking(Long oidTipoRanking)
  {
    this.oidTipoRanking = oidTipoRanking;
  }

  public Long getOidTipoExigencia()
  {
    return oidTipoExigencia;
  }

  public void setOidTipoExigencia(Long oidTipoExigencia)
  {
    this.oidTipoExigencia = oidTipoExigencia;
  }
}