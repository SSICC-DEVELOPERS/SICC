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

import es.indra.sicc.util.DTOBelcorp;

//incidencia BELC300008556 
public class DTOFACCalculosCabeceraSalida extends  DTOBelcorp{

    public DTOFACCalculosCabeceraSalida() {
    }

	//se eliminan por :	BELC300008718, BELC300009714, SICC-DMCO-FAC-201-364-N005-2
	//los campos: unidadesDemandaRealTotal, unidadesPorAtenderTotal, unidadesAtendidasTotal     
		//precioCatalogoTotalLocal, precioCatalogoTotalLocalUnidadesPorAtender, precioCatalogoSinImpuestoTotalLocal
		//precioContableTotalLocal, importeDescuento1TotalLocal, importeDescuento1SinImpuestoTotalLocal     
		//precioFacturaTotalLocal, precioCatalogoTotalDocumento, precioCatalogoTotalDocumentoUnidadesPorAtender
	    //precioCatalogoSinImpuestoTotalDocumento, precioContableTotalDocumento, importeDescuento1TotalDocumento   
		//importeDescuento1SinImpuestoTotalDocumento, precioFacturaTotalDocumento, precioTotalTotalLocal     
		//precioTotalTotalDocumento

	//se añaden por incidencia 10134: precioCatalogoTotalLocal, precioCatalogoTotalLocalUnidadesPorAtender, precioCatalogoSinImpuestoTotalLocal
		//precioContableTotalLocal, importeDescuento1TotalLocal, importeDescuento1SinImpuestoTotalLocal     
		//precioFacturaTotalLocal, precioCatalogoTotalDocumento, precioCatalogoTotalDocumentoUnidadesPorAtender
	    //precioCatalogoSinImpuestoTotalDocumento, precioContableTotalDocumento, importeDescuento1TotalDocumento   
		//importeDescuento1SinImpuestoTotalDocumento, precioFacturaTotalDocumento, precioTotalTotalLocal     
		//precioTotalTotalDocumento

	    
    private Float precioCatalogoTotalLocal;     
    private Float precioCatalogoTotalLocalUnidadesPorAtender;     
    private Float precioCatalogoSinImpuestoTotalLocal;     
    private Float precioContableTotalLocal;     
    private Float importeDescuento1TotalLocal;     
    private Float importeDescuento1SinImpuestoTotalLocal;     
    private Float precioFacturaTotalLocal;    
    private Float precioCatalogoTotalDocumento;     
    private Float precioCatalogoTotalDocumentoUnidadesPorAtender;     
    private Float precioCatalogoSinImpuestoTotalDocumento;     
    private Float precioContableTotalDocumento;    
    private Float importeDescuento1TotalDocumento;   
    private Float importeDescuento1SinImpuestoTotalDocumento;     
    private Float precioFacturaTotalDocumento;
	
	
    private Float precioNetoTotalDocumento;     
    private Float precioContableSinImpuestoTotalLocal;     
    private Float importeDescuento3SinImpuestoTotalLocal;     
    private Float importeDescuentoTotalLocal;     
    private Float precioNetoTotalLocal;     
    private Float importeImpuestosTotalLocal;     
    private Float totalAPagarLocal;     
    private Float importeRedondeoLocal;     
    private Float importeRedondeoConsolidadoLocal;     
    private Float precioContableSinImpuestoTotalDocumento;     
    private Float importeDescuento3SinImpuestoTotalDocumento;     
    private Float importeDescuentoTotalDocumento;     
    private Float importeImpuestosTotalDocumento;     
    private Float totalAPagarDocumento;     
    private Float importeRedondeoDocumento;     
    private Float importeRedondeoConsolidadoDocumento;     
	private Integer unidadesDemandaRealTotal; //añadido por incidencia: BELC300009846
	private Integer unidadesPorAtenderTotal;  //añadido por incidencia: BELC300009846
	private Integer unidadesAtendidasTotal;   //añadido por incidencia: BELC300009846
	private Float precioTotalTotalLocal;     
    private Float precioTotalTotalDocumento;
	

	
    public Float getImporteDescuento1SinImpuestoTotalDocumento() {
        return importeDescuento1SinImpuestoTotalDocumento;
    }

    public void setImporteDescuento1SinImpuestoTotalDocumento(Float newImporteDescuento1SinImpuestoTotalDocumento) {
        importeDescuento1SinImpuestoTotalDocumento = newImporteDescuento1SinImpuestoTotalDocumento;
    }

    public Float getImporteDescuento1SinImpuestoTotalLocal() {
        return importeDescuento1SinImpuestoTotalLocal;
    }

    public void setImporteDescuento1SinImpuestoTotalLocal(Float newImporteDescuento1SinImpuestoTotalLocal) {
        importeDescuento1SinImpuestoTotalLocal = newImporteDescuento1SinImpuestoTotalLocal;
    }
		
    public Float getImporteDescuento1TotalDocumento() {
        return importeDescuento1TotalDocumento;
    }

    public void setImporteDescuento1TotalDocumento(Float newImporteDescuento1TotalDocumento) {
        importeDescuento1TotalDocumento = newImporteDescuento1TotalDocumento;
    }

    public Float getImporteDescuento1TotalLocal() {
        return importeDescuento1TotalLocal;
    }

    public void setImporteDescuento1TotalLocal(Float newImporteDescuento1TotalLocal) {
        importeDescuento1TotalLocal = newImporteDescuento1TotalLocal;
    }
	
	
    public Float getImporteDescuento3SinImpuestoTotalDocumento() {
        return importeDescuento3SinImpuestoTotalDocumento;
    }

    public void setImporteDescuento3SinImpuestoTotalDocumento(Float newImporteDescuento3SinImpuestoTotalDocumento) {
        importeDescuento3SinImpuestoTotalDocumento = newImporteDescuento3SinImpuestoTotalDocumento;
    }

    public Float getImporteDescuento3SinImpuestoTotalLocal() {
        return importeDescuento3SinImpuestoTotalLocal;
    }

    public void setImporteDescuento3SinImpuestoTotalLocal(Float newImporteDescuento3SinImpuestoTotalLocal) {
        importeDescuento3SinImpuestoTotalLocal = newImporteDescuento3SinImpuestoTotalLocal;
    }

    public Float getImporteDescuentoTotalDocumento() {
        return importeDescuentoTotalDocumento;
    }

    public void setImporteDescuentoTotalDocumento(Float newImporteDescuentoTotalDocumento) {
        importeDescuentoTotalDocumento = newImporteDescuentoTotalDocumento;
    }

    public Float getImporteDescuentoTotalLocal() {
        return importeDescuentoTotalLocal;
    }

    public void setImporteDescuentoTotalLocal(Float newImporteDescuentoTotalLocal) {
        importeDescuentoTotalLocal = newImporteDescuentoTotalLocal;
    }

    public Float getImporteImpuestosTotalDocumento() {
        return importeImpuestosTotalDocumento;
    }

    public void setImporteImpuestosTotalDocumento(Float newImporteImpuestosTotalDocumento) {
        importeImpuestosTotalDocumento = newImporteImpuestosTotalDocumento;
    }

    public Float getImporteImpuestosTotalLocal() {
        return importeImpuestosTotalLocal;
    }

    public void setImporteImpuestosTotalLocal(Float newImporteImpuestosTotalLocal) {
        importeImpuestosTotalLocal = newImporteImpuestosTotalLocal;
    }

    public Float getImporteRedondeoConsolidadoDocumento() {
        return importeRedondeoConsolidadoDocumento;
    }

    public void setImporteRedondeoConsolidadoDocumento(Float newImporteRedondeoConsolidadoDocumento) {
        importeRedondeoConsolidadoDocumento = newImporteRedondeoConsolidadoDocumento;
    }

    public Float getImporteRedondeoConsolidadoLocal() {
        return importeRedondeoConsolidadoLocal;
    }

    public void setImporteRedondeoConsolidadoLocal(Float newImporteRedondeoConsolidadoLocal) {
        importeRedondeoConsolidadoLocal = newImporteRedondeoConsolidadoLocal;
    }

    public Float getImporteRedondeoDocumento() {
        return importeRedondeoDocumento;
    }

    public void setImporteRedondeoDocumento(Float newImporteRedondeoDocumento) {
        importeRedondeoDocumento = newImporteRedondeoDocumento;
    }

    public Float getImporteRedondeoLocal() {
        return importeRedondeoLocal;
    }

    public void setImporteRedondeoLocal(Float newImporteRedondeoLocal) {
        importeRedondeoLocal = newImporteRedondeoLocal;
    }

	
    public Float getPrecioCatalogoSinImpuestoTotalDocumento() {
        return precioCatalogoSinImpuestoTotalDocumento;
    }

    public void setPrecioCatalogoSinImpuestoTotalDocumento(Float newPrecioCatalogoSinImpuestoTotalDocumento) {
        precioCatalogoSinImpuestoTotalDocumento = newPrecioCatalogoSinImpuestoTotalDocumento;
    }

    public Float getPrecioCatalogoSinImpuestoTotalLocal() {
        return precioCatalogoSinImpuestoTotalLocal;
    }

    public void setPrecioCatalogoSinImpuestoTotalLocal(Float newPrecioCatalogoSinImpuestoTotalLocal) {
        precioCatalogoSinImpuestoTotalLocal = newPrecioCatalogoSinImpuestoTotalLocal;
    }

    public Float getPrecioCatalogoTotalDocumento() {
        return precioCatalogoTotalDocumento;
    }

    public void setPrecioCatalogoTotalDocumento(Float newPrecioCatalogoTotalDocumento) {
        precioCatalogoTotalDocumento = newPrecioCatalogoTotalDocumento;
    }
	
    public Float getPrecioCatalogoTotalDocumentoUnidadesPorAtender() {
        return precioCatalogoTotalDocumentoUnidadesPorAtender;
    }

    public void setPrecioCatalogoTotalDocumentoUnidadesPorAtender(Float newPrecioCatalogoTotalDocumentoUnidadesPorAtender) {
        precioCatalogoTotalDocumentoUnidadesPorAtender = newPrecioCatalogoTotalDocumentoUnidadesPorAtender;
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
	 
	
    public Float getPrecioContableSinImpuestoTotalDocumento() {
        return precioContableSinImpuestoTotalDocumento;
    }

    public void setPrecioContableSinImpuestoTotalDocumento(Float newPrecioContableSinImpuestoTotalDocumento) {
        precioContableSinImpuestoTotalDocumento = newPrecioContableSinImpuestoTotalDocumento;
    }

    public Float getPrecioContableSinImpuestoTotalLocal() {
        return precioContableSinImpuestoTotalLocal;
    }

    public void setPrecioContableSinImpuestoTotalLocal(Float newPrecioContableSinImpuestoTotalLocal) {
        precioContableSinImpuestoTotalLocal = newPrecioContableSinImpuestoTotalLocal;
    }

	
    public Float getPrecioContableTotalDocumento() {
        return precioContableTotalDocumento;
    }

    public void setPrecioContableTotalDocumento(Float newPrecioContableTotalDocumento) {
        precioContableTotalDocumento = newPrecioContableTotalDocumento;
    }
	
    public Float getPrecioContableTotalLocal() {
        return precioContableTotalLocal;
    }

    public void setPrecioContableTotalLocal(Float newPrecioContableTotalLocal) {
        precioContableTotalLocal = newPrecioContableTotalLocal;
    }
	
    public Float getPrecioFacturaTotalDocumento() {
        return precioFacturaTotalDocumento;
    }

    public void setPrecioFacturaTotalDocumento(Float newPrecioFacturaTotalDocumento) {
        precioFacturaTotalDocumento = newPrecioFacturaTotalDocumento;
    }
	
    public Float getPrecioFacturaTotalLocal() {
        return precioFacturaTotalLocal;
    }

    public void setPrecioFacturaTotalLocal(Float newPrecioFacturaTotalLocal) {
        precioFacturaTotalLocal = newPrecioFacturaTotalLocal;
    }
	
    public Integer getUnidadesPorAtenderTotal() {
        return unidadesPorAtenderTotal;
    }

    public void setUnidadesPorAtenderTotal(Integer newUnidadesPorAtenderTotal) {
        unidadesPorAtenderTotal = newUnidadesPorAtenderTotal;
    }
	
    public Integer getUnidadesDemandaRealTotal() {
        return unidadesDemandaRealTotal;
    }

    public void setUnidadesDemandaRealTotal(Integer newUnidadesDemandaRealTotal) {
        unidadesDemandaRealTotal = newUnidadesDemandaRealTotal;
    }
	
    public Integer getUnidadesAtendidasTotal() {
        return unidadesAtendidasTotal;
    }

    public void setUnidadesAtendidasTotal(Integer newUnidadesAtendidasTotal) {
        unidadesAtendidasTotal = newUnidadesAtendidasTotal;
    }
	

    public Float getTotalAPagarLocal() {
        return totalAPagarLocal;
    }

    public void setTotalAPagarLocal(Float newTotalAPagarLocal) {
        totalAPagarLocal = newTotalAPagarLocal;
    }

    public Float getTotalAPagarDocumento() {
        return totalAPagarDocumento;
    }

    public void setTotalAPagarDocumento(Float newTotalAPagarDocumento) {
        totalAPagarDocumento = newTotalAPagarDocumento;
    }

	
    public Float getPrecioTotalTotalDocumento() {
        return precioTotalTotalDocumento;
    }

    public void setPrecioTotalTotalDocumento(Float newPrecioTotalTotalDocumento) {
        precioTotalTotalDocumento = newPrecioTotalTotalDocumento;
    }

    public Float getPrecioTotalTotalLocal() {
        return precioTotalTotalLocal;
    }

    public void setPrecioTotalTotalLocal(Float newPrecioTotalTotalLocal) {
        precioTotalTotalLocal = newPrecioTotalTotalLocal;
    }
	
    public Float getPrecioNetoTotalDocumento() {
        return precioNetoTotalDocumento;
    }

    public void setPrecioNetoTotalDocumento(Float newPrecioNetoTotalDocumento) {
        precioNetoTotalDocumento = newPrecioNetoTotalDocumento;
    }

    public Float getPrecioNetoTotalLocal() {
        return precioNetoTotalLocal;
    }

    public void setPrecioNetoTotalLocal(Float newPrecioNetoTotalLocal) {
        precioNetoTotalLocal = newPrecioNetoTotalLocal;
    }
}	