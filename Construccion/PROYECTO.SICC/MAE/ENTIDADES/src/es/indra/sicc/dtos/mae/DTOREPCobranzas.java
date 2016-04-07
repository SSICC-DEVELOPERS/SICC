package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;

public class DTOREPCobranzas extends DTOAuditableSICC 
{
  private Boolean actualmenteEnCobranzas;
  private DTOSalida datosEtapa;

  public DTOREPCobranzas()
  {
  }

  public Boolean getActualmenteEnCobranzas()
  {
    return actualmenteEnCobranzas;
  }

  public void setActualmenteEnCobranzas(Boolean actualmenteEnCobranzas)
  {
    this.actualmenteEnCobranzas = actualmenteEnCobranzas;
  }

  public DTOSalida getDatosEtapa()
  {
    return datosEtapa;
  }

  public void setDatosEtapa(DTOSalida datosEtapa)
  {
    this.datosEtapa = datosEtapa;
  }
}