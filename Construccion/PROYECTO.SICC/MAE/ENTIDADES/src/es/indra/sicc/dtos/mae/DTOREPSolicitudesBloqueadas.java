package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;

public class DTOREPSolicitudesBloqueadas extends DTOAuditableSICC 
{
  private DTOSalida soliBloqUltimosSeisMeses;

  public DTOREPSolicitudesBloqueadas()
  {
  }

  public DTOSalida getSoliBloqUltimosSeisMeses()
  {
    return soliBloqUltimosSeisMeses;
  }

  public void setSoliBloqUltimosSeisMeses(DTOSalida soliBloqUltimosSeisMeses)
  {
    this.soliBloqUltimosSeisMeses = soliBloqUltimosSeisMeses;
  }
}