/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTORequisitosPremiacion extends DTOBelcorp 
{

  private Long oidRequisitosPremiacion;
  private BigDecimal montoMinimoConcurso;
  private Integer numeroPedidos;
  private Integer cuotaMinimaIngreso;
  private Boolean indPasarPedidoPeriodoPremiacion;
  private BigDecimal montoMinimoPedido;
  private Boolean indPagoTiempo;
  private Integer diasGracia;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Long numeroPerioEspera;
  private Long oidPeriodoMax;
  private Long oidValiDeuda;
  private String periodoMaxDescrip;
  private String descripValidaDeuda;
    
  public DTORequisitosPremiacion()
  {
  }

  public Long getOidRequisitosPremiacion()
  {
    return oidRequisitosPremiacion;
  }

  public void setOidRequisitosPremiacion(Long oidRequisitosPremiacion)
  {
    this.oidRequisitosPremiacion = oidRequisitosPremiacion;
  }

  public BigDecimal getMontoMinimoConcurso()
  {
    return montoMinimoConcurso;
  }

  public void setMontoMinimoConcurso(BigDecimal montoMinimoConcurso)
  {
    this.montoMinimoConcurso = montoMinimoConcurso;
  }

  public Integer getNumeroPedidos()
  {
    return numeroPedidos;
  }

  public void setNumeroPedidos(Integer numeroPedidos)
  {
    this.numeroPedidos = numeroPedidos;
  }

  public Integer getCuotaMinimaIngreso()
  {
    return cuotaMinimaIngreso;
  }

  public void setCuotaMinimaIngreso(Integer cuotaMinimaIngreso)
  {
    this.cuotaMinimaIngreso = cuotaMinimaIngreso;
  }

  public Boolean getIndPasarPedidoPeriodoPremiacion()
  {
    return indPasarPedidoPeriodoPremiacion;
  }

  public void setIndPasarPedidoPeriodoPremiacion(Boolean indPasarPedidoPeriodoPremiacion)
  {
    this.indPasarPedidoPeriodoPremiacion = indPasarPedidoPeriodoPremiacion;
  }

  public BigDecimal getMontoMinimoPedido()
  {
    return montoMinimoPedido;
  }

  public void setMontoMinimoPedido(BigDecimal montoMinimoPedido)
  {
    this.montoMinimoPedido = montoMinimoPedido;
  }

  public Boolean getIndPagoTiempo()
  {
    return indPagoTiempo;
  }

  public void setIndPagoTiempo(Boolean indPagoTiempo)
  {
    this.indPagoTiempo = indPagoTiempo;
  }

  public Integer getDiasGracia()
  {
    return diasGracia;
  }

  public void setDiasGracia(Integer diasGracia)
  {
    this.diasGracia = diasGracia;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }
  
    //Agregado por cambio 20090929
     
    public Long getNumeroPerioEspera()
    {
        return numeroPerioEspera;
    }

    public void setNumeroPerioEspera(Long numeroPerioEspera)
    {
        this.numeroPerioEspera = numeroPerioEspera;
    }
      
    public Long getOidPeriodoMax()
    {
         return oidPeriodoMax;
    }

    public void setOidPeriodoMax(Long oidPeriodoMax)
    {
         this.oidPeriodoMax = oidPeriodoMax;
    }
       
    public Long getOidValiDeuda()
    {
         return oidValiDeuda;
    }

    public void setoidValiDeuda(Long oidValiDeuda)
    {
         this.oidValiDeuda = oidValiDeuda;
    }
       
    public String getPeriodoMaxDescrip()
    {
         return periodoMaxDescrip;
    }

    public void setPeriodoMaxDescrip(String periodoMaxDescrip)
    {
         this.periodoMaxDescrip = periodoMaxDescrip;
    }
       
    public String getDescripValidaDeuda()
    {
         return descripValidaDeuda;
    }

    public void setDescripValidaDeuda(String descripValidaDeuda)
    {
         this.descripValidaDeuda = descripValidaDeuda;
    }

}

