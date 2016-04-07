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

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOMovimientoCajaDetalle 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOMovimientoCajaDetalle extends DTOAuditableSICC {
    private Long oidMovimientoDeCajaDetalle;
    private Integer numeroLinea;
    private BigDecimal importe;
    private BigDecimal diferenciaVuelto;
    private BigDecimal importeDivisa;
    private String numeroCheque;
    private String numeroTarjeta;
    private String numeroValeCompra;
    Date fecha;
    private Long oidMovimientoDeCajaDetalleOrigen;
    private Long oidMovimientoDeCajaCabecera;
    private Long oidMedioPagoBelcenter;
    private Long oidMonedaAlternativa;
    private Long oidTipoTarjeta;
    private Long oidSolicitudCabecera;
    private Long oidBancos;
    private Long tipoMedioPago;
    private Long caja;
    private Long oidTipoMovimientoCaja;
    private Long oidSolicitudNotaCredito;

    public DTOMovimientoCajaDetalle()
    {
    }

    public Long getOidMovimientoDeCajaDetalle()
    {
        return oidMovimientoDeCajaDetalle;
    }

    public void setOidMovimientoDeCajaDetalle(Long newOidMovimientoDeCajaDetalle)
    {
        oidMovimientoDeCajaDetalle = newOidMovimientoDeCajaDetalle;
    }

    public Integer getNumeroLinea()
    {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer newNumeroLinea)
    {
        numeroLinea = newNumeroLinea;
    }

    public BigDecimal getImporte()
    {
        return importe;
    }

    public void setImporte(BigDecimal newImporte)
    {
        importe = newImporte;
    }

    public BigDecimal getDiferenciaVuelto()
    {
        return diferenciaVuelto;
    }

    public void setDiferenciaVuelto(BigDecimal newDiferenciaVuelto)
    {
        diferenciaVuelto = newDiferenciaVuelto;
    }

    public BigDecimal getImporteDivisa()
    {
        return importeDivisa;
    }

    public void setImporteDivisa(BigDecimal newImporteDivisa)
    {
        importeDivisa = newImporteDivisa;
    }

    public String getNumeroCheque()
    {
        return numeroCheque;
    }

    public void setNumeroCheque(String newNumeroCheque)
    {
        numeroCheque = newNumeroCheque;
    }

    public String getNumeroTarjeta()
    {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String newNumeroTarjeta)
    {
        numeroTarjeta = newNumeroTarjeta;
    }

    public String getNumeroValeCompra()
    {
        return numeroValeCompra;
    }

    public void setNumeroValeCompra(String newNumeroValeCompra)
    {
        numeroValeCompra = newNumeroValeCompra;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date newFecha)
    {
        fecha = newFecha;
    }

    public Long getOidMovimientoDeCajaDetalleOrigen()
    {
        return oidMovimientoDeCajaDetalleOrigen;
    }

    public void setOidMovimientoDeCajaDetalleOrigen(Long newOidMovimientoDeCajaDetalleOrigen)
    {
        oidMovimientoDeCajaDetalleOrigen = newOidMovimientoDeCajaDetalleOrigen;
    }

    public Long getOidMovimientoDeCajaCabecera()
    {
        return oidMovimientoDeCajaCabecera;
    }

    public void setOidMovimientoDeCajaCabecera(Long newOidMovimientoDeCajaCabecera)
    {
        oidMovimientoDeCajaCabecera = newOidMovimientoDeCajaCabecera;
    }

    public Long getOidMedioPagoBelcenter()
    {
        return oidMedioPagoBelcenter;
    }

    public void setOidMedioPagoBelcenter(Long newOidMedioPagoBelcenter)
    {
        oidMedioPagoBelcenter = newOidMedioPagoBelcenter;
    }

    public Long getOidMonedaAlternativa()
    {
        return oidMonedaAlternativa;
    }

    public void setOidMonedaAlternativa(Long newOidMonedaAlternativa)
    {
        oidMonedaAlternativa = newOidMonedaAlternativa;
    }

    public Long getOidTipoTarjeta()
    {
        return oidTipoTarjeta;
    }

    public void setOidTipoTarjeta(Long newOidTipoTarjeta)
    {
        oidTipoTarjeta = newOidTipoTarjeta;
    }

    public Long getOidSolicitudCabecera()
    {
        return oidSolicitudCabecera;
    }

    public void setOidSolicitudCabecera(Long newOidSolicitudCabecera)
    {
        oidSolicitudCabecera = newOidSolicitudCabecera;
    }

    public Long getOidBancos()
    {
        return oidBancos;
    }

    public void setOidBancos(Long newOidBancos)
    {
        oidBancos = newOidBancos;
    }

    public Long getTipoMedioPago()
    {
        return tipoMedioPago;
    }

    public void setTipoMedioPago(Long newTipoMedioPago)
    {
        tipoMedioPago = newTipoMedioPago;
    }

    public Long getCaja()
    {
        return caja;
    }

    public void setCaja(Long newCaja)
    {
        caja = newCaja;
    }

  public Long getOidTipoMovimientoCaja() {
    return oidTipoMovimientoCaja;
  }

  public void setOidTipoMovimientoCaja(Long newOidTipoMovimientoCaja) {
    oidTipoMovimientoCaja = newOidTipoMovimientoCaja;
  }
  
  public Long getOidSolicitudNotaCredito(){
    return oidSolicitudNotaCredito;
  }
  
  public void setOidSolicitudNotaCredito(Long oidSolicitudNotaCredito){
    this.oidSolicitudNotaCredito = oidSolicitudNotaCredito;
  }
  
}