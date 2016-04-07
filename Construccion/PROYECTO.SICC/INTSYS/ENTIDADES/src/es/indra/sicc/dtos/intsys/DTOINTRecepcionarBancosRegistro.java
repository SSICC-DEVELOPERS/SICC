package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class DTOINTRecepcionarBancosRegistro extends DTOBelcorp 
{

  private String fechaPago;
  private String codigoBancoSicc;
  private String tipoTransaccion;
  private String codConsultora;
  private Long numeroFacturaBoleta;
  private BigDecimal importePago;
  private Long numeroCupon;
  private Integer digitoChequeoFactura;
  private String oficinaRecaudadora;
  private String nombreOficina;
  private String numeroDocumento;
  private String horarioNormalAdicional;
  private String usuarioProceso;
  private java.sql.Date fechaProceso;
  private String envioFecha1;
  private String envioFecha2;
  private Timestamp envioFecha;
  private Long consecutivoTransaccion;
  private Long numeroLoteExterno;
  private Long empresa;
  private Long oidCtaCte;
  private Long oidCliente;
  private String codigoError;
  private Long errorOid;
  private String idenProceso;
  private String digCheqNumFact;
  private Long oidTipoTransaccion;
  
  public DTOINTRecepcionarBancosRegistro()
  {
  }

  public void setFechaPago(String fechaPago)
  {
    this.fechaPago = fechaPago;
  }


  public String getFechaPago()
  {
    return fechaPago;
  }


  public void setCodigoBancoSicc(String codigoBancoSicc)
  {
    this.codigoBancoSicc = codigoBancoSicc;
  }


  public String getCodigoBancoSicc()
  {
    return codigoBancoSicc;
  }


  public void setTipoTransaccion(String tipoTransaccion)
  {
    this.tipoTransaccion = tipoTransaccion;
  }


  public String getTipoTransaccion()
  {
    return tipoTransaccion;
  }


  public void setCodConsultora(String codConsultora)
  {
    this.codConsultora = codConsultora;
  }


  public String getCodConsultora()
  {
    return codConsultora;
  }


  public void setNumeroFacturaBoleta(Long numeroFacturaBoleta)
  {
    this.numeroFacturaBoleta = numeroFacturaBoleta;
  }


  public Long getNumeroFacturaBoleta()
  {
    return numeroFacturaBoleta;
  }


  public void setImportePago(BigDecimal importePago)
  {
    this.importePago = importePago;
  }


  public BigDecimal getImportePago()
  {
    return importePago;
  }


  public void setNumeroCupon(Long numeroCupon)
  {
    this.numeroCupon = numeroCupon;
  }


  public Long getNumeroCupon()
  {
    return numeroCupon;
  }


  public void setDigitoChequeoFactura(Integer digitoChequeoFactura)
  {
    this.digitoChequeoFactura = digitoChequeoFactura;
  }


  public Integer getDigitoChequeoFactura()
  {
    return digitoChequeoFactura;
  }


  public void setOficinaRecaudadora(String oficinaRecaudadora)
  {
    this.oficinaRecaudadora = oficinaRecaudadora;
  }


  public String getOficinaRecaudadora()
  {
    return oficinaRecaudadora;
  }


  public void setNombreOficina(String nombreOficina)
  {
    this.nombreOficina = nombreOficina;
  }


  public String getNombreOficina()
  {
    return nombreOficina;
  }


  public void setNumeroDocumento(String numeroDocumento)
  {
    this.numeroDocumento = numeroDocumento;
  }


  public String getNumeroDocumento()
  {
    return numeroDocumento;
  }


  public void setHorarioNormalAdicional(String horarioNormalAdicional)
  {
    this.horarioNormalAdicional = horarioNormalAdicional;
  }


  public String getHorarioNormalAdicional()
  {
    return horarioNormalAdicional;
  }


  public void setUsuarioProceso(String usuarioProceso)
  {
    this.usuarioProceso = usuarioProceso;
  }


  public String getUsuarioProceso()
  {
    return usuarioProceso;
  }


  public void setFechaProceso(java.sql.Date fechaProceso)
  {
    this.fechaProceso = fechaProceso;
  }


  public java.sql.Date getFechaProceso()
  {
    return fechaProceso;
  }


  public void setEnvioFecha1(String envioFecha1)
  {
    this.envioFecha1 = envioFecha1;
  }


  public String getEnvioFecha1()
  {
    return envioFecha1;
  }


  public void setEnvioFecha2(String envioFecha2)
  {
    this.envioFecha2 = envioFecha2;
  }


  public String getEnvioFecha2()
  {
    return envioFecha2;
  }

  public void setConsecutivoTransaccion(Long consecutivoTransaccion)
  {
    this.consecutivoTransaccion = consecutivoTransaccion;
  }


  public Long getConsecutivoTransaccion()
  {
    return consecutivoTransaccion;
  }


  public void setNumeroLoteExterno(Long numeroLoteExterno)
  {
    this.numeroLoteExterno = numeroLoteExterno;
  }


  public Long getNumeroLoteExterno()
  {
    return numeroLoteExterno;
  }


  public void setEmpresa(Long empresa)
  {
    this.empresa = empresa;
  }


  public Long getEmpresa()
  {
    return empresa;
  }


  public void setOidCtaCte(Long oidCtaCte)
  {
    this.oidCtaCte = oidCtaCte;
  }


  public Long getOidCtaCte()
  {
    return oidCtaCte;
  }


  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }


  public Long getOidCliente()
  {
    return oidCliente;
  }


  public void setCodigoError(String codigoError)
  {
    this.codigoError = codigoError;
  }


  public String getCodigoError()
  {
    return codigoError;
  }


  public void setErrorOid(Long errorOid)
  {
    this.errorOid = errorOid;
  }


  public Long getErrorOid()
  {
    return errorOid;
  }


  public void setIdenProceso(String idenProceso)
  {
    this.idenProceso = idenProceso;
  }


  public String getIdenProceso()
  {
    return idenProceso;
  }


  public void setDigCheqNumFact(String digCheqNumFact)
  {
    this.digCheqNumFact = digCheqNumFact;
  }


  public String getDigCheqNumFact()
  {
    return digCheqNumFact;
  }


  public void setOidTipoTransaccion(Long oidTipoTransaccion)
  {
    this.oidTipoTransaccion = oidTipoTransaccion;
  }


  public Long getOidTipoTransaccion()
  {
    return oidTipoTransaccion;
  }


  public void setEnvioFecha(Timestamp envioFecha)
  {
    this.envioFecha = envioFecha;
  }


  public Timestamp getEnvioFecha()
  {
    return envioFecha;
  }
  
}