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
package es.indra.sicc.dtos.mae;   
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           12/02/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Mario Bobadilla
 */

public class DTOConsultaKit  extends DTOAuditableSICC  {
	private String codSAP ;
	private String codAntiguo; 
	private String descSAP ;
	private String descCorta ;
	private  Boolean indLote ; 
	private String productoServicio ;
	private String unidadNegocio ;
	private String negocio ;
	private String generico ;
	private String supergenerico ;
	private String jerarquia1 ;
	private String jerarquia2 ;
	private String jerarquia3 ;
	private String lineaProducto ;
	private String atributo1 ;
	private String atributo2 ; 
	private String atributo3 ; 
	private Double alto ;
	private Double ancho ;
	private Double largo ; 
	private String unidMedidaDimensiones ;
	private Double volumen ;
	private String unidMedidaVolumen ;
	private Double peso ;
	private String unidMedidaPeso ;
	private Integer unidDentroPedido ;
	private String unidPorCaja ;
	private Double costeEstandar ;
	private Double precioPosicionamiento ;
	private Boolean esSituacionActivo ; 
	private String estatus ;
	private Boolean estaDentroCaja ;  
	private String codPagoFraccionado ; 
	private String codImpuesto ;
	private Double precioCatalogo ;
	private Double precioContable ;
	private Integer porcentajeUnidades ;
	private String marca ;
	private String canal ;
	private String periodoInicio ;
	private String periodoFin ;
	private RecordSet productos ;

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double newAlto) {
		alto = newAlto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double newAncho) {
		ancho = newAncho;
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String newAtributo1) {
		atributo1 = newAtributo1;
	}

	public String getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(String newAtributo2) {
		atributo2 = newAtributo2;
	}

	public String getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(String newAtributo3) {
		atributo3 = newAtributo3;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String newCanal) {
		canal = newCanal;
	}

	public String getCodAntiguo() {
		return codAntiguo;
	}

	public void setCodAntiguo(String newCodAntiguo) {
		codAntiguo = newCodAntiguo;
	}

	public String getCodImpuesto() {
		return codImpuesto;
	}

	public void setCodImpuesto(String newCodImpuesto) {
		codImpuesto = newCodImpuesto;
	}

	public String getCodPagoFraccionado() {
		return codPagoFraccionado;
	}

	public void setCodPagoFraccionado(String newCodPagoFraccionado) {
		codPagoFraccionado = newCodPagoFraccionado;
	}

	public String getCodSAP() {
		return codSAP;
	}

	public void setCodSAP(String newCodSAP) {
		codSAP = newCodSAP;
	}

	public Double getCosteEstandar() {
		return costeEstandar;
	}

	public void setCosteEstandar(Double newCosteEstandar) {
		costeEstandar = newCosteEstandar;
	}

	public String getDescCorta() {
		return descCorta;
	}

	public void setDescCorta(String newDescCorta) {
		descCorta = newDescCorta;
	}

	public String getDescSAP() {
		return descSAP;
	}

	public void setDescSAP(String newDescSAP) {
		descSAP = newDescSAP;
	}

	public Boolean getEsSituacionActivo() {
		return esSituacionActivo;
	}

	public void setEsSituacionActivo(Boolean newEsSituacionActivo) {
		esSituacionActivo = newEsSituacionActivo;
	}

	public Boolean getEstaDentroCaja() {
		return estaDentroCaja;
	}

	public void setEstaDentroCaja(Boolean newEstaDentroCaja) {
		estaDentroCaja = newEstaDentroCaja;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String newEstatus) {
		estatus = newEstatus;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String newGenerico) {
		generico = newGenerico;
	}

	public Boolean getIndLote() {
		return indLote;
	}

	public void setIndLote(Boolean newIndLote) {
		indLote = newIndLote;
	}

	public String getJerarquia1() {
		return jerarquia1;
	}

	public void setJerarquia1(String newJerarquia1) {
		jerarquia1 = newJerarquia1;
	}

	public String getJerarquia2() {
		return jerarquia2;
	}

	public void setJerarquia2(String newJerarquia2) {
		jerarquia2 = newJerarquia2;
	}

	public String getJerarquia3() {
		return jerarquia3;
	}

	public void setJerarquia3(String newJerarquia3) {
		jerarquia3 = newJerarquia3;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double newLargo) {
		largo = newLargo;
	}

	public String getLineaProducto() {
		return lineaProducto;
	}

	public void setLineaProducto(String newLineaProducto) {
		lineaProducto = newLineaProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String newMarca) {
		marca = newMarca;
	}

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String newNegocio) {
		negocio = newNegocio;
	}

	public String getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(String newPeriodoFin) {
		periodoFin = newPeriodoFin;
	}

	public String getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(String newPeriodoInicio) {
		periodoInicio = newPeriodoInicio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double newPeso) {
		peso = newPeso;
	}

	public Integer getPorcentajeUnidades() {
		return porcentajeUnidades;
	}

	public void setPorcentajeUnidades(Integer newPorcentajeUnidades) {
		porcentajeUnidades = newPorcentajeUnidades;
	}

	public Double getPrecioCatalogo() {
		return precioCatalogo;
	}

	public void setPrecioCatalogo(Double newPrecioCatalogo) {
		precioCatalogo = newPrecioCatalogo;
	}

	public Double getPrecioContable() {
		return precioContable;
	}

	public void setPrecioContable(Double newPrecioContable) {
		precioContable = newPrecioContable;
	}

	public Double getPrecioPosicionamiento() {
		return precioPosicionamiento;
	}

	public void setPrecioPosicionamiento(Double newPrecioPosicionamiento) {
		precioPosicionamiento = newPrecioPosicionamiento;
	}

	public String getProductoServicio() {
		return productoServicio;
	}

	public void setProductoServicio(String newProductoServicio) {
		productoServicio = newProductoServicio;
	}

	public RecordSet getProductos() {
		return productos;
	}

	public void setProductos(RecordSet newProductos) {
		productos = newProductos;
	}

	public String getSupergenerico() {
		return supergenerico;
	}

	public void setSupergenerico(String newSupergenerico) {
		supergenerico = newSupergenerico;
	}

	public Integer getUnidDentroPedido() {
		return unidDentroPedido;
	}

	public void setUnidDentroPedido(Integer newUnidDentroPedido) {
		unidDentroPedido = newUnidDentroPedido;
	}

	public String getUnidMedidaDimensiones() {
		return unidMedidaDimensiones;
	}

	public void setUnidMedidaDimensiones(String newUnidMedidaDimensiones) {
		unidMedidaDimensiones = newUnidMedidaDimensiones;
	}

	public String getUnidMedidaPeso() {
		return unidMedidaPeso;
	}

	public void setUnidMedidaPeso(String newUnidMedidaPeso) {
		unidMedidaPeso = newUnidMedidaPeso;
	}

	public String getUnidMedidaVolumen() {
		return unidMedidaVolumen;
	}

	public void setUnidMedidaVolumen(String newUnidMedidaVolumen) {
		unidMedidaVolumen = newUnidMedidaVolumen;
	}

	public String getUnidPorCaja() {
		return unidPorCaja;
	}

	public void setUnidPorCaja(String newUnidPorCaja) {
		unidPorCaja = newUnidPorCaja;
	}

	public String getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(String newUnidadNegocio) {
		unidadNegocio = newUnidadNegocio;
	}

	public Double getVolumen() {
		return volumen;
	}

	public void setVolumen(Double newVolumen) {
		volumen = newVolumen;
	}
			

	
}