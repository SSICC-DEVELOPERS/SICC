package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOGenerarCronogramaCOBPeriodo extends DTOAuditableSICC 
{
  Long periodo;
  ArrayList etapas;

  public DTOGenerarCronogramaCOBPeriodo()
  {
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public ArrayList getEtapas()
  {
    return etapas;
  }

  public void setEtapas(ArrayList etapas)
  {
    this.etapas = etapas;
  }
}