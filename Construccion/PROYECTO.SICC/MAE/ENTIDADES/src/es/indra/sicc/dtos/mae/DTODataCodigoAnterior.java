package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODataCodigoAnterior extends DTOSiccPaginacion 
{
  private Long oidCliente;
  private Long oidPaiscmb;
  private String codigoClienteNuevo;
  private String codigoClienteAntiguo;
  private String sistemaProcedencia;
  private Long oidCodigoAnterior;

  public DTODataCodigoAnterior()
  {
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidPaiscmb()
  {
    return oidPaiscmb;
  }

  public void setOidPaiscmb(Long oidPaiscmb)
  {
    this.oidPaiscmb = oidPaiscmb;
  }

  public String getCodigoClienteNuevo()
  {
    return codigoClienteNuevo;
  }

  public void setCodigoClienteNuevo(String codigoClienteNuevo)
  {
    this.codigoClienteNuevo = codigoClienteNuevo;
  }

  public String getCodigoClienteAntiguo()
  {
    return codigoClienteAntiguo;
  }

  public void setCodigoClienteAntiguo(String codigoClienteAntiguo)
  {
    this.codigoClienteAntiguo = codigoClienteAntiguo;
  }

  public String getSistemaProcedencia()
  {
    return sistemaProcedencia;
  }

  public void setSistemaProcedencia(String sistemaProcedencia)
  {
    this.sistemaProcedencia = sistemaProcedencia;
  }

  public Long getOidCodigoAnterior()
  {
    return oidCodigoAnterior;
  }

  public void setOidCodigoAnterior(Long oidCodigoAnterior)
  {
    this.oidCodigoAnterior = oidCodigoAnterior;
  }


}