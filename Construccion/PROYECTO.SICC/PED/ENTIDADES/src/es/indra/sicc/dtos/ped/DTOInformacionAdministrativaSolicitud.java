package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionAdministrativaSolicitud extends DTOAuditableSICC {

    private Long oidTipoDocumento;
    private Long oidConsultoraAsociada;
    private String consultoraAsociada;
    private Long oidDestino;
    private Long oidReceptorFactura;
    private String receptorFactura;
    private Long oidPagadorFactura;
    private String pagadorFactura;
    private Integer numeroClientes;
    private Long oidTipoDocumentoIdentidad;
    private String tipoDocumentoLegal;
    private Long numeroDocumentoLegal;
    private String indicadorImpuestos;
    private Long oidFormaPago;

  public String getConsultoraAsociada()
  {
    return consultoraAsociada;
  }

  public void setConsultoraAsociada(String consultoraAsociada)
  {
    this.consultoraAsociada = consultoraAsociada;
  }

  public String getIndicadorImpuestos()
  {
    return indicadorImpuestos;
  }

  public void setIndicadorImpuestos(String indicadorImpuestos)
  {
    this.indicadorImpuestos = indicadorImpuestos;
  }

  public Integer getNumeroClientes()
  {
    return numeroClientes;
  }

  public void setNumeroClientes(Integer numeroClientes)
  {
    this.numeroClientes = numeroClientes;
  }

  public Long getNumeroDocumentoLegal()
  {
    return numeroDocumentoLegal;
  }

  public void setNumeroDocumentoLegal(Long numeroDocumentoLegal)
  {
    this.numeroDocumentoLegal = numeroDocumentoLegal;
  }

  public Long getOidConsultoraAsociada()
  {
    return oidConsultoraAsociada;
  }

  public void setOidConsultoraAsociada(Long oidConsultoraAsociada)
  {
    this.oidConsultoraAsociada = oidConsultoraAsociada;
  }

  public Long getOidDestino()
  {
    return oidDestino;
  }

  public void setOidDestino(Long oidDestino)
  {
    this.oidDestino = oidDestino;
  }

  public Long getOidFormaPago()
  {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long oidFormaPago)
  {
    this.oidFormaPago = oidFormaPago;
  }

  public Long getOidPagadorFactura()
  {
    return oidPagadorFactura;
  }

  public void setOidPagadorFactura(Long oidPagadorFactura)
  {
    this.oidPagadorFactura = oidPagadorFactura;
  }

  public Long getOidReceptorFactura()
  {
    return oidReceptorFactura;
  }

  public void setOidReceptorFactura(Long oidReceptorFactura)
  {
    this.oidReceptorFactura = oidReceptorFactura;
  }

  public Long getOidTipoDocumentoIdentidad()
  {
    return oidTipoDocumentoIdentidad;
  }

  public void setOidTipoDocumentoIdentidad(Long oidTipoDocumentoIdentidad)
  {
    this.oidTipoDocumentoIdentidad = oidTipoDocumentoIdentidad;
  }

  public String getPagadorFactura()
  {
    return pagadorFactura;
  }

  public void setPagadorFactura(String pagadorFactura)
  {
    this.pagadorFactura = pagadorFactura;
  }

  public String getReceptorFactura()
  {
    return receptorFactura;
  }

  public void setReceptorFactura(String receptorFactura)
  {
    this.receptorFactura = receptorFactura;
  }

  public String getTipoDocumentoLegal()
  {
    return tipoDocumentoLegal;
  }

  public void setTipoDocumentoLegal(String tipoDocumentoLegal)
  {
    this.tipoDocumentoLegal = tipoDocumentoLegal;
  }


  public void setOidTipoDocumento(Long oidTipoDocumento)
  {
    this.oidTipoDocumento = oidTipoDocumento;
  }


  public Long getOidTipoDocumento()
  {
    return oidTipoDocumento;
  }
    
}