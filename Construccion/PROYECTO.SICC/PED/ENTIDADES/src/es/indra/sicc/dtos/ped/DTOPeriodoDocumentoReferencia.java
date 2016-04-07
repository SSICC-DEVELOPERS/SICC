package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPeriodoDocumentoReferencia extends DTOAuditableSICC 
{
  private Long periodoDocumentoReferencia;
  private String nombrePeriodoDocumentoReferencia;

  public DTOPeriodoDocumentoReferencia()
  {
  }

  public Long getPeriodoDocumentoReferencia()
  {
    return periodoDocumentoReferencia;
  }

  public void setPeriodoDocumentoReferencia(Long periodoDocumentoReferencia)
  {
    this.periodoDocumentoReferencia = periodoDocumentoReferencia;
  }

  public String getNombrePeriodoDocumentoReferencia()
  {
    return nombrePeriodoDocumentoReferencia;
  }

  public void setNombrePeriodoDocumentoReferencia(String nombrePeriodoDocumentoReferencia)
  {
    this.nombrePeriodoDocumentoReferencia = nombrePeriodoDocumentoReferencia;
  }
}