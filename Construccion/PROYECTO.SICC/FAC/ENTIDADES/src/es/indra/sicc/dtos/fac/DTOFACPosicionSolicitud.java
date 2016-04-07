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

import java.util.Date;

public class DTOFACPosicionSolicitud extends DTOBelcorp{
	private Long indicadorImpuestos; 
	private Float tasaImpuesto;    
	private Float precioContableSinImpuestosUL;    
	private Float precioCatalogoUL;    
	private Float precioContableUL;    
	private Float importeDescuentoSinImpuestosUL;    
	private Float importeDescuentoUL;    
	private Float precioFacturaUL;    
	private Float precioNetoUL;    
	private Float importeImpuestoUL;    
	private Float precioTotalUL;   
	private Float precioContableTL;    
	private Integer unidadesComprometidas;    
	private Float precioCatalogoTL;    
	private Float precioCatalogoTLUnidadesDemandaReal;    
	private Float precioFacturaTL;    
	private Float precioSinImpuestosTL;    
	private Float importeDescuentoTL;    
	private Float importeDescuentoSinImpuestosTL;    
	private Float precioNetoTL;    
	private Float importeImpuestoTL;    
	private Float precioTotalTL;    
	private Float precioContableSinImpuestosUD;    
	private Float precioCatalogoUD;    
	private Float precioContableUD;   
	private Float importeDescuentoSinImpuestosUD;    
	private Float importeDescuentoUD;    
	private Float precioFacturaUD;    
	private Float precioNetoUD;    
	private Float importeImpuestoUD;    
	private Float precioTotalUD;    
	private Float precioContableTD;    
	private Float precioCatalogoTD;    
	private Float precioCatalogoTDUnidadesDemandaReal;    
	private Float precioFacturaTD;    
	private Float precioSinImpuestosTD;    
	private Float importeDescuentoTD;   
	private Float importeDescuentoSinImpuestosTD;    
	private Integer unidadesDemandaReal;    
	private Float precioNetoTD;    
	private Float importeImpuestoTD;    
	private Float precioTotalTD;    
	private Integer unidadesPorAtender;    
	private String codigoProducto;    
	private Float precioSinImpuestosUL;    
	private Float precioSinImpuestosUD;    
	private Long oidPosicion;    
	private Date fecha;    
	private String codigoVenta;   
	private String descripcionSAP;    
	private Long tipoOferta;    
	private Long oidFormaPago;    
	private Long oidCabecera;   
	private Long producto;
	private Boolean indicadorNoImprimible;
	private Integer unidadesAtendidas;
	private Integer numeroPosicion; 
	private String indicadorDentroFueraCajaBolsa;
  private Long numeroConsolidado;
	private Integer catalogo;
	private Integer pagina;
	private Long negocioProducto; 
	Float porcentajeDescuento;
  private String codigoTipoOferta;  
  private Long estado; 
  private Long oidTipoPosicion;
  private Long oidSubtipoPosicion;
  private String decripcionSAPI18N;
  //    Agregado por HRCS - Fecha 12/007/2007 - Incidencia Sicc20070353
  private Long oidDetaOferta;
    private Float precioCosteEstandar;
    private String codigoTipoProgramaConcurso;
    private Float precioContableULAnterior;
    private Float precioContableUDAnterior;
    // vbongiov -- RI 20080679 --3/09/2008
    private Long indicadorProductoServicio;
    
    // Cambio 20090908 - dmorello, 29/06/2009
    private Long oidDocumentoLegalReferencia;
    
    // sapaza -- PER-SiCC-2011-0597 -- 05/09/2011
    private Long oidConcursoSolicitud;
    
    public DTOFACPosicionSolicitud() {
		super();
	}
    
    public Long getOidTipoPosicion() {
        return this.oidTipoPosicion;
    }
    
    public void setOidTipoPosicion(Long newOidTipoPosicion) {
        this.oidTipoPosicion = newOidTipoPosicion;
    }
    
    public Long getOidSubtipoPosicion() {
        return this.oidSubtipoPosicion;
    }
    
    public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
        this.oidSubtipoPosicion = newOidSubtipoPosicion;
    }

	public Integer getCatalogo(){
		return catalogo;
	}

	public void setCatalogo(Integer newCatalogo){
		catalogo = newCatalogo;
	}

	public Integer getPagina(){
		return pagina;
	}

	public void setPagina(Integer newPagina){
		pagina = newPagina;
	}

	public Long getNumeroConsolidado(){
		return numeroConsolidado;
	}

	public void setNumeroConsolidado(Long newNumeroConsolidado){
		numeroConsolidado = newNumeroConsolidado;
	}

	public String getIndicadorDentroFueraCajaBolsa(){
		return indicadorDentroFueraCajaBolsa;
	}

	public void setIndicadorDentroFueraCajaBolsa(String newIndicadorDentroFueraCajaBolsa){
		indicadorDentroFueraCajaBolsa = newIndicadorDentroFueraCajaBolsa;
	}
	
	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String newCodigoProducto) {
		codigoProducto = newCodigoProducto;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(String newCodigoVenta) {
		codigoVenta = newCodigoVenta;
	}

	public String getDescripcionSAP() {
		return descripcionSAP;
	}

	public void setDescripcionSAP(String newDescripcionSAP) {
		descripcionSAP = newDescripcionSAP;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date newFecha) {
		fecha = newFecha;
	}

	public Float getImporteDescuentoSinImpuestosTD() {
		return importeDescuentoSinImpuestosTD;
	}

	public void setImporteDescuentoSinImpuestosTD(Float newImporteDescuentoSinImpuestosTD) {
		importeDescuentoSinImpuestosTD = newImporteDescuentoSinImpuestosTD;
	}

	public Float getImporteDescuentoSinImpuestosTL() {
		return importeDescuentoSinImpuestosTL;
	}

	public void setImporteDescuentoSinImpuestosTL(Float newImporteDescuentoSinImpuestosTL) {
		importeDescuentoSinImpuestosTL = newImporteDescuentoSinImpuestosTL;
	}

	public Float getImporteDescuentoSinImpuestosUD() {
		return importeDescuentoSinImpuestosUD;
	}

	public void setImporteDescuentoSinImpuestosUD(Float newImporteDescuentoSinImpuestosUD) {
		importeDescuentoSinImpuestosUD = newImporteDescuentoSinImpuestosUD;
	}

	public Float getImporteDescuentoSinImpuestosUL() {
		return importeDescuentoSinImpuestosUL;
	}

	public void setImporteDescuentoSinImpuestosUL(Float newImporteDescuentoSinImpuestosUL) {
		importeDescuentoSinImpuestosUL = newImporteDescuentoSinImpuestosUL;
	}

	public Float getImporteDescuentoTD() {
		return importeDescuentoTD;
	}

	public void setImporteDescuentoTD(Float newImporteDescuentoTD) {
		importeDescuentoTD = newImporteDescuentoTD;
	}

	public Float getImporteDescuentoTL() {
		return importeDescuentoTL;
	}

	public void setImporteDescuentoTL(Float newImporteDescuentoTL) {
		importeDescuentoTL = newImporteDescuentoTL;
	}

	public Float getImporteDescuentoUD() {
		return importeDescuentoUD;
	}

	public void setImporteDescuentoUD(Float newImporteDescuentoUD) {
		importeDescuentoUD = newImporteDescuentoUD;
	}

	public Float getImporteDescuentoUL() {
		return importeDescuentoUL;
	}

	public void setImporteDescuentoUL(Float newImporteDescuentoUL) {
		importeDescuentoUL = newImporteDescuentoUL;
	}

	public Float getImporteImpuestoTD() {
		return importeImpuestoTD;
	}

	public void setImporteImpuestoTD(Float newImporteImpuestoTD) {
		importeImpuestoTD = newImporteImpuestoTD;
	}

	public Float getImporteImpuestoTL() {
		return importeImpuestoTL;
	}

	public void setImporteImpuestoTL(Float newImporteImpuestoTL) {
		importeImpuestoTL = newImporteImpuestoTL;
	}

	public Float getImporteImpuestoUD() {
		return importeImpuestoUD;
	}

	public void setImporteImpuestoUD(Float newImporteImpuestoUD) {
		importeImpuestoUD = newImporteImpuestoUD;
	}

	public Float getImporteImpuestoUL() {
		return importeImpuestoUL;
	}

	public void setImporteImpuestoUL(Float newImporteImpuestoUL) {
		importeImpuestoUL = newImporteImpuestoUL;
	}

	public Long getIndicadorImpuestos() {
		return indicadorImpuestos;
	}

	public Long getOidCabecera() {
		return oidCabecera;
	}

	public void setOidCabecera(Long newOidCabecera) {
		oidCabecera = newOidCabecera;
	}

	public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
	}

	public Long getOidPosicion() {
		return oidPosicion;
	}

	public void setOidPosicion(Long newOidPosicion) {
		oidPosicion = newOidPosicion;
	}

	public Float getPrecioCatalogoTD() {
		return precioCatalogoTD;
	}

	public void setPrecioCatalogoTD(Float newPrecioCatalogoTD) {
		precioCatalogoTD = newPrecioCatalogoTD;
	}

	public Float getPrecioCatalogoTDUnidadesDemandaReal() {
		return precioCatalogoTDUnidadesDemandaReal;
	}

	public void setPrecioCatalogoTDUnidadesDemandaReal(Float newPrecioCatalogoTDUnidadesDemandaReal) {
		precioCatalogoTDUnidadesDemandaReal = newPrecioCatalogoTDUnidadesDemandaReal;
	}

	public Float getPrecioCatalogoTL() {
		return precioCatalogoTL;
	}

	public void setPrecioCatalogoTL(Float newPrecioCatalogoTL) {
		precioCatalogoTL = newPrecioCatalogoTL;
	}

	public Float getPrecioCatalogoTLUnidadesDemandaReal() {
		return precioCatalogoTLUnidadesDemandaReal;
	}

	public void setPrecioCatalogoTLUnidadesDemandaReal(Float newPrecioCatalogoTLUnidadesDemandaReal) {
		precioCatalogoTLUnidadesDemandaReal = newPrecioCatalogoTLUnidadesDemandaReal;
	}

	public Float getPrecioCatalogoUD() {
		return precioCatalogoUD;
	}

	public void setPrecioCatalogoUD(Float newPrecioCatalogoUD) {
		precioCatalogoUD = newPrecioCatalogoUD;
	}

	public Float getPrecioCatalogoUL() {
		return precioCatalogoUL;
	}

	public void setPrecioCatalogoUL(Float newPrecioCatalogoUL) {
		precioCatalogoUL = newPrecioCatalogoUL;
	}

	public Float getPrecioContableSinImpuestosUD() {
		return precioContableSinImpuestosUD;
	}

	public void setPrecioContableSinImpuestosUD(Float newPrecioContableSinImpuestosUD) {
		precioContableSinImpuestosUD = newPrecioContableSinImpuestosUD;
	}

	public Float getPrecioContableSinImpuestosUL() {
		return precioContableSinImpuestosUL;
	}

	public void setPrecioContableSinImpuestosUL(Float newPrecioContableSinImpuestosUL) {
		precioContableSinImpuestosUL = newPrecioContableSinImpuestosUL;
	}

	public Float getPrecioContableTD() {
		return precioContableTD;
	}

	public void setPrecioContableTD(Float newPrecioContableTD) {
		precioContableTD = newPrecioContableTD;
	}

	public Float getPrecioContableTL() {
		return precioContableTL;
	}

	public void setPrecioContableTL(Float newPrecioContableTL) {
		precioContableTL = newPrecioContableTL;
	}

	public Float getPrecioContableUD() {
		return precioContableUD;
	}

	public void setPrecioContableUD(Float newPrecioContableUD) {
		precioContableUD = newPrecioContableUD;
	}

	public Float getPrecioContableUL() {
		return precioContableUL;
	}

	public void setPrecioContableUL(Float newPrecioContableUL) {
		precioContableUL = newPrecioContableUL;
	}

	public Float getPrecioFacturaTD() {
		return precioFacturaTD;
	}

	public void setPrecioFacturaTD(Float newPrecioFacturaTD) {
		precioFacturaTD = newPrecioFacturaTD;
	}

	public Float getPrecioFacturaTL() {
		return precioFacturaTL;
	}

	public void setPrecioFacturaTL(Float newPrecioFacturaTL) {
		precioFacturaTL = newPrecioFacturaTL;
	}

	public Float getPrecioFacturaUD() {
		return precioFacturaUD;
	}

	public void setPrecioFacturaUD(Float newPrecioFacturaUD) {
		precioFacturaUD = newPrecioFacturaUD;
	}

	public Float getPrecioFacturaUL() {
		return precioFacturaUL;
	}

	public void setPrecioFacturaUL(Float newPrecioFacturaUL) {
		precioFacturaUL = newPrecioFacturaUL;
	}

	public Float getPrecioNetoTD() {
		return precioNetoTD;
	}

	public void setPrecioNetoTD(Float newPrecioNetoTD) {
		precioNetoTD = newPrecioNetoTD;
	}

	public Float getPrecioNetoTL() {
		return precioNetoTL;
	}

	public void setPrecioNetoTL(Float newPrecioNetoTL) {
		precioNetoTL = newPrecioNetoTL;
	}

	public Float getPrecioNetoUD() {
		return precioNetoUD;
	}

	public void setPrecioNetoUD(Float newPrecioNetoUD) {
		precioNetoUD = newPrecioNetoUD;
	}

	public Float getPrecioNetoUL() {
		return precioNetoUL;
	}

	public void setPrecioNetoUL(Float newPrecioNetoUL) {
		precioNetoUL = newPrecioNetoUL;
	}

	public Float getPrecioSinImpuestosTD() {
		return precioSinImpuestosTD;
	}

	public void setPrecioSinImpuestosTD(Float newPrecioSinImpuestosTD) {
		precioSinImpuestosTD = newPrecioSinImpuestosTD;
	}

	public Float getPrecioSinImpuestosTL() {
		return precioSinImpuestosTL;
	}

	public void setPrecioSinImpuestosTL(Float newPrecioSinImpuestosTL) {
		precioSinImpuestosTL = newPrecioSinImpuestosTL;
	}

	public Float getPrecioSinImpuestosUD() {
		return precioSinImpuestosUD;
	}

	public void setPrecioSinImpuestosUD(Float newPrecioSinImpuestosUD) {
		precioSinImpuestosUD = newPrecioSinImpuestosUD;
	}

	public Float getPrecioSinImpuestosUL() {
		return precioSinImpuestosUL;
	}

	public void setPrecioSinImpuestosUL(Float newPrecioSinImpuestosUL) {
		precioSinImpuestosUL = newPrecioSinImpuestosUL;
	}

	public Float getPrecioTotalTD() {
		return precioTotalTD;
	}

	public void setPrecioTotalTD(Float newPrecioTotalTD) {
		precioTotalTD = newPrecioTotalTD;
	}

	public Float getPrecioTotalTL() {
		return precioTotalTL;
	}

	public void setPrecioTotalTL(Float newPrecioTotalTL) {
		precioTotalTL = newPrecioTotalTL;
	}

	public Float getPrecioTotalUD() {
		return precioTotalUD;
	}

	public void setPrecioTotalUD(Float newPrecioTotalUD) {
		precioTotalUD = newPrecioTotalUD;
	}

	public Float getPrecioTotalUL() {
		return precioTotalUL;
	}

	public void setPrecioTotalUL(Float newPrecioTotalUL) {
		precioTotalUL = newPrecioTotalUL;
	}

	public Float getTasaImpuesto() {
		return tasaImpuesto;
	}

	public void setTasaImpuesto(Float newTasaImpuesto) {
		tasaImpuesto = newTasaImpuesto;
	}

	public Long getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Long newTipoOferta) {
		tipoOferta = newTipoOferta;
	}

	public Integer getUnidadesComprometidas() {
		return unidadesComprometidas;
	}

	public void setUnidadesComprometidas(Integer newUnidadesComprometidas) {
		unidadesComprometidas = newUnidadesComprometidas;
	}

	public Integer getUnidadesDemandaReal() {
		return unidadesDemandaReal;
	}

	public void setUnidadesDemandaReal(Integer newUnidadesDemandaReal) {
		unidadesDemandaReal = newUnidadesDemandaReal;
	}

	public Integer getUnidadesPorAtender() {
		return unidadesPorAtender;
	}

	public void setUnidadesPorAtender(Integer newUnidadesPorAtender) {
		unidadesPorAtender = newUnidadesPorAtender;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long newProducto) {
		producto = newProducto;
	}

	public Boolean getIndicadorNoImprimible() {
		return indicadorNoImprimible;
	}

	public void setIndicadorNoImprimible(Boolean newIndicadorNoImprimible) {
		indicadorNoImprimible = newIndicadorNoImprimible;
	}

	public Integer getUnidadesAtendidas() {
		return unidadesAtendidas;
	}

	public void setUnidadesAtendidas(Integer newUnidadesAtendidas) {
		unidadesAtendidas = newUnidadesAtendidas;
	}

	public Integer getNumeroPosicion() {
		return numeroPosicion;
	}

	public void setNumeroPosicion(Integer newNumeroPosicion) {
		numeroPosicion = newNumeroPosicion;
	}

	public void setIndicadorImpuestos(Long newIndicadorImpuestos) {
		indicadorImpuestos = newIndicadorImpuestos;
	}

	public Long getNegocioProducto() {
		return negocioProducto;
	}

	public void setNegocioProducto(Long newNegocioProducto) {
		negocioProducto = newNegocioProducto;
	}

	public Float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Float newPorcentajeDescuento) {
		porcentajeDescuento = newPorcentajeDescuento;
	}

  public String getCodigoTipoOferta(){
    return codigoTipoOferta;
 }

 public void setCodigoTipoOferta(String codigoTipoOferta) {
    this.codigoTipoOferta = codigoTipoOferta;
 }

 public Long getEstado() {
    return estado;
 }

 public void setEstado(Long estado) {
    this.estado = estado;
 }

  public String getDecripcionSAPI18N() {
    return decripcionSAPI18N;
  }

  public void setDecripcionSAPI18N(String decripcionSAPI18N) {
    this.decripcionSAPI18N = decripcionSAPI18N;
  }


    public void setOidDetaOferta(Long oidDetaOferta) {
        this.oidDetaOferta = oidDetaOferta;
    }


    public Long getOidDetaOferta() {
        return oidDetaOferta;
    }

    public Float getPrecioCosteEstandar() {
        return precioCosteEstandar;
    }

    public void setPrecioCosteEstandar(Float precioCosteEstandar) {
        this.precioCosteEstandar = precioCosteEstandar;
    }

    public String getCodigoTipoProgramaConcurso() {
        return codigoTipoProgramaConcurso;
    }

    public void setCodigoTipoProgramaConcurso(String codigoTipoProgramaConcurso) {
        this.codigoTipoProgramaConcurso = codigoTipoProgramaConcurso;
    }

    public Float getPrecioContableULAnterior() {
        return precioContableULAnterior;
    }

    public void setPrecioContableULAnterior(Float precioContableULAnterior) {
        this.precioContableULAnterior = precioContableULAnterior;
    }

    public Float getPrecioContableUDAnterior() {
        return precioContableUDAnterior;
    }

    public void setPrecioContableUDAnterior(Float precioContableUDAnterior) {
        this.precioContableUDAnterior = precioContableUDAnterior;
    }

    public Long getIndicadorProductoServicio()
    {
        return indicadorProductoServicio;
    }

    public void setIndicadorProductoServicio(Long indicadorProductoServicio)
    {
        this.indicadorProductoServicio = indicadorProductoServicio;
    }

    public void setOidDocumentoLegalReferencia(Long oidDocumentoLegalReferencia) {
        this.oidDocumentoLegalReferencia = oidDocumentoLegalReferencia;
    }

    public Long getOidDocumentoLegalReferencia() {
        return oidDocumentoLegalReferencia;
    }

    public void setOidConcursoSolicitud(Long oidConcursoSolicitud) {
        this.oidConcursoSolicitud = oidConcursoSolicitud;
    }

    public Long getOidConcursoSolicitud() {
        return oidConcursoSolicitud;
    }
}
