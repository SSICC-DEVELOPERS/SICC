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
 */

package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOGenerarPosicionRecuperacion 
 * Fecha:         14/09/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-N0012
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

 /**
  * Modificado se agragan 5 campos mas, segun la especificacion del
  * Modelo de Componentes SICC-DMCO-PED-201-354-N012B
  * Paola Cabrera 
  */
/*
 * Modifcado por Rafael Romero - 23/05/2007 - SiCC 20070261
 * Se agrega un nuevo campo: importeDescuentoUnitarioLocal
 */

public class DTOGenerarPosicionRecuperacion extends DTOAuditableSICC {

    private Long oidPosicion;
    private Integer faltante;
    private Long cvFicticio;
    private BigDecimal porcentajeDescuento;
    private BigDecimal importeDescuentoUnitarioDocumento;
    private Long formaPago;
    private Long periodo;
    private String codigoVenta;
    private Long oidProducto;

	//Agregados 
	private Long detalleOferta;
	private BigDecimal precioCatalogoUnitarioLocal;
	private BigDecimal precioContableUnitarioLocal;
	private BigDecimal precioCatalogoUnitarioDocumento;
	private BigDecimal precioContableUnitarioDocumento;
    
    private BigDecimal importeDescuentoUnitarioLocal;

    public DTOGenerarPosicionRecuperacion() {
    }

    public Long getOidPosicion()
    {
        return oidPosicion;
    }

    public void setOidPosicion(Long newOidPosicion)
    {
        oidPosicion = newOidPosicion;
    }

    public Integer getFaltante()
    {
        return faltante;
    }

    public void setFaltante(Integer newFaltante)
    {
        faltante = newFaltante;
    }

    public Long getCvFicticio()
    {
        return cvFicticio;
    }

    public void setCvFicticio(Long newCvFicticio)
    {
        cvFicticio = newCvFicticio;
    }

    public BigDecimal getPorcentajeDescuento()
    {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal newPorcentajeDescuento)
    {
        porcentajeDescuento = newPorcentajeDescuento;
    }

    public BigDecimal getImporteDescuentoUnitarioDocumento()
    {
        return importeDescuentoUnitarioDocumento;
    }

    public void setImporteDescuentoUnitarioDocumento(BigDecimal newImporteDescuentoUnitarioDocumento)
    {
        importeDescuentoUnitarioDocumento = newImporteDescuentoUnitarioDocumento;
    }

    public Long getFormaPago()
    {
        return formaPago;
    }

    public void setFormaPago(Long newFormaPago)
    {
        formaPago = newFormaPago;
    }

    public Long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Long newPeriodo)
    {
        periodo = newPeriodo;
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta)
    {
        codigoVenta = newCodigoVenta;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto)
    {
        oidProducto = newOidProducto;
    }

	 public Long getDetalleOferta()
    {
        return detalleOferta;
    }

    public void setDetalleOferta(Long newDetalleOferta)
    {
        detalleOferta = newDetalleOferta;
    }

	public BigDecimal getPrecioCatalogoUnitarioLocal()
    {
        return precioCatalogoUnitarioLocal;
    }

    public void setPrecioCatalogoUnitarioLocal(BigDecimal newPrecioCatalogoUnitarioLocal)
    {
        precioCatalogoUnitarioLocal = newPrecioCatalogoUnitarioLocal;
    }	

	public BigDecimal getPrecioContableUnitarioLocal()
    {
        return precioContableUnitarioLocal;
    }

    public void setPrecioContableUnitarioLocal(BigDecimal newPrecioContableUnitarioLocal)
    {
        precioContableUnitarioLocal = newPrecioContableUnitarioLocal;
    }

	public BigDecimal getPrecioCatalogoUnitarioDocumento()
    {
        return precioCatalogoUnitarioDocumento;
    }

    public void setPrecioCatalogoUnitarioDocumento(BigDecimal newPrecioCatalogoUnitarioDocumento)
    {
        precioCatalogoUnitarioDocumento = newPrecioCatalogoUnitarioDocumento;
    }

	public BigDecimal getPrecioContableUnitarioDocumento()
    {
        return precioContableUnitarioDocumento;
    }

    public void setPrecioContableUnitarioDocumento(BigDecimal newPrecioContableUnitarioDocumento)
    {
        precioContableUnitarioDocumento = newPrecioContableUnitarioDocumento;
    }

    public BigDecimal getImporteDescuentoUnitarioLocal() {
        return importeDescuentoUnitarioLocal;
    }

    public void setImporteDescuentoUnitarioLocal(BigDecimal importeDescuentoUnitarioLocal) {
        this.importeDescuentoUnitarioLocal = importeDescuentoUnitarioLocal;
    }



}