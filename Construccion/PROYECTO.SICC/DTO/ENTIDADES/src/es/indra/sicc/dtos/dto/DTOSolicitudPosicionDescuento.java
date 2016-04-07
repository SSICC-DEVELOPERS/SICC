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
 
package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSolicitudPosicionDescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOSolicitudPosicionDescuento extends DTOAuditableSICC {

    private Long oidSolicitud;
    private Long oidPosicion;
    private String codigoVenta;
    private String descripcionProducto;
    private Long cantidad;
    private Long unidadesPorAtender;
    private BigDecimal precioUnitarioCatalogoLocal;
    private BigDecimal valorTotal;
    private BigDecimal importeDescuentoUnitarioLocal;
    private BigDecimal porcentajeDescuento;
    private Boolean productoComisionable;
    private Boolean productoAportaMontoAEscala;
    private Long estadoPosicion;
    private Long oidMarcaProducto;
    private Long oidUnidadNegocio;
    private Long oidNegocio;
    private Long oidSupergenerico;
    private Long oidGenerico;
    private Long oidTipoOferta;
    private Long oidCicloVida;
    private Long oidProducto;
    private Long oidDetalleOferta;
    private Long oidMatriFactu;
    private Boolean indicadorDevolucion;
    private Boolean indicadorAnulacion;
    
    // sapaza -- PER-SiCC-2012-0335 -- 20/04/2012
    private Long oidEscala;
    private Long oidBaseAplicacion;

    public DTOSolicitudPosicionDescuento()  {

    }

    public Long getOidSolicitud()
    {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long newOidSolicitud)
    {
        oidSolicitud = newOidSolicitud;
    }

    public Long getOidPosicion()
    {
        return oidPosicion;
    }

    public void setOidPosicion(Long newOidPosicion)
    {
        oidPosicion = newOidPosicion;
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta)
    {
        codigoVenta = newCodigoVenta;
    }

    public String getDescripcionProducto()
    {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String newDescripcionProducto)
    {
        descripcionProducto = newDescripcionProducto;
    }

    public Long getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(Long newCantidad)
    {
        cantidad = newCantidad;
    }

    public Long getUnidadesPorAtender()
    {
        return unidadesPorAtender;
    }

    public void setUnidadesPorAtender(Long newUnidadesPorAtender)
    {
        unidadesPorAtender = newUnidadesPorAtender;
    }

    public BigDecimal getPrecioUnitarioCatalogoLocal()
    {
        return precioUnitarioCatalogoLocal;
    }

    public void setPrecioUnitarioCatalogoLocal(BigDecimal newPrecioUnitarioCatalogoLocal)
    {
        precioUnitarioCatalogoLocal = newPrecioUnitarioCatalogoLocal;
    }

    public BigDecimal getValorTotal()
    {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal newValorTotal)
    {
        valorTotal = newValorTotal;
    }

    public BigDecimal getImporteDescuentoUnitarioLocal()
    {
        return importeDescuentoUnitarioLocal;
    }

    public void setImporteDescuentoUnitarioLocal(BigDecimal newImporteDescuentoUnitarioLocal)
    {
        importeDescuentoUnitarioLocal = newImporteDescuentoUnitarioLocal;
    }

    public BigDecimal getPorcentajeDescuento()
    {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal newPorcentajeDescuento)
    {
        porcentajeDescuento = newPorcentajeDescuento;
    }

    public Boolean getProductoComisionable()
    {
        return productoComisionable;
    }

    public void setProductoComisionable(Boolean newProductoComisionable)
    {
        productoComisionable = newProductoComisionable;
    }

    public Boolean getProductoAportaMontoAEscala()
    {
        return productoAportaMontoAEscala;
    }

    public void setProductoAportaMontoAEscala(Boolean newProductoAportaMontoAEscala)
    {
        productoAportaMontoAEscala = newProductoAportaMontoAEscala;
    }

    public Long getEstadoPosicion()
    {
        return estadoPosicion;
    }

    public void setEstadoPosicion(Long newEstadoPosicion)
    {
        estadoPosicion = newEstadoPosicion;
    }

    public Long getOidMarcaProducto()
    {
        return oidMarcaProducto;
    }

    public void setOidMarcaProducto(Long newOidMarcaProducto)
    {
        oidMarcaProducto = newOidMarcaProducto;
    }

    public Long getOidUnidadNegocio()
    {
        return oidUnidadNegocio;
    }

    public void setOidUnidadNegocio(Long newOidUnidadNegocio)
    {
        oidUnidadNegocio = newOidUnidadNegocio;
    }

    public Long getOidNegocio()
    {
        return oidNegocio;
    }

    public void setOidNegocio(Long newOidNegocio)
    {
        oidNegocio = newOidNegocio;
    }

    public Long getOidSupergenerico()
    {
        return oidSupergenerico;
    }

    public void setOidSupergenerico(Long newOidSupergenerico)
    {
        oidSupergenerico = newOidSupergenerico;
    }

    public Long getOidGenerico()
    {
        return oidGenerico;
    }

    public void setOidGenerico(Long newOidGenerico)
    {
        oidGenerico = newOidGenerico;
    }

    public Long getOidTipoOferta()
    {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long newOidTipoOferta)
    {
        oidTipoOferta = newOidTipoOferta;
    }

    public Long getOidCicloVida()
    {
        return oidCicloVida;
    }

    public void setOidCicloVida(Long newOidCicloVida)
    {
        oidCicloVida = newOidCicloVida;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto)
    {
        oidProducto = newOidProducto;
    }

  public Long getOidDetalleOferta()
  {
    return oidDetalleOferta;
  }

  public void setOidDetalleOferta(Long oidDetalleOferta)
  {
    this.oidDetalleOferta = oidDetalleOferta;
  }

  public Long getOidMatriFactu()
  {
    return oidMatriFactu;
  }

  public void setOidMatriFactu(Long oidMatriFactu)
  {
    this.oidMatriFactu = oidMatriFactu;
  }

    public Boolean getIndicadorDevolucion() {
        return indicadorDevolucion;
    }

    public void setIndicadorDevolucion(Boolean indicadorDevolucion) {
        this.indicadorDevolucion = indicadorDevolucion;
    }

    public Boolean getIndicadorAnulacion() {
        return indicadorAnulacion;
    }

    public void setIndicadorAnulacion(Boolean indicadorAnulacion) {
        this.indicadorAnulacion = indicadorAnulacion;
    }


    public void setOidEscala(Long oidEscala) {
        this.oidEscala = oidEscala;
    }

    public Long getOidEscala() {
        return oidEscala;
    }

    public void setOidBaseAplicacion(Long oidBaseAplicacion) {
        this.oidBaseAplicacion = oidBaseAplicacion;
    }

    public Long getOidBaseAplicacion() {
        return oidBaseAplicacion;
    }
}
