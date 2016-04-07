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
 * Autor : Damasia Maneiro
 */
 
package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

public class DTOAnticipo extends DTOBelcorp 
{
  private Long oidGanadora;
  private Long numPremio;
  private BigDecimal unidades;
  //Inc 19248
  private Long oidNivelPremiacion;
  private Long oidParametrosGeneralesPremiacion;
  //Inc 17813
  private Long oidFormaPago;

  public DTOAnticipo()
  {
  }

  public Long getOidGanadora()
  {
    return oidGanadora;
  }

  public void setOidGanadora(Long oidGanadora)
  {
    this.oidGanadora = oidGanadora;
  }

  public Long getNumPremio()
  {
    return numPremio;
  }

  public void setNumPremio(Long numPremio)
  {
    this.numPremio = numPremio;
  }

  public BigDecimal getUnidades()
  {
    return unidades;
  }

  public void setUnidades(BigDecimal unidades)
  {
    this.unidades = unidades;
  }


    public void setOidNivelPremiacion(Long oidNivelPremiacion)
    {
        this.oidNivelPremiacion = oidNivelPremiacion;
    }


    public Long getOidNivelPremiacion()
    {
        return oidNivelPremiacion;
    }


    public void setOidParametrosGeneralesPremiacion(Long oidParametrosGeneralesPremiacion)
    {
        this.oidParametrosGeneralesPremiacion = oidParametrosGeneralesPremiacion;
    }


    public Long getOidParametrosGeneralesPremiacion()
    {
        return oidParametrosGeneralesPremiacion;
    }


    public void setOidFormaPago(Long oidFormaPago)
    {
        this.oidFormaPago = oidFormaPago;
    }


    public Long getOidFormaPago()
    {
        return oidFormaPago;
    }
}