/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.fac;

import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.mae.DTODireccion;
import java.util.Date;

public class DTOFACCabeceraDocContable extends DTOFACCabeceraSolicitud  {
	public DTOFACCabeceraDocContable() {
		super();
	}

	private Integer numeroDocumentoInterno; 
	private Integer numeroDocumentoLegal;
	private String nombre1;
	private String nombre2; 
	private String apellido1;  
	private String apellido2; 
	private Integer numeroDocumento;    //Incidencia 8584
	private String numeroIdentificacionFiscal;
	private String numeroIdentificacionNacional; 
	private String ejercicioDocumentoContableInterno; //Tipo modificado por la incidencia 10384
	private String puntoEmision;
	private String serieDocumentoInterno;
	private DTODireccion dtoDireccion;
	private String serieDocumentoLegal;
	private String tipoDocumentoReferencia;

	//incidencia 8856
	private Date fechaEmision;
	private Float totalProductos;
	private Float importeTotalVenta;
	private Long numeroAbono;
	private Long oidClienteDireccion;
	private Long oidSolicitud;
	private Long oidFormulario;
	private String tipoDireccion;
	private String marcaConsolidado;
	private Long numeroDocumentoOrigen;
	private String codigoAlmacen;
	private Float precioCatalogoSinImpuestoTotalLocal;
	private Float precioContableSinImpuestoTotalLocal;
	private Float precioCatalogoTotalLocalUnidadesPorAtender;
	private Float precioCatalogoTotalLocal;
	private Float precioContableTotalLocal;
	private Float importeDescuento1TotalLocal;
	private Float importeDescuento1SinImpuestosTotalLocal;
	private Float precioFacturaTotalLocal;
	private Float precioTotalLocal;
	private Float importeDescuento3SinImpuestosTotalLocal;
	private Float importeDescuentoTotalLocal;
	private Float precioNetoTotalLocal;
	private Float importeImpuestosTotalLocal;
	private Float importeRedondeoLocal;
	private Float importeRedondeoConsolidadoLocal;
	//añadidos por la incidencia 9063
	private Float precioCatalogoSinImpuestosTotalDocumento;
	private Float importeDescuento1SinImpuestosTotalDocumento;
	private Float precioTotalDocumento;
    
    //añadido por incidencia 21005
    private String direccionCompleta;

	//private Long subacceso;
	//private Long tipoDocumentoLegal; 
	//private Long sociedad;  
	//private String numeroDocumentoReferencia;
	/*
	 * INCIDENCIA BELC300008592
	 * Los campos sociedad, subAcceso, numeroDocumentoReferencia
	 * y tipoDocumentoLegal se quitaron porque ya están en el dto
	 * DTOFACCabeceraSolicitud del cual hereda
	 * */

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String newApellido1) {
		apellido1 = newApellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String newApellido2) {
		apellido2 = newApellido2;
	}

	public DTODireccion getDtoDireccion() {
		return dtoDireccion;
	}

	public void setDtoDireccion(DTODireccion newDtoDireccion) {
		dtoDireccion = newDtoDireccion;
	}

	public String getEjercicioDocumentoContableInterno() {
		return ejercicioDocumentoContableInterno;
	}

	public void setEjercicioDocumentoContableInterno(String newEjercicioDocumentoContableInterno) {
		ejercicioDocumentoContableInterno = newEjercicioDocumentoContableInterno;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String newNombre1) {
		nombre1 = newNombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String newNombre2) {
		this.nombre2 = newNombre2;
	}

	public Integer getNumeroDocumentoInterno() {
		return this.numeroDocumentoInterno;
	}

	public void setNumeroDocumentoInterno(Integer newNumeroDocumentoInterno) {
		this.numeroDocumentoInterno = newNumeroDocumentoInterno;
	}

	public Integer getNumeroDocumentoLegal() {
		return this.numeroDocumentoLegal;
	}

	public void setNumeroDocumentoLegal(Integer newNumeroDocumentoLegal) {
		this.numeroDocumentoLegal = newNumeroDocumentoLegal;
	}

	public String getNumeroIdentificacionFiscal() {
		return this.numeroIdentificacionFiscal;
	}

	public void setNumeroIdentificacionFiscal(String newNumeroIdentificacionFiscal) {
		this.numeroIdentificacionFiscal = newNumeroIdentificacionFiscal;
	}

	public String getNumeroIdentificacionNacional() {
		return this.numeroIdentificacionNacional;
	}

	public void setNumeroIdentificacionNacional(String newNumeroIdentificacionNacional) {
		this.numeroIdentificacionNacional = newNumeroIdentificacionNacional;
	}

	public String getPuntoEmision() {
		return this.puntoEmision;
	}

	public void setPuntoEmision(String newPuntoEmision) {
		this.puntoEmision = newPuntoEmision;
	}

	public String getSerieDocumentoInterno() {
		return this.serieDocumentoInterno;
	}

	public void setSerieDocumentoInterno(String newSerieDocumentoInterno) {
		this.serieDocumentoInterno = newSerieDocumentoInterno;
	}

	public Integer getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(Integer newNumeroDocumento) {
		this.numeroDocumento = newNumeroDocumento;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}

	public String getTipoDocumentoReferencia() {
		return tipoDocumentoReferencia;
	}

	public void setTipoDocumentoReferencia(String newTipoDocumentoReferencia) {
		tipoDocumentoReferencia = newTipoDocumentoReferencia;
	}

	public String getCodigoAlmacen() {
		return codigoAlmacen;
	}

	public void setCodigoAlmacen(String newCodigoAlmacen) {
		codigoAlmacen = newCodigoAlmacen;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date newFechaEmision) {
		fechaEmision = newFechaEmision;
	}

	public Float getImporteDescuento1SinImpuestosTotalLocal() {
		return importeDescuento1SinImpuestosTotalLocal;
	}

	public void setImporteDescuento1SinImpuestosTotalLocal(Float newImporteDescuento1SinImpuestosTotalLocal) {
		importeDescuento1SinImpuestosTotalLocal = newImporteDescuento1SinImpuestosTotalLocal;
	}

	public Float getImporteDescuento1TotalLocal() {
		return importeDescuento1TotalLocal;
	}

	public void setImporteDescuento1TotalLocal(Float newImporteDescuento1TotalLocal) {
		importeDescuento1TotalLocal = newImporteDescuento1TotalLocal;
	}

	public Float getImporteDescuento3SinImpuestosTotalLocal() {
		return importeDescuento3SinImpuestosTotalLocal;
	}

	public void setImporteDescuento3SinImpuestosTotalLocal(Float newImporteDescuento3SinImpuestosTotalLocal) {
		importeDescuento3SinImpuestosTotalLocal = newImporteDescuento3SinImpuestosTotalLocal;
	}

	public Float getImporteDescuentoTotalLocal() {
		return importeDescuentoTotalLocal;
	}

	public void setImporteDescuentoTotalLocal(Float newImporteDescuentoTotalLocal) {
		importeDescuentoTotalLocal = newImporteDescuentoTotalLocal;
	}

	public Float getImporteImpuestosTotalLocal() {
		return importeImpuestosTotalLocal;
	}

	public void setImporteImpuestosTotalLocal(Float newImporteImpuestosTotalLocal) {
		importeImpuestosTotalLocal = newImporteImpuestosTotalLocal;
	}

	public Float getImporteRedondeoConsolidadoLocal() {
		return importeRedondeoConsolidadoLocal;
	}

	public void setImporteRedondeoConsolidadoLocal(Float newImporteRedondeoConsolidadoLocal) {
		importeRedondeoConsolidadoLocal = newImporteRedondeoConsolidadoLocal;
	}

	public Float getImporteRedondeoLocal() {
		return importeRedondeoLocal;
	}

	public void setImporteRedondeoLocal(Float newImporteRedondeoLocal) {
		importeRedondeoLocal = newImporteRedondeoLocal;
	}

	public Float getImporteTotalVenta() {
		return importeTotalVenta;
	}

	public void setImporteTotalVenta(Float newImporteTotalVenta) {
		importeTotalVenta = newImporteTotalVenta;
	}

	public String getMarcaConsolidado() {
		return marcaConsolidado;
	}

	public void setMarcaConsolidado(String newMarcaConsolidado) {
		marcaConsolidado = newMarcaConsolidado;
	}

	public Long getNumeroAbono() {
		return numeroAbono;
	}

	public void setNumeroAbono(Long newNumeroAbono) {
		numeroAbono = newNumeroAbono;
	}

	public Long getNumeroDocumentoOrigen() {
		return numeroDocumentoOrigen;
	}

	public void setNumeroDocumentoOrigen(Long newNumeroDocumentoOrigen) {
		numeroDocumentoOrigen = newNumeroDocumentoOrigen;
	}

	public Long getOidClienteDireccion() {
		return oidClienteDireccion;
	}

	public void setOidClienteDireccion(Long newOidClienteDireccion) {
		oidClienteDireccion = newOidClienteDireccion;
	}

	public Long getOidFormulario() {
		return oidFormulario;
	}

	public void setOidFormulario(Long newOidFormulario) {
		oidFormulario = newOidFormulario;
	}

	public Long getOidSolicitud() {
		return oidSolicitud;
	}

	public void setOidSolicitud(Long newOidSolicitud) {
		oidSolicitud = newOidSolicitud;
	}

	public Float getPrecioCatalogoSinImpuestoTotalLocal() {
		return precioCatalogoSinImpuestoTotalLocal;
	}

	public void setPrecioCatalogoSinImpuestoTotalLocal(Float newPrecioCatalogoSinImpuestoTotalLocal) {
		precioCatalogoSinImpuestoTotalLocal = newPrecioCatalogoSinImpuestoTotalLocal;
	}

	public Float getPrecioCatalogoTotalLocal() {
		return precioCatalogoTotalLocal;
	}

	public void setPrecioCatalogoTotalLocal(Float newPrecioCatalogoTotalLocal) {
		precioCatalogoTotalLocal = newPrecioCatalogoTotalLocal;
	}

	public Float getPrecioCatalogoTotalLocalUnidadesPorAtender() {
		return precioCatalogoTotalLocalUnidadesPorAtender;
	}

	public void setPrecioCatalogoTotalLocalUnidadesPorAtender(Float newPrecioCatalogoTotalLocalUnidadesPorAtender) {
		precioCatalogoTotalLocalUnidadesPorAtender = newPrecioCatalogoTotalLocalUnidadesPorAtender;
	}

	public Float getPrecioContableSinImpuestoTotalLocal() {
		return precioContableSinImpuestoTotalLocal;
	}

	public void setPrecioContableSinImpuestoTotalLocal(Float newPrecioContableSinImpuestoTotalLocal) {
		precioContableSinImpuestoTotalLocal = newPrecioContableSinImpuestoTotalLocal;
	}

	public Float getPrecioContableTotalLocal() {
		return precioContableTotalLocal;
	}

	public void setPrecioContableTotalLocal(Float newPrecioContableTotalLocal) {
		precioContableTotalLocal = newPrecioContableTotalLocal;
	}

	public Float getPrecioFacturaTotalLocal() {
		return precioFacturaTotalLocal;
	}

	public void setPrecioFacturaTotalLocal(Float newPrecioFacturaTotalLocal) {
		precioFacturaTotalLocal = newPrecioFacturaTotalLocal;
	}

	public Float getPrecioNetoTotalLocal() {
		return precioNetoTotalLocal;
	}

	public void setPrecioNetoTotalLocal(Float newPrecioNetoTotalLocal) {
		precioNetoTotalLocal = newPrecioNetoTotalLocal;
	}

	public Float getPrecioTotalLocal() {
		return precioTotalLocal;
	}

	public void setPrecioTotalLocal(Float newPrecioTotalLocal) {
		precioTotalLocal = newPrecioTotalLocal;
	}

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String newTipoDireccion) {
		tipoDireccion = newTipoDireccion;
	}

	public Float getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(Float newTotalProductos) {
		totalProductos = newTotalProductos;
	}

	public Float getPrecioCatalogoSinImpuestosTotalDocumento() {
		return precioCatalogoSinImpuestosTotalDocumento;
	}

	public void setPrecioCatalogoSinImpuestosTotalDocumento(Float newPrecioCatalogoSinImpuestosTotalDocumento) {
		precioCatalogoSinImpuestosTotalDocumento = newPrecioCatalogoSinImpuestosTotalDocumento;
	}

	public Float getImporteDescuento1SinImpuestosTotalDocumento() {
		return importeDescuento1SinImpuestosTotalDocumento;
	}

	public void setImporteDescuento1SinImpuestosTotalDocumento(Float newImporteDescuento1SinImpuestosTotalDocumento) {
		importeDescuento1SinImpuestosTotalDocumento = newImporteDescuento1SinImpuestosTotalDocumento;
	}

	public Float getPrecioTotalDocumento() {
		return precioTotalDocumento;
	}

	public void setPrecioTotalDocumento(Float newPrecioTotalDocumento) {
		precioTotalDocumento = newPrecioTotalDocumento;
	}

    public String getDireccionCompleta()
    {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta)
    {
        this.direccionCompleta = direccionCompleta;
    }



}