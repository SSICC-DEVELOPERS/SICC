package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOActualizacionCartera extends DTOAuditableSICC 
{
  Long oidTipoCargo;
  Long oidMarca;
  Long oidSubacceso;
  Long oidCuota;
  Long oidEstadoAsignacion;
  BigDecimal importeDeudaCancelada;

  public DTOActualizacionCartera()
  {
  }

  public Long getOidTipoCargo()
  {
    return oidTipoCargo;
  }

  public void setOidTipoCargo(Long oidTipoCargo)
  {
    this.oidTipoCargo = oidTipoCargo;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getOidCuota()
  {
    return oidCuota;
  }

  public void setOidCuota(Long oidCuota)
  {
    this.oidCuota = oidCuota;
  }

  public Long getOidEstadoAsignacion()
  {
    return oidEstadoAsignacion;
  }

  public void setOidEstadoAsignacion(Long oidEstadoAsignacion)
  {
    this.oidEstadoAsignacion = oidEstadoAsignacion;
  }

  public BigDecimal getImporteDeudaCancelada()
  {
    return importeDeudaCancelada;
  }

  public void setImporteDeudaCancelada(BigDecimal importeDeudaCancelada)
  {
    this.importeDeudaCancelada = importeDeudaCancelada;
  }
}