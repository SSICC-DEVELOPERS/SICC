package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOGenerarMensajes extends DTOAuditableSICC
{
    public Long oidEtapa;
    public Long oidMarca;
    public Long oidCanal;
    public Long oidPeriodo;
    public Long oidCliente;
    public BigDecimal importe;
    private Long oidCronoCobra;
    private String clienteNombre;
    private Long oidUsuarioCobranza;

  public DTOGenerarMensajes()
  {
  }
  
  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }
  
   public Long getOidCronoCobra()
  {
    return oidCronoCobra;
  }

  public void setOidCronoCobra(Long oidCronoCobra)
  {
    this.oidCronoCobra = oidCronoCobra;
  }

    public String getClienteNombre()
    {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre)
    {
        this.clienteNombre = clienteNombre;
    }

    public Long getOidUsuarioCobranza()
    {
        return oidUsuarioCobranza;
    }

    public void setOidUsuarioCobranza(Long oidUsuarioCobranza)
    {
        this.oidUsuarioCobranza = oidUsuarioCobranza;
    }
  
}