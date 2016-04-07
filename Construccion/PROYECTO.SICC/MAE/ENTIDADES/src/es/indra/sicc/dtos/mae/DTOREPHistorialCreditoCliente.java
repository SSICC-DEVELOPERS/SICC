package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOREPHistorialCreditoCliente extends DTOAuditableSICC 
{
  private DTOREPClienteDatosBasicos datosBasicosCliente;
  private DTOREPSolicitudMasAntiguaNoCancelada solicitudMasAntiguaNoCancelada;
  private DTOREPCuentasCorrientes cuentasCorrientes;
  private DTOREPCredito credito;
  private DTOREPCobranzas cobranzas;
  private DTOREPSolicitudesBloqueadas solicitudesBloquedas;

  public DTOREPHistorialCreditoCliente()
  {
  }

  public DTOREPClienteDatosBasicos getDatosBasicosCliente()
  {
    return datosBasicosCliente;
  }

  public void setDatosBasicosCliente(DTOREPClienteDatosBasicos datosBasicosCliente)
  {
    this.datosBasicosCliente = datosBasicosCliente;
  }

  public DTOREPSolicitudMasAntiguaNoCancelada getSolicitudMasAntiguaNoCancelada()
  {
    return solicitudMasAntiguaNoCancelada;
  }

  public void setSolicitudMasAntiguaNoCancelada(DTOREPSolicitudMasAntiguaNoCancelada solicitudMasAntiguaNoCancelada)
  {
    this.solicitudMasAntiguaNoCancelada = solicitudMasAntiguaNoCancelada;
  }

  public DTOREPCuentasCorrientes getCuentasCorrientes()
  {
    return cuentasCorrientes;
  }

  public void setCuentasCorrientes(DTOREPCuentasCorrientes cuentasCorrientes)
  {
    this.cuentasCorrientes = cuentasCorrientes;
  }

  public DTOREPCredito getCredito()
  {
    return credito;
  }

  public void setCredito(DTOREPCredito credito)
  {
    this.credito = credito;
  }

  public DTOREPCobranzas getCobranzas()
  {
    return cobranzas;
  }

  public void setCobranzas(DTOREPCobranzas cobranzas)
  {
    this.cobranzas = cobranzas;
  }

  public DTOREPSolicitudesBloqueadas getSolicitudesBloquedas()
  {
    return solicitudesBloquedas;
  }

  public void setSolicitudesBloquedas(DTOREPSolicitudesBloqueadas solicitudesBloquedas)
  {
    this.solicitudesBloquedas = solicitudesBloquedas;
  }
}