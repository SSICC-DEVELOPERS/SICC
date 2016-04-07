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


package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalObject;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Date;

public interface CabeceraDocumentoContableLocal extends EJBLocalObject  {
	String getApellido1();

	void setApellido1(String newApellido1);

	String getApellido2();

	void setApellido2(String newApellido2);

	Long getClienteDirecion();

	void setClienteDirecion(Long newClienteDirecion);

	String getEjercicioDocumentoInterno();

	void setEjercicioDocumentoInterno(String newEjercicioDocumentoInterno);

	Long getEmpresa();

	void setEmpresa(Long newEmpresa);

	Timestamp getFechaEmision();

	void setFechaEmision(Timestamp newFechaEmision);

	Timestamp getFechaFacturacion();

	void setFechaFacturacion(Timestamp newFechaFacturacion);

	Long getFormaPagoCabecera();

	void setFormaPagoCabecera(Long newFormaPagoCabecera);

	Long getFormulario();

	void setFormulario(Long newFormulario);

	Long getMoneda();

	void setMoneda(Long newMoneda);

	String getNombre1();

	void setNombre1(String newNombre1);

	String getNombre2();

	void setNombre2(String newNombre2);

	Long getNumDocumentoContableInterno();

	void setNumDocumentoContableInterno(Long newNumDocumentoContableInterno);

	String getNumIdentificacionFiscal();

	void setNumIdentificacionFiscal(String newNumIdentificacionFiscal);

	String getNumIdentificacionNacional();

	void setNumIdentificacionNacional(String newNumIdentificacionNacional);

	Integer getNumeroAbono();

	void setNumeroAbono(Integer newNumeroAbono);

	Long getNumeroDocumentoLegal();

	void setNumeroDocumentoLegal(Long newNumeroDocumentoLegal);

	String getObservaciones();

	void setObservaciones(String newObservaciones);

	Long getOid();

	void setOid(Long newOid);

	Long getPais();

	void setPais(Long newPais);

	Long getPeriodo();

	void setPeriodo(Long newPeriodo);

	String getPuntoEmision();

	void setPuntoEmision(String newPuntoEmision);

	Long getRegion();

	void setRegion(Long newRegion);

	Long getSeccion();

	void setSeccion(Long newSeccion);

	String getSerieDocumentolegal();

	void setSerieDocumentolegal(String newSerieDocumentolegal);

	Long getSolicitudCabecera();

	void setSolicitudCabecera(Long newSolicitudCabecera);

	

	void setStatus(Boolean newStatus);

	Long getSubacceso();

	void setSubacceso(Long newSubacceso);

	Long getSugerenciaVenta();

	void setSugerenciaVenta(Long newSugerenciaVenta);

	Long getTerritorio();

	void setTerritorio(Long newTerritorio);

	Long getZona();

	void setZona(Long newZona);

	Boolean getStatus();

	Long getTipoDocumento();

	void setTipoDocumento(Long newTipoDocumento);

	Integer getUnidadesAtendidasTotal();

	void setUnidadesAtendidasTotal(Integer newUnidadesAtendidasTotal);

	BigDecimal getPrecioCatalogoTotalDocumento();

	void setPrecioCatalogoTotalDocumento(BigDecimal newPrecioCatalogoTotalDocumento);

	BigDecimal getPrecioCatalogoSinImpuestoTotalDocumento();

	void setPrecioCatalogoSinImpuestoTotalDocumento(BigDecimal newPrecioCatalogoSinImpuestoTotalDocumento);

	BigDecimal getPrecioContableTotalDocumento();

	void setPrecioContableTotalDocumento(BigDecimal newPrecioContableTotalDocumento);

	BigDecimal getPrecioContableSinImpuestoTotalDocumento();

	void setPrecioContableSinImpuestoTotalDocumento(BigDecimal newPrecioContableSinImpuestoTotalDocumento);

	BigDecimal getImporteDescuento1TotalDocumento();

	void setImporteDescuento1TotalDocumento(BigDecimal newImporteDescuento1TotalDocumento);

	BigDecimal getImporteDescuento1SinImpuestosTotalDocumento();

	void setImporteDescuento1SinImpuestosTotalDocumento(BigDecimal newImporteDescuento1SinImpuestosTotalDocumento);

	BigDecimal getImporteDescuento3SinImpuestoTotalDocumento();

	void setImporteDescuento3SinImpuestoTotalDocumento(BigDecimal newImporteDescuento3SinImpuestoTotalDocumento);

	BigDecimal getImporteDescuentoTotalDocumento();

	void setImporteDescuentoTotalDocumento(BigDecimal newImporteDescuentoTotalDocumento);

	BigDecimal getPrecioFacturaTotalDocumento();

	void setPrecioFacturaTotalDocumento(BigDecimal newPrecioFacturaTotalDocumento);

	BigDecimal getImporteImpuestosTotalDocumento();

	void setImporteImpuestosTotalDocumento(BigDecimal newImporteImpuestosTotalDocumento);

	BigDecimal getPrecioTotalTotalDocumento();

	void setPrecioTotalTotalDocumento(BigDecimal newPrecioTotalTotalDocumento);
    
    public Boolean getIndicadorImpresion();
	public void setNumeroDocumentoOrigen(Long newNumeroDocumentoOrigen);
	public Long getNumeroDocumentoOrigen();
	public void setTipoDireccion(String newTipoDireccion);
	public String getTipoDireccion();
	public void setAlmacen(String newAlmacen);
	public String getAlmacen();
	public void setPrecioCatalogoSinImpuestoTotalLocal(BigDecimal newPrecioCatalogoSinImpuestoTotalLocal);
    public BigDecimal getPrecioCatalogoSinImpuestoTotalLocal();
	public BigDecimal getImporteDescuento1SinImpuestosTotalLocal() ;
	public void setImporteDescuento1SinImpuestosTotalLocal(BigDecimal newImporteDescuento1SinImpuestosTotalLocal);
	public BigDecimal getImporteDescuento1TotalLocal() ;

	public void setImporteDescuento1TotalLocal(BigDecimal newImporteDescuento1TotalLocal);

	public BigDecimal getImporteDescuento3SinImpuestosTotalLocal();

	public void setImporteDescuento3SinImpuestosTotalLocal(BigDecimal newImporteDescuento3SinImpuestosTotalLocal);

	public BigDecimal getImporteDescuento3TotalDocumento();

	public void setImporteDescuento3TotalDocumento(BigDecimal newImporteDescuento3TotalDocumento);

	public BigDecimal getImporteDescuento3TotalLocal();

	public void setImporteDescuento3TotalLocal(BigDecimal newImporteDescuento3TotalLocal);

	public BigDecimal getImporteDescuentoTotalLocal();

	public void setImporteDescuentoTotalLocal(BigDecimal newImporteDescuentoTotalLocal);

	public BigDecimal getImporteFleteSinImpuestosTotalDocumento();

	public void setImporteFleteSinImpuestosTotalDocumento(BigDecimal newImporteFleteSinImpuestosTotalDocumento);

	public BigDecimal getImporteFleteTotalDocumento() ;
	public void setImporteFleteTotalDocumento(BigDecimal newImporteFleteTotalDocumento);

	public BigDecimal getImporteFleteTotalLocal() ;

	public void setImporteFleteTotalLocal(BigDecimal newImporteFleteTotalLocal);

	public BigDecimal getImporteImpuestosTotalLocal();

	public void setImporteImpuestosTotalLocal(BigDecimal newImporteImpuestosTotalLocal);

	public BigDecimal getImporteRedondeoConsolidadoDocumento();

	public void setImporteRedondeoConsolidadoDocumento(BigDecimal newImporteRedondeoConsolidadoDocumento);

	public BigDecimal getImporteRedondeoConsolidadoLocal() ;

	public void setImporteRedondeoConsolidadoLocal(BigDecimal newImporteRedondeoConsolidadoLocal);

	public BigDecimal getImporteRedondeoDocumento();

	public void setImporteRedondeoDocumento(BigDecimal newImporteRedondeoDocumento);

	public BigDecimal getImporteRedondeoLocal() ;

	public void setImporteRedondeoLocal(BigDecimal newImporteRedondeoLocal);
	public BigDecimal getPrecioCatalogoTotalLocal();

	public void setPrecioCatalogoTotalLocal(BigDecimal newPrecioCatalogoTotalLocal);

	public BigDecimal getPrecioCatalogoTotalLocalUnidadesPorAtender() ;

	public void setPrecioCatalogoTotalLocalUnidadesPorAtender(BigDecimal newPrecioCatalogoTotalLocalUnidadesPorAtender);

	public BigDecimal getPrecioContableSinImpuestosTotalLocal();

	public void setPrecioContableSinImpuestosTotalLocal(BigDecimal newPrecioContableSinImpuestosTotalLocal);

	public BigDecimal getPrecioContableTotalLocal();

	public void setPrecioContableTotalLocal(BigDecimal newPrecioContableTotalLocal);

	public BigDecimal getPrecioFacturaTotalLocal() ;

	public void setPrecioFacturaTotalLocal(BigDecimal newPrecioFacturaTotalLocal);

	public BigDecimal getPrecioNetoTotalDocumento();
	public void setPrecioNetoTotalDocumento(BigDecimal newPrecioNetoTotalDocumento);
	public BigDecimal getPrecioNetoTotalLocal() ;
	public void setPrecioNetoTotalLocal(BigDecimal newPrecioNetoTotalLocal);

	public BigDecimal getPrecioTotalTotalLocal();

	public void setPrecioTotalTotalLocal(BigDecimal newPrecioTotalTotalLocal);

	public BigDecimal getTipoCambio();

	public void setTipoCambio(BigDecimal newTipoCambio) ;

	public BigDecimal getTotalAPagarDocumento();

	public void setTotalAPagarDocumento(BigDecimal newTotalAPagarDocumento); 
	
	public BigDecimal getTotalAPagarLocal();

	public void setTotalAPagarLocal(BigDecimal newTotalAPagarLocal) ;
    
    public void setIndicadorImpresion(Boolean newIndicadorImpresion);

    public String getNumeroLoteContabilizacion();

    public void setNumeroLoteContabilizacion(String numeroLoteContabilizacion);

    public Date getFechaContabilizacion();

    public void setFechaContabilizacion(Date fechaContabilizacion);

    BigDecimal getImporteFleteSinImpuestosTotalLocal();

    void setImporteFleteSinImpuestosTotalLocal(BigDecimal importeFleteSinImpuestosTotalLocal);

    String getDireccionCompleta();

    void setDireccionCompleta(String direccionCompleta);
}