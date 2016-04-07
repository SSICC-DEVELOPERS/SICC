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
 */

package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOMovimientoCaja 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */


public class DTOMovimientoCaja extends DTOSiccPaginacion 
{
    private Long oidCaja;
    private String numeroMovimiento;
    private Date fecha;
    private String observaciones;
    private String usuario;
    private BigDecimal diferenciaVuelto;
    private ArrayList detalle;
  private Long oidCliente;
  private Long oidSolicitudCabecera;
  private Long caja;

    public DTOMovimientoCaja()
    {
    }

    public Long getOidCaja()
    {
        return oidCaja;
    }

    public void setOidCaja(Long newOidCaja)
    {
        oidCaja = newOidCaja;
    }

    public String getNumeroMovimiento()
    {
        return numeroMovimiento;
    }

    public void setNumeroMovimiento(String newNumeroMovimiento)
    {
        numeroMovimiento = newNumeroMovimiento;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date newFecha)
    {
        fecha = newFecha;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones)
    {
        observaciones = newObservaciones;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String newUsuario)
    {
        usuario = newUsuario;
    }

    public BigDecimal getDiferenciaVuelto()
    {
        return diferenciaVuelto;
    }

    public void setDiferenciaVuelto(BigDecimal newDiferenciaVuelto)
    {
        diferenciaVuelto = newDiferenciaVuelto;
    }

    public ArrayList getDetalle()
    {
        return detalle;
    }

    public void setDetalle(ArrayList newDetalle)
    {
        detalle = newDetalle;
    }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidSolicitudCabecera()
  {
    return oidSolicitudCabecera;
  }

  public void setOidSolicitudCabecera(Long oidSolicitudCabecera)
  {
    this.oidSolicitudCabecera = oidSolicitudCabecera;
  }

  public Long getCaja()
  {
    return caja;
  }

  public void setCaja(Long caja)
  {
    this.caja = caja;
  }
}