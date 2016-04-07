/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOValidarOperacionReclamo extends DTOBelcorp
{
    private Long oidOperacion;
    private Integer numeroOperacion;
    private Long oidReclamo;
    private Long oidResponsablePerdida;
    private Long oidClienteSeguro;
    private Long oidAsumePerdida;
    private Long oidArticulo;
    private BigDecimal montoPerdida;
    private BigDecimal porcentajePerdida;
    private Long oidPrecioPerdida;
    private boolean perdida;
    private boolean anulacion;   
    private Long oidPrecioEnvia;
    private Long oidTipoOperacion;
    private boolean error;
    private boolean devuelveFisicoFactura;
    private boolean devuelveEnFactura;
    private boolean enviaEnFactura;
    private Long oidMotivoBloqueo;
    private Integer numeroLineasDevuelve;
    private ArrayList lineas;
    
    private boolean enviaGeneraDevuelve;
    private boolean devuelveGeneraEnvia;
    private Long oidBloqueoUnidades;
    private Long oidBloqueoImporte;
    private Long oidBloqueoAnterior;
    private Long oidBloqueoDiferencia;
    //añadido por incidencia 15177
    private Long oidPrecio;
    //añadido por incidencia 22963
    private String codigoOperacion;
  private boolean indRecojo;
  private Long oidTipoSolicRecojoIncial;
  private Long oidTipoSolicPrimerRecojoNoExitoso;
  private Long oidTipoSolicSegundoRecojoNoExitoso;
  private Long oidTipoAlmacenRecojoInicial;
  private Long oidTipoAlmacenRecojoExitoso;
  private Long oidTipoAlmacenRecojoNoExitoso;
  private Long oidAlmacenPostVenta;

    
    public DTOValidarOperacionReclamo()
    {
    }

    public boolean getAnulacion()
    {
        return anulacion;
    }

    public void setAnulacion(boolean anulacion)
    {
        this.anulacion = anulacion;
    }

    public boolean getDevuelveEnFactura()
    {
        return devuelveEnFactura;
    }

    public void setDevuelveEnFactura(boolean devuelveEnFactura)
    {
        this.devuelveEnFactura = devuelveEnFactura;
    }

    public boolean getDevuelveFisicoFactura()
    {
        return devuelveFisicoFactura;
    }

    public void setDevuelveFisicoFactura(boolean devuelveFisicoFactura)
    {
        this.devuelveFisicoFactura = devuelveFisicoFactura;
    }

    public boolean getEnviaEnFactura()
    {
        return enviaEnFactura;
    }

    public void setEnviaEnFactura(boolean enviaEnFactura)
    {
        this.enviaEnFactura = enviaEnFactura;
    }

    public boolean getError()
    {
        return error;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public ArrayList getLineas()
    {
        return lineas;
    }

    public void setLineas(ArrayList lineas)
    {
        this.lineas = lineas;
    }

    public BigDecimal getMontoPerdida()
    {
        return montoPerdida;
    }

    public void setMontoPerdida(BigDecimal montoPerdida)
    {
        this.montoPerdida = montoPerdida;
    }

    public Integer getNumeroLineasDevuelve()
    {
        return numeroLineasDevuelve;
    }

    public void setNumeroLineasDevuelve(Integer numeroLineasDevuelve)
    {
        this.numeroLineasDevuelve = numeroLineasDevuelve;
    }

    public Integer getNumeroOperacion()
    {
        return numeroOperacion;
    }

    public void setNumeroOperacion(Integer numeroOperacion)
    {
        this.numeroOperacion = numeroOperacion;
    }

    public Long getOidArticulo()
    {
        return oidArticulo;
    }

    public void setOidArticulo(Long oidArticulo)
    {
        this.oidArticulo = oidArticulo;
    }

    public Long getOidAsumePerdida()
    {
        return oidAsumePerdida;
    }

    public void setOidAsumePerdida(Long oidAsumePerdida)
    {
        this.oidAsumePerdida = oidAsumePerdida;
    }

    public Long getOidClienteSeguro()
    {
        return oidClienteSeguro;
    }

    public void setOidClienteSeguro(Long oidClienteSeguro)
    {
        this.oidClienteSeguro = oidClienteSeguro;
    }

    public Long getOidMotivoBloqueo()
    {
        return oidMotivoBloqueo;
    }

    public void setOidMotivoBloqueo(Long oidMotivoBloqueo)
    {
        this.oidMotivoBloqueo = oidMotivoBloqueo;
    }

    public Long getOidOperacion()
    {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion)
    {
        this.oidOperacion = oidOperacion;
    }

    public Long getOidPrecioEnvia()
    {
        return oidPrecioEnvia;
    }

    public void setOidPrecioEnvia(Long oidPrecioEnvia)
    {
        this.oidPrecioEnvia = oidPrecioEnvia;
    }

    public Long getOidPrecioPerdida()
    {
        return oidPrecioPerdida;
    }

    public void setOidPrecioPerdida(Long oidPrecioPerdida)
    {
        this.oidPrecioPerdida = oidPrecioPerdida;
    }

    public Long getOidReclamo()
    {
        return oidReclamo;
    }

    public void setOidReclamo(Long oidReclamo)
    {
        this.oidReclamo = oidReclamo;
    }

    public Long getOidResponsablePerdida()
    {
        return oidResponsablePerdida;
    }

    public void setOidResponsablePerdida(Long oidResponsablePerdida)
    {
        this.oidResponsablePerdida = oidResponsablePerdida;
    }

    public Long getOidTipoOperacion()
    {
        return oidTipoOperacion;
    }

    public void setOidTipoOperacion(Long oidTipoOperacion)
    {
        this.oidTipoOperacion = oidTipoOperacion;
    }

    public boolean getPerdida()
    {
        return perdida;
    }

    public void setPerdida(boolean perdida)
    {
        this.perdida = perdida;
    }

    public BigDecimal getPorcentajePerdida()
    {
        return porcentajePerdida;
    }

    public void setPorcentajePerdida(BigDecimal porcentajePerdida)
    {
        this.porcentajePerdida = porcentajePerdida;
    }

    public boolean getEnviaGeneraDevuelve()
    {
        return enviaGeneraDevuelve;
    }

    public void setEnviaGeneraDevuelve(boolean enviaGeneraDevuelve)
    {
        this.enviaGeneraDevuelve = enviaGeneraDevuelve;
    }

    public boolean getDevuelveGeneraEnvia()
    {
        return devuelveGeneraEnvia;
    }

    public void setDevuelveGeneraEnvia(boolean devuelveGeneraEnvia)
    {
        this.devuelveGeneraEnvia = devuelveGeneraEnvia;
    }

    public Long getOidBloqueoUnidades()
    {
        return oidBloqueoUnidades;
    }

    public void setOidBloqueoUnidades(Long oidBloqueoUnidades)
    {
        this.oidBloqueoUnidades = oidBloqueoUnidades;
    }

    public Long getOidBloqueoImporte()
    {
        return oidBloqueoImporte;
    }

    public void setOidBloqueoImporte(Long oidBloqueoImporte)
    {
        this.oidBloqueoImporte = oidBloqueoImporte;
    }

    public Long getOidBloqueoAnterior()
    {
        return oidBloqueoAnterior;
    }

    public void setOidBloqueoAnterior(Long oidBloqueoAnterior)
    {
        this.oidBloqueoAnterior = oidBloqueoAnterior;
    }

    public Long getOidBloqueoDiferencia()
    {
        return oidBloqueoDiferencia;
    }

    public void setOidBloqueoDiferencia(Long oidBloqueoDiferencia)
    {
        this.oidBloqueoDiferencia = oidBloqueoDiferencia;
    }

    public Long getOidPrecio()
    {
        return oidPrecio;
    }

    public void setOidPrecio(Long oidPrecio)
    {
        this.oidPrecio = oidPrecio;
    }

  public String getCodigoOperacion()
  {
    return codigoOperacion;
  }

  public void setCodigoOperacion(String codigoOperacion)
  {
    this.codigoOperacion = codigoOperacion;
  }

  public boolean getIndRecojo()
  {
    return indRecojo;
  }

  public void setIndRecojo(boolean indRecojo)
  {
    this.indRecojo = indRecojo;
  }

  public Long getOidTipoSolicRecojoIncial()
  {
    return oidTipoSolicRecojoIncial;
  }

  public void setOidTipoSolicRecojoIncial(Long oidTipoSolicRecojoIncial)
  {
    this.oidTipoSolicRecojoIncial = oidTipoSolicRecojoIncial;
  }

  public Long getOidTipoSolicPrimerRecojoNoExitoso()
  {
    return oidTipoSolicPrimerRecojoNoExitoso;
  }

  public void setOidTipoSolicPrimerRecojoNoExitoso(Long oidTipoSolicPrimerRecojoNoExitoso)
  {
    this.oidTipoSolicPrimerRecojoNoExitoso = oidTipoSolicPrimerRecojoNoExitoso;
  }

  public Long getOidTipoSolicSegundoRecojoNoExitoso()
  {
    return oidTipoSolicSegundoRecojoNoExitoso;
  }

  public void setOidTipoSolicSegundoRecojoNoExitoso(Long oidTipoSolicSegundoRecojoNoExitoso)
  {
    this.oidTipoSolicSegundoRecojoNoExitoso = oidTipoSolicSegundoRecojoNoExitoso;
  }

  public Long getOidTipoAlmacenRecojoInicial()
  {
    return oidTipoAlmacenRecojoInicial;
  }

  public void setOidTipoAlmacenRecojoInicial(Long oidTipoAlmacenRecojoInicial)
  {
    this.oidTipoAlmacenRecojoInicial = oidTipoAlmacenRecojoInicial;
  }

  public Long getOidTipoAlmacenRecojoExitoso()
  {
    return oidTipoAlmacenRecojoExitoso;
  }

  public void setOidTipoAlmacenRecojoExitoso(Long oidTipoAlmacenRecojoExitoso)
  {
    this.oidTipoAlmacenRecojoExitoso = oidTipoAlmacenRecojoExitoso;
  }

  public Long getOidTipoAlmacenRecojoNoExitoso()
  {
    return oidTipoAlmacenRecojoNoExitoso;
  }

  public void setOidTipoAlmacenRecojoNoExitoso(Long oidTipoAlmacenRecojoNoExitoso)
  {
    this.oidTipoAlmacenRecojoNoExitoso = oidTipoAlmacenRecojoNoExitoso;
  }

  public Long getOidAlmacenPostVenta()
  {
    return oidAlmacenPostVenta;
  }

  public void setOidAlmacenPostVenta(Long oidAlmacenPostVenta)
  {
    this.oidAlmacenPostVenta = oidAlmacenPostVenta;
  }
    
}