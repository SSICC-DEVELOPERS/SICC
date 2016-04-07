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

import java.math.BigDecimal;

import java.util.Date;
import java.lang.Cloneable;

//import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;

public class DTOFACCabeceraSolicitud extends DTOBelcorp implements Cloneable {

	private Float importeDescuento1TotalLocal;     
	private Float precioContableTotalLocal;     
	private Float totalAPagarLocal;     
	private Float precioTotalTotalLocal;    
	private Date fechaPrevistaFacturacion;     
	private Integer numeroClientes;     
	private Long tipoSolicitud;     
	private Long moneda;     
	private Long tipoDespacho;     
	private Long almacen;     
	private Long modulo;     
	private Long tipoCliente;     
	private Long periodo;     
	private String codigoCliente;//Incidencia BELC300008115     
	private Long oidCliente;     
	private Long receptorFactura; //se mantiene por integración con APP y N011A  
		//ver incidencia: BELC300009793. Incidencia BELC300008611.
	//private Long oidReceptorFactura;   se elimina por que se usa receptorFactura   
	//private String pagadorFactura;  // se elimina. incidencia BELC300009793     
	private Long oidPagadorFactura;     
	//private Long destino; eliminado por la incidencia BELC300008624
						//  cambio ya contemplado en SICC-DMCO-FAC-201-364-N005-2 
	private Long tipoDocumento;     
	private Long sociedad;     
	private Long subacceso;     
	private Long territorio;     
	private Long zona;     
	private Boolean indicadorAplicacionManual; //Incidencia BELC300008616  
	private Boolean indicadorPedidoPrueba; //Incidencia BELC300008616
	private Boolean indicadorOrdenCompra; //Incidencia BELC300008616
	private Boolean indicadorExentoFlete; //Incidencia BELC300008616
	private Long numeroSolicitud;     
	private String usuario;     
	private Date fecha;   
	private Boolean permiteUnionSolicitudes;     
	private Boolean indPedidoPrueba;     
	private Boolean indTSNoConsolidado;     
	private String observaciones;     
	private Long tipoDocumentoLegal;     
	private Long ubigeo;     
	private Long estado; // Incidencia BELC300008725    
	private Long subtipoCliente;    
	private Long accesoFisico;     
	private Long formaPago;     
	private Long claseSolicitud;     
	private Long operacion;     
	private Long proceso;     
	//private Boolean ordenCompra; se elimina por control cambios 20-09-2004     
	private Long tipoConsolidado;     
	private Long marca;     
	private Long canal;     
	private Long acceso;     
	private Long subgerencia;     
	private Long region;     
	private Long seccion;     
	private Boolean monofacturacion;          
	private String mensajeError;     
	private Boolean indMasSolicitudes;     
	private Boolean indicadorDigitacion;     
	private Long destinatario;     
	private Long oidConcursoParametros;     
	private Long oidDocumentoReferencia;     
	private Integer numeroPremio;     
	private Long consultoraAsociada;     
	private Long oidCabeceraSolicitud;     
	private Long numeroDocumentoOrigen;     
	private BigDecimal tipoCambio;     
	private Long grupoProcesos;     
	private Float importeDescuento3TotalLocal;     
	private Float importeDescuentoTotalLocal;     
	private Long indicadorImpuestosFlete;     
	private Float importeDescuento3TotalDocumento;     
	private Float importeDescuento1TotalDocumento;     
	private Float baseFleteLocal;     
	private Float importeFleteLocal;     
	private Float recargoFleteLocal;     
	private Float otrosRecargosLocal;     
	private Float totalFleteLocal;     
	private Float importeFleteTotalLocal;     
	private Float baseFleteDocumento;     
	private Float importeFleteDocumento;     
	private Float recargoFleteDocumento;     
	private Float otrosRecargosDocumento;     
	private Float totalFleteDocumento;     
	private Float importeFleteTotalDocumento;     
	//private DTOFACPosicionSolicitud dtoPosicion;    eliminado por control cambios 20-09-2004     
	private Long estadoCredito; // incidencias: 8624 y 9732
	private Integer numeroSecuenciaZonaRuta;    
  private Long numeroConsolidado;
	//private Long pais;     eliminado, se usa el oidPais 
	private Long tipoSolicitudConsolidado;     
	private Long tipoSolicitudDocumentoReferencia;     
	private Long canalDocumentoReferencia;     
	private Long accesoDocumentoReferencia;     
	private Long subaccesoDocumentoReferencia;     
    private Integer numeroDocumentoReferencia;  // Cambio el tipo por INCIDENCIA BELC300011833
	private Date fechaFacturacion;  //añadido por SICC-DMCO-FAC-201-364-N005-2   
	//private Long codigoTipoCliente;      eliminado por control cambios 20-09-2004  
	private Boolean indicadorEstadisticable; //Incidencia BELC300008115 
	private Long numeroLoteFacturacion;// incidencias: 8624 y 9732
	private Boolean indicadorImpresion; //Incidencia BELC300008616  
	private Boolean indicadorGeneraCuentaCorriente; //Incidencia BELC300008616
	private Long indicadorRevision; //Incidencia BELC300008616. Cambiado a Long por incidencia BELC300008721
	private Long canalConsolidado;     
	private Long accesoConsolidado; // cambio de Float a Long por control cambios 20-09-2004
	private Float subaccesoConsolidado;     
	private Float totalAPagarDocumento;     
	private Long oidSubgVentas; //se mantiene por integración con APP y N011A 
		//ver incidencia BELC300009793        
	//private String glosa;  se elimina por redundacia: observaciones
		//ver incidencia BELC300009793
	private String secuenciaRutaTerritorio; //Incidencia BELC300008611
	private Integer numeroSecuenciaFacturacionDiaria;
	private Long tipoRevision;
	private Float importeDescuentoTotalDocumento;
	private Integer numeroDecimalesRedondeo; //Incidencia BELC300008637
	private String puntoEmision;//añadidos por el diseño del n11   
	//private Long oidSolicitudCabeceraSecuencia; se elimina porque ahora se utiliza oidCabeceraSolicitud
		//ver incidencia BELC300009793
	private Float importeFleteSinImpuestosTotalLocal;//añadidos por el diseño del n11  
	private Float importeFleteSinImpuestosTotalDocumento; //añadidos por el diseño del n11
	private Long territorioCliente;
	private Float precioTotalTotalDocumento; //añadido por incidencia BELC300009752
	private Long oidDireccionCliente; //añadido por incidencia 8624, ya contemplado en SICC-DMCO-FAC-201-364-N005-2 
	private Long tipoClasificacion; //añadido por SICC-DMCO-FAC-201-364-N005-2  
	private Long oidConsolidado; //añadido por SICC-DMCO-FAC-201-364-N005-2
	private Float tasaImpuesto; //añadido por SICC-DMCO-FAC-201-364-N005-2
	private Long clasificacion; //añadido por SICC-DMCO-FAC-201-364-N005-2
	private Float importeRedondeoConsolidadoDocumento; //añadido por incidencias: 8624, 9793 
	private Float importeRedondeoConsolidadoLocal;	//añadido por incidencias: 8624, 9793
	private Integer unidadesDemandaRealTotal; //añadido por incidencia: BELC300009846 
	private Integer unidadesPorAtenderTotal;  //añadido por incidencia: BELC300009846
	private Integer unidadesAtendidasTotal;	//añadido por incidencia: BELC300009846
	private Float precioContableSinImpuestosTotalLocal; //añadido por incidencia: BELC300009846
	private Float precioContableSinImpuestosTotalDocumento; //añadido por incidencia: BELC300009846
	private Float importeDescuento3SinImpuestosTotalLocal; //añadido por incidencia: BELC300009846
	private Float importeDescuento3SinImpuestosTotalDocumento; //añadido por incidencia: BELC300009846
	private Float precioNetoTotalLocal; //añadido por incidencia: BELC300009846
	private Float precioNetoTotalDocumento; //añadido por incidencia: BELC300009846
	private Float importeImpuestosTotalLocal; //añadido por incidencia: BELC300009846
	private Float importeImpuestosTotalDocumento; //añadido por incidencia: BELC300009846
	private Float precioCatalogoTotalDocumento; //añadido por incidencia: 10134
	private Float precioCatalogoTotalDocumentoUnidadesPorAtender; //añadido por incidencia: 10134
	private Float importeDescuento1SinImpuestoTotalDocumento; //añadido por incidencia: 10134
	private Float precioFacturaTotalDocumento; //añadido por incidencia: 10134
	private Float precioCatalogoTotalLocalUnidadesPorAtender; //añadido por incidencia: 10134
	private Float precioCatalogoSinImpuestoTotalLocal; //añadido por incidencia: 10134
	private Float importeDescuento1SinImpuestoTotalLocal; //añadido por incidencia: 10134
	private Float precioFacturaTotalLocal; //añadido por incidencia: 10134
	private Float precioCatalogoTotalLocal; //añadido por incidencia: 10134 	
	private Float precioCatalogoSinImpuestoTotalDocumento; //añadido por incidencia: 10134
	private Float importeRedondeoDocumento;		//añadido por incidencia 10134
	private Float importeRedondeoLocal; 		//añadido por incidencia 10134
	private Float precioContableTotalDocumento;	//añadido por incidencia 10134
	private Long numeroDocumentoContableInterno;//cambios paquete n21(FAC)
    //se agrega por la incidencia 19102: Para retrasar la insercion de datos
    //despues de la llamada a insertarConsolidado
	private Long oidRuta;
    private Integer numeroSecuenciaImpresion; //añadido por incidencia 19633
    private Boolean indClaseOC;
    private Long oidTipoConcursoPrograma;
    private String codigoTipoProgramaConcu;
    private Long numeroUnidadesAtendidasTotal;
    private String numeroConcurso;
    private String nombreConcurso;
    private Float importeTipoPrograma;
    private Float tasaImpuestoUbigeo;
    private Long oidTasaImpuestoUbigeo;
    private Float tasaImpuestoFlete;
    private String origenChequeo; //añadido por incidencia BELC400000459(APE)
    /* jrivas REC-001  */
    private Date fechaEntrega;
    private Boolean indPedidoServicio;
    /* jrivas REC-001  */
    /* Agregado por Cambio FAC-001 ------ AL */
    private Boolean indicadorIVAasumido;
    private Long porcIVAasumido;
    private Float IVAasumidoEmpresa;
    private Boolean indicadorDireccionSeparada;
    private Long indicadorAgrupReclamos;
    /* Agregado por Cambio FAC-001 ------ AL */

	
	
	public DTOFACCabeceraSolicitud() {
		super();
	}
	
	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getAccesoConsolidado() {
		return accesoConsolidado;
	}

	public void setAccesoConsolidado(Long newAccesoConsolidado) {
		accesoConsolidado = newAccesoConsolidado;
	}

	public Long getAccesoDocumentoReferencia() {
		return accesoDocumentoReferencia;
	}

	public void setAccesoDocumentoReferencia(Long newAccesoDocumentoReferencia) {
		accesoDocumentoReferencia = newAccesoDocumentoReferencia;
	}

	public Long getAccesoFisico() {
		return accesoFisico;
	}

	public void setAccesoFisico(Long newAccesoFisico) {
		accesoFisico = newAccesoFisico;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Long newAlmacen) {
		almacen = newAlmacen;
	}

	public Float getBaseFleteDocumento() {
		return baseFleteDocumento;
	}

	public void setBaseFleteDocumento(Float newBaseFleteDocumento) {
		baseFleteDocumento = newBaseFleteDocumento;
	}

	public Float getBaseFleteLocal() {
		return baseFleteLocal;
	}

	public void setBaseFleteLocal(Float newBaseFleteLocal) {
		baseFleteLocal = newBaseFleteLocal;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getCanalConsolidado() {
		return canalConsolidado;
	}

	public void setCanalConsolidado(Long newCanalConsolidado) {
		canalConsolidado = newCanalConsolidado;
	}

	public Long getCanalDocumentoReferencia() {
		return canalDocumentoReferencia;
	}

	public void setCanalDocumentoReferencia(Long newCanalDocumentoReferencia) {
		canalDocumentoReferencia = newCanalDocumentoReferencia;
	}

	public Long getClaseSolicitud() {
		return claseSolicitud;
	}

	public void setClaseSolicitud(Long newClaseSolicitud) {
		claseSolicitud = newClaseSolicitud;
	}

	/*
	public Long getCodigoTipoCliente() {
		return codigoTipoCliente;
	}

	public void setCodigoTipoCliente(Long newCodigoTipoCliente) {
		codigoTipoCliente = newCodigoTipoCliente;
	}
	*/

	public Long getConsultoraAsociada() {
		return consultoraAsociada;
	}

	public void setConsultoraAsociada(Long newConsultoraAsociada) {
		consultoraAsociada = newConsultoraAsociada;
	}

	public Long getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Long newDestinatario) {
		destinatario = newDestinatario;
	}

	/*
	public Long getDestino() {
		return destino;
	}
	

	public void setDestino(Long newDestino) {
		destino = newDestino;
	}
	*/

	/*
	public DTOFACPosicionSolicitud getDtoPosicion() {
		return dtoPosicion;
	}

	public void setDtoPosicion(DTOFACPosicionSolicitud newDtoPosicion) {
		dtoPosicion = newDtoPosicion;
	}
	*/

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long newEstado) {
		estado = newEstado;
	}

	public Long getEstadoCredito() {
		return estadoCredito;
	}

	public void setEstadoCredito(Long newEstadoCredito) {
		estadoCredito = newEstadoCredito;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date newFecha) {
		fecha = newFecha;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date newFechaFacturacion) {
		fechaFacturacion = newFechaFacturacion;
	}

	public Date getFechaPrevistaFacturacion() {
		return fechaPrevistaFacturacion;
	}

	public void setFechaPrevistaFacturacion(Date newFechaPrevistaFacturacion) {
		fechaPrevistaFacturacion = newFechaPrevistaFacturacion;
	}

	public Long getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Long newFormaPago) {
		formaPago = newFormaPago;
	}

	/*
	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String newGlosa) {
		glosa = newGlosa;
	}
	*/

	public Long getGrupoProcesos() {
		return grupoProcesos;
	}

	public void setGrupoProcesos(Long newGrupoProcesos) {
		grupoProcesos = newGrupoProcesos;
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

	public Float getImporteDescuento3TotalDocumento() {
		return importeDescuento3TotalDocumento;
	}

	public void setImporteDescuento3TotalDocumento(Float newImporteDescuento3TotalDocumento) {
		importeDescuento3TotalDocumento = newImporteDescuento3TotalDocumento;
	}

	public Float getImporteDescuento3TotalLocal() {
		return importeDescuento3TotalLocal;
	}

	public void setImporteDescuento3TotalLocal(Float newImporteDescuento3TotalLocal) {
		importeDescuento3TotalLocal = newImporteDescuento3TotalLocal;
	}

	public Float getImporteDescuentoTotalLocal() {
		return importeDescuentoTotalLocal;
	}

	public void setImporteDescuentoTotalLocal(Float newImporteDescuentoTotalLocal) {
		importeDescuentoTotalLocal = newImporteDescuentoTotalLocal;
	}

	public Float getImporteFleteDocumento() {
		return importeFleteDocumento;
	}

	public void setImporteFleteDocumento(Float newImporteFleteDocumento) {
		importeFleteDocumento = newImporteFleteDocumento;
	}

	public Float getImporteFleteLocal() {
		return importeFleteLocal;
	}

	public void setImporteFleteLocal(Float newImporteFleteLocal) {
		importeFleteLocal = newImporteFleteLocal;
	}

	public Float getImporteFleteTotalDocumento() {
		return importeFleteTotalDocumento;
	}

	public void setImporteFleteTotalDocumento(Float newImporteFleteTotalDocumento) {
		importeFleteTotalDocumento = newImporteFleteTotalDocumento;
	}

	public Float getImporteFleteTotalLocal() {
		return importeFleteTotalLocal;
	}

	public void setImporteFleteTotalLocal(Float newImporteFleteTotalLocal) {
		importeFleteTotalLocal = newImporteFleteTotalLocal;
	}

	public Boolean getIndMasSolicitudes() {
		return indMasSolicitudes;
	}

	public void setIndMasSolicitudes(Boolean newIndMasSolicitudes) {
		indMasSolicitudes = newIndMasSolicitudes;
	}

	public Boolean getIndPedidoPrueba() {
		return indPedidoPrueba;
	}

	public void setIndPedidoPrueba(Boolean newIndPedidoPrueba) {
		indPedidoPrueba = newIndPedidoPrueba;
	}

	public Boolean getIndTSNoConsolidado() {
		return indTSNoConsolidado;
	}

	public void setIndTSNoConsolidado(Boolean newIndTSNoConsolidado) {
		indTSNoConsolidado = newIndTSNoConsolidado;
	}

	public Boolean getIndicadorAplicacionManual() {
		return indicadorAplicacionManual;
	}

	public void setIndicadorAplicacionManual(Boolean newIndicadorAplicacionManual) {
		indicadorAplicacionManual = newIndicadorAplicacionManual;
	}

	public Boolean getIndicadorDigitacion() {
		return indicadorDigitacion;
	}

	public void setIndicadorDigitacion(Boolean newIndicadorDigitacion) {
		indicadorDigitacion = newIndicadorDigitacion;
	}

	public Boolean getIndicadorExentoFlete() {
		return indicadorExentoFlete;
	}

	public void setIndicadorExentoFlete(Boolean newIndicadorExentoFlete) {
		indicadorExentoFlete = newIndicadorExentoFlete;
	}

	public Boolean getIndicadorGeneraCuentaCorriente() {
		return indicadorGeneraCuentaCorriente;
	}

	public void setIndicadorGeneraCuentaCorriente(Boolean newIndicadorGeneraCuentaCorriente) {
		indicadorGeneraCuentaCorriente = newIndicadorGeneraCuentaCorriente;
	}

	public Boolean getIndicadorImpresion() {
		return indicadorImpresion;
	}

	public void setIndicadorImpresion(Boolean newIndicadorImpresion) {
		indicadorImpresion = newIndicadorImpresion;
	}

	public Long getIndicadorImpuestosFlete() {
		return indicadorImpuestosFlete;
	}

	public void setIndicadorImpuestosFlete(Long newIndicadorImpuestosFlete) {
		indicadorImpuestosFlete = newIndicadorImpuestosFlete;
	}

	public Boolean getIndicadorOrdenCompra() {
		return indicadorOrdenCompra;
	}

	public void setIndicadorOrdenCompra(Boolean newIndicadorOrdenCompra) {
		indicadorOrdenCompra = newIndicadorOrdenCompra;
	}

	public Boolean getIndicadorPedidoPrueba() {
		return indicadorPedidoPrueba;
	}

	public void setIndicadorPedidoPrueba(Boolean newIndicadorPedidoPrueba) {
		indicadorPedidoPrueba = newIndicadorPedidoPrueba;
	}

	public Long getIndicadorRevision() {
		return indicadorRevision;
	}

	public void setIndicadorRevision(Long newIndicadorRevision) {
		indicadorRevision = newIndicadorRevision;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String newMensajeError) {
		mensajeError = newMensajeError;
	}

	public Long getModulo() {
		return modulo;
	}

	public void setModulo(Long newModulo) {
		modulo = newModulo;
	}

	public Long getMoneda() {
		return moneda;
	}

	public void setMoneda(Long newMoneda) {
		moneda = newMoneda;
	}

	public Boolean getMonofacturacion() {
		return monofacturacion;
	}

	public void setMonofacturacion(Boolean newMonofacturacion) {
		monofacturacion = newMonofacturacion;
	}

	public Integer getNumeroClientes() {
		return numeroClientes;
	}

	public void setNumeroClientes(Integer newNumeroClientes) {
		numeroClientes = newNumeroClientes;
	}

	public Long getNumeroConsolidado() {
		return numeroConsolidado;
	}

	public void setNumeroConsolidado(Long newNumeroConsolidado) {
		numeroConsolidado = newNumeroConsolidado;
	}

	public Long getNumeroDocumentoOrigen() {
		return numeroDocumentoOrigen;
	}

	public void setNumeroDocumentoOrigen(Long newNumeroDocumentoOrigen) {
		numeroDocumentoOrigen = newNumeroDocumentoOrigen;
	}

	public Integer getNumeroDocumentoReferencia() {
        return numeroDocumentoReferencia;
	}

	public void setNumeroDocumentoReferencia(Integer numeroDocumentoReferencia) {
        this.numeroDocumentoReferencia = numeroDocumentoReferencia;
	}

	public Long getNumeroLoteFacturacion() {
		return numeroLoteFacturacion;
	}

	public void setNumeroLoteFacturacion(Long newNumeroLoteFacturacion) {
		numeroLoteFacturacion = newNumeroLoteFacturacion;
	}

	public Integer getNumeroPremio() {
		return numeroPremio;
	}

	public void setNumeroPremio(Integer newNumeroPremio) {
		numeroPremio = newNumeroPremio;
	}

	public Integer getNumeroSecuenciaZonaRuta() {
		return numeroSecuenciaZonaRuta;
	}

	public void setNumeroSecuenciaZonaRuta(Integer newNumeroSecuenciaZonaRuta) {
		numeroSecuenciaZonaRuta = newNumeroSecuenciaZonaRuta;
	}

	public Long getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(Long newNumeroSolicitud) {
		numeroSolicitud = newNumeroSolicitud;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		observaciones = newObservaciones;
	}

	public Long getOidCabeceraSolicitud() {
		return oidCabeceraSolicitud;
	}

	public void setOidCabeceraSolicitud(Long newOidCabeceraSolicitud) {
		oidCabeceraSolicitud = newOidCabeceraSolicitud;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidConcursoParametros() {
		return oidConcursoParametros;
	}

	public void setOidConcursoParametros(Long newOidConcursoParametros) {
		oidConcursoParametros = newOidConcursoParametros;
	}

	public Long getOidDocumentoReferencia() {
		return oidDocumentoReferencia;
	}

	public void setOidDocumentoReferencia(Long newOidDocumentoReferencia) {
		oidDocumentoReferencia = newOidDocumentoReferencia;
	}

	public Long getOidPagadorFactura() {
		return oidPagadorFactura;
	}

	public void setOidPagadorFactura(Long newOidPagadorFactura) {
		oidPagadorFactura = newOidPagadorFactura;
	}

	/*public Long getOidReceptorFactura() {
		return oidReceptorFactura;
	}

	public void setOidReceptorFactura(Long newOidReceptorFactura) {
		oidReceptorFactura = newOidReceptorFactura;
	}
	*/
	
	public Long getOidSubgVentas() {
		return oidSubgVentas;
	}

	public void setOidSubgVentas(Long newOidSubgVentas) {
		oidSubgVentas = newOidSubgVentas;
	}
	

	public Long getOperacion() {
		return operacion;
	}

	public void setOperacion(Long newOperacion) {
		operacion = newOperacion;
	}

	/*
	public Boolean getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(Boolean newOrdenCompra) {
		ordenCompra = newOrdenCompra;
	}
	*/

	public Float getOtrosRecargosDocumento() {
		return otrosRecargosDocumento;
	}

	public void setOtrosRecargosDocumento(Float newOtrosRecargosDocumento) {
		otrosRecargosDocumento = newOtrosRecargosDocumento;
	}

	public Float getOtrosRecargosLocal() {
		return otrosRecargosLocal;
	}

	public void setOtrosRecargosLocal(Float newOtrosRecargosLocal) {
		otrosRecargosLocal = newOtrosRecargosLocal;
	}

	/*
	public String getPagadorFactura() {
		return pagadorFactura;
	}

	public void setPagadorFactura(String newPagadorFactura) {
		pagadorFactura = newPagadorFactura;
	}
	*/

	/*public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	} */

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Boolean getPermiteUnionSolicitudes() {
		return permiteUnionSolicitudes;
	}

	public void setPermiteUnionSolicitudes(Boolean newPermiteUnionSolicitudes) {
		permiteUnionSolicitudes = newPermiteUnionSolicitudes;
	}

	public Float getPrecioContableTotalLocal() {
		return precioContableTotalLocal;
	}

	public void setPrecioContableTotalLocal(Float newPrecioContableTotalLocal) {
		precioContableTotalLocal = newPrecioContableTotalLocal;
	}

	public Float getPrecioTotalTotalLocal() {
		return precioTotalTotalLocal;
	}

	public void setPrecioTotalTotalLocal(Float newPrecioTotalTotalLocal) {
		precioTotalTotalLocal = newPrecioTotalTotalLocal;
	}

	public Long getProceso() {
		return proceso;
	}

	public void setProceso(Long newProceso) {
		proceso = newProceso;
	}

	public Float getRecargoFleteDocumento() {
		return recargoFleteDocumento;
	}

	public void setRecargoFleteDocumento(Float newRecargoFleteDocumento) {
		recargoFleteDocumento = newRecargoFleteDocumento;
	}

	public Float getRecargoFleteLocal() {
		return recargoFleteLocal;
	}

	public void setRecargoFleteLocal(Float newRecargoFleteLocal) {
		recargoFleteLocal = newRecargoFleteLocal;
	}

	
	public Long getReceptorFactura() {
		return receptorFactura;
	}

	public void setReceptorFactura(Long newReceptorFactura) {
		receptorFactura = newReceptorFactura;
	}
	

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Long getSociedad() {
		return sociedad;
	}

	public void setSociedad(Long newSociedad) {
		sociedad = newSociedad;
	}

	public Long getSeccion() {
		return seccion;
	}

	public void setSeccion(Long newSeccion) {
		seccion = newSeccion;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Float getSubaccesoConsolidado() {
		return subaccesoConsolidado;
	}

	public void setSubaccesoConsolidado(Float newSubaccesoConsolidado) {
		subaccesoConsolidado = newSubaccesoConsolidado;
	}

	public Long getSubaccesoDocumentoReferencia() {
		return subaccesoDocumentoReferencia;
	}

	public void setSubaccesoDocumentoReferencia(Long newSubaccesoDocumentoReferencia) {
		subaccesoDocumentoReferencia = newSubaccesoDocumentoReferencia;
	}

	public Long getSubgerencia() {
		return subgerencia;
	}

	public void setSubgerencia(Long newSubgerencia) {
		subgerencia = newSubgerencia;
	}

	public Long getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(Long newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}

	public Long getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Long newTerritorio) {
		territorio = newTerritorio;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		tipoCliente = newTipoCliente;
	}

	public Long getTipoConsolidado() {
		return tipoConsolidado;
	}

	public void setTipoConsolidado(Long newTipoConsolidado) {
		tipoConsolidado = newTipoConsolidado;
	}

	public Long getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(Long newTipoDespacho) {
		tipoDespacho = newTipoDespacho;
	}

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long newTipoDocumento) {
		tipoDocumento = newTipoDocumento;
	}

	public Long getTipoDocumentoLegal() {
		return tipoDocumentoLegal;
	}

	public void setTipoDocumentoLegal(Long newTipoDocumentoLegal) {
		tipoDocumentoLegal = newTipoDocumentoLegal;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getTipoSolicitudConsolidado() {
		return tipoSolicitudConsolidado;
	}

	public void setTipoSolicitudConsolidado(Long newTipoSolicitudConsolidado) {
		tipoSolicitudConsolidado = newTipoSolicitudConsolidado;
	}

	public Long getTipoSolicitudDocumentoReferencia() {
		return tipoSolicitudDocumentoReferencia;
	}

	public void setTipoSolicitudDocumentoReferencia(Long newTipoSolicitudDocumentoReferencia) {
		tipoSolicitudDocumentoReferencia = newTipoSolicitudDocumentoReferencia;
	}

	public Float getTotalAPagarDocumento() {
		return totalAPagarDocumento;
	}

	public void setTotalAPagarDocumento(Float newTotalAPagarDocumento) {
		totalAPagarDocumento = newTotalAPagarDocumento;
	}

	public Float getTotalAPagarLocal() {
		return totalAPagarLocal;
	}

	public void setTotalAPagarLocal(Float newTotalAPagarLocal) {
		totalAPagarLocal = newTotalAPagarLocal;
	}

	public Float getTotalFleteDocumento() {
		return totalFleteDocumento;
	}

	public void setTotalFleteDocumento(Float newTotalFleteDocumento) {
		totalFleteDocumento = newTotalFleteDocumento;
	}

	public Float getTotalFleteLocal() {
		return totalFleteLocal;
	}

	public void setTotalFleteLocal(Float newTotalFleteLocal) {
		totalFleteLocal = newTotalFleteLocal;
	}

	public Long getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Long newUbigeo) {
		ubigeo = newUbigeo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String newUsuario) {
		usuario = newUsuario;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Boolean getIndicadorEstadisticable() {
		return indicadorEstadisticable;
	}

	public void setIndicadorEstadisticable(Boolean newIndicadorEstadisticable) {
		indicadorEstadisticable = newIndicadorEstadisticable;
	}

	public Float getImporteDescuentoTotalDocumento() {
		return importeDescuentoTotalDocumento;
	}

	public void setImporteDescuentoTotalDocumento(Float newImporteDescuentoTotalDocumento) {
		importeDescuentoTotalDocumento = newImporteDescuentoTotalDocumento;
	}

	public Integer getNumeroDecimalesRedondeo() {
		return numeroDecimalesRedondeo;
	}

	public void setNumeroDecimalesRedondeo(Integer newNumeroDecimalesRedondeo) {
		numeroDecimalesRedondeo = newNumeroDecimalesRedondeo;
	}

	public String getSecuenciaRutaTerritorio() {
		return secuenciaRutaTerritorio;
	}

	public void setSecuenciaRutaTerritorio(String newSecuenciaRutaTerritorio) {
		secuenciaRutaTerritorio = newSecuenciaRutaTerritorio;
	}

	public Integer getNumeroSecuenciaFacturacionDiaria() {
		return numeroSecuenciaFacturacionDiaria;
	}

	public void setNumeroSecuenciaFacturacionDiaria(Integer newNumeroSecuenciaFacturacionDiaria) {
		numeroSecuenciaFacturacionDiaria = newNumeroSecuenciaFacturacionDiaria;
	}

	public Long getTipoRevision() {
		return tipoRevision;
	}

	public void setTipoRevision(Long newTipoRevision) {
		tipoRevision = newTipoRevision;
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String newPuntoEmision) {
		puntoEmision = newPuntoEmision;
	}

	/*
	public Long getOidSolicitudCabeceraSecuencia() {
		return oidSolicitudCabeceraSecuencia;
	}

	public void setOidSolicitudCabeceraSecuencia(Long newOidSolicitudCabeceraSecuencia) {
		oidSolicitudCabeceraSecuencia = newOidSolicitudCabeceraSecuencia;
	}
	*/

	public Float getImporteFleteSinImpuestosTotalDocumento() {
		return importeFleteSinImpuestosTotalDocumento;
	}

	public void setImporteFleteSinImpuestosTotalDocumento(Float newImporteFleteSinImpuestosTotalDocumento) {
		importeFleteSinImpuestosTotalDocumento = newImporteFleteSinImpuestosTotalDocumento;
	}

	public Float getImporteFleteSinImpuestosTotalLocal() {
		return importeFleteSinImpuestosTotalLocal;
	}

	public void setImporteFleteSinImpuestosTotalLocal(Float newImporteFleteSinImpuestosTotalLocal) {
		importeFleteSinImpuestosTotalLocal = newImporteFleteSinImpuestosTotalLocal;
	}

	public Long getTerritorioCliente() {
		return territorioCliente;
	}

	public void setTerritorioCliente(Long newTerritorioCliente) {
		territorioCliente = newTerritorioCliente;
	}

	public Float getPrecioTotalTotalDocumento() {
		return precioTotalTotalDocumento;
	}

	public void setPrecioTotalTotalDocumento(Float newPrecioTotalTotalDocumento) {
		precioTotalTotalDocumento = newPrecioTotalTotalDocumento;
	}

	public Long getOidDireccionCliente() {
		return oidDireccionCliente;
	}

	public void setOidDireccionCliente(Long newOidDireccionCliente) {
		oidDireccionCliente = newOidDireccionCliente;
	}

	public Long getTipoClasificacion() {
		return tipoClasificacion;
	}

	public void setTipoClasificacion(Long newTipoClasificacion) {
		tipoClasificacion = newTipoClasificacion;
	}

	public Long getOidConsolidado() {
		return oidConsolidado;
	}

	public void setOidConsolidado(Long newOidConsolidado) {
		oidConsolidado = newOidConsolidado;
	}

	public Float getTasaImpuesto() {
		return tasaImpuesto;
	}

	public void setTasaImpuesto(Float newTasaImpuesto) {
		tasaImpuesto = newTasaImpuesto;
	}

	public Long getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Long newClasificacion) {
		clasificacion = newClasificacion;
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

	public Integer getUnidadesDemandaRealTotal() {
		return unidadesDemandaRealTotal;
	}

	public void setUnidadesDemandaRealTotal(Integer newUnidadesDemandaRealTotal) {
		unidadesDemandaRealTotal = newUnidadesDemandaRealTotal;
	}

	public Integer getUnidadesPorAtenderTotal() {
		return unidadesPorAtenderTotal;
	}

	public void setUnidadesPorAtenderTotal(Integer newUnidadesPorAtenderTotal) {
		unidadesPorAtenderTotal = newUnidadesPorAtenderTotal;
	}

	public Integer getUnidadesAtendidasTotal() {
		return unidadesAtendidasTotal;
	}

	public void setUnidadesAtendidasTotal(Integer newUnidadesAtendidasTotal) {
		unidadesAtendidasTotal = newUnidadesAtendidasTotal;
	}

	public Float getPrecioContableSinImpuestosTotalLocal() {
		return precioContableSinImpuestosTotalLocal;
	}

	public void setPrecioContableSinImpuestosTotalLocal(Float newPrecioContableSinImpuestosTotalLocal) {
		precioContableSinImpuestosTotalLocal = newPrecioContableSinImpuestosTotalLocal;
	}

	public Float getPrecioContableSinImpuestosTotalDocumento() {
		return precioContableSinImpuestosTotalDocumento;
	}

	public void setPrecioContableSinImpuestosTotalDocumento(Float newPrecioContableSinImpuestosTotalDocumento) {
		precioContableSinImpuestosTotalDocumento = newPrecioContableSinImpuestosTotalDocumento;
	}

	public Float getImporteDescuento3SinImpuestosTotalLocal() {
		return importeDescuento3SinImpuestosTotalLocal;
	}

	public void setImporteDescuento3SinImpuestosTotalLocal(Float newImporteDescuento3SinImpuestosTotalLocal) {
		importeDescuento3SinImpuestosTotalLocal = newImporteDescuento3SinImpuestosTotalLocal;
	}

	public Float getImporteDescuento3SinImpuestosTotalDocumento() {
		return importeDescuento3SinImpuestosTotalDocumento;
	}

	public void setImporteDescuento3SinImpuestosTotalDocumento(Float newImporteDescuento3SinImpuestosTotalDocumento) {
		importeDescuento3SinImpuestosTotalDocumento = newImporteDescuento3SinImpuestosTotalDocumento;
	}

	public Float getPrecioNetoTotalLocal() {
		return precioNetoTotalLocal;
	}

	public void setPrecioNetoTotalLocal(Float newPrecioNetoTotalLocal) {
		precioNetoTotalLocal = newPrecioNetoTotalLocal;
	}

	public Float getPrecioNetoTotalDocumento() {
		return precioNetoTotalDocumento;
	}

	public void setPrecioNetoTotalDocumento(Float newPrecioNetoTotalDocumento) {
		precioNetoTotalDocumento = newPrecioNetoTotalDocumento;
	}

	public Float getImporteImpuestosTotalLocal() {
		return importeImpuestosTotalLocal;
	}

	public void setImporteImpuestosTotalLocal(Float newImporteImpuestosTotalLocal) {
		importeImpuestosTotalLocal = newImporteImpuestosTotalLocal;
	}

	public Float getImporteImpuestosTotalDocumento() {
		return importeImpuestosTotalDocumento;
	}

	public void setImporteImpuestosTotalDocumento(Float newImporteImpuestosTotalDocumento) {
		importeImpuestosTotalDocumento = newImporteImpuestosTotalDocumento;
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

	public Float getImporteDescuento1SinImpuestoTotalDocumento() {
		return importeDescuento1SinImpuestoTotalDocumento;
	}

	public void setImporteDescuento1SinImpuestoTotalDocumento(Float newImporteDescuento1SinImpuestoTotalDocumento) {
		importeDescuento1SinImpuestoTotalDocumento = newImporteDescuento1SinImpuestoTotalDocumento;
	}

	public Float getPrecioFacturaTotalDocumento() {
		return precioFacturaTotalDocumento;
	}

	public void setPrecioFacturaTotalDocumento(Float newPrecioFacturaTotalDocumento) {
		precioFacturaTotalDocumento = newPrecioFacturaTotalDocumento;
	}

	public Float getPrecioCatalogoTotalLocalUnidadesPorAtender() {
		return precioCatalogoTotalLocalUnidadesPorAtender;
	}

	public void setPrecioCatalogoTotalLocalUnidadesPorAtender(Float newPrecioCatalogoTotalLocalUnidadesPorAtender) {
		precioCatalogoTotalLocalUnidadesPorAtender = newPrecioCatalogoTotalLocalUnidadesPorAtender;
	}

	public Float getPrecioCatalogoSinImpuestoTotalLocal() {
		return precioCatalogoSinImpuestoTotalLocal;
	}

	public void setPrecioCatalogoSinImpuestoTotalLocal(Float newPrecioCatalogoSinImpuestoTotalLocal) {
		precioCatalogoSinImpuestoTotalLocal = newPrecioCatalogoSinImpuestoTotalLocal;
	}

	public Float getImporteDescuento1SinImpuestoTotalLocal() {
		return importeDescuento1SinImpuestoTotalLocal;
	}

	public void setImporteDescuento1SinImpuestoTotalLocal(Float newImporteDescuento1SinImpuestoTotalLocal) {
		importeDescuento1SinImpuestoTotalLocal = newImporteDescuento1SinImpuestoTotalLocal;
	}

	public Float getPrecioFacturaTotalLocal() {
		return precioFacturaTotalLocal;
	}

	public void setPrecioFacturaTotalLocal(Float newPrecioFacturaTotalLocal) {
		precioFacturaTotalLocal = newPrecioFacturaTotalLocal;
	}

	public Float getPrecioCatalogoTotalLocal() {
		return precioCatalogoTotalLocal;
	}

	public void setPrecioCatalogoTotalLocal(Float newPrecioCatalogoTotalLocal) {
		precioCatalogoTotalLocal = newPrecioCatalogoTotalLocal;
	}

	public Float getPrecioCatalogoSinImpuestoTotalDocumento() {
		return precioCatalogoSinImpuestoTotalDocumento;
	}

	public void setPrecioCatalogoSinImpuestoTotalDocumento(Float newPrecioCatalogoSinImpuestoTotalDocumento) {
		precioCatalogoSinImpuestoTotalDocumento = newPrecioCatalogoSinImpuestoTotalDocumento;
	}

	public Float getPrecioContableTotalDocumento() {
		return precioContableTotalDocumento;
	}

	public void setPrecioContableTotalDocumento(Float newPrecioContableTotalDocumento) {
		precioContableTotalDocumento = newPrecioContableTotalDocumento;
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

	public Long getNumeroDocumentoContableInterno() {
		return numeroDocumentoContableInterno;
	}

	public void setNumeroDocumentoContableInterno(Long newNumeroDocumentoContableInterno) {
		numeroDocumentoContableInterno = newNumeroDocumentoContableInterno;
	}
    
    public Long getOidRuta() {
		return oidRuta;
	}

	public void setOidRuta(Long newOidRuta) {
		oidRuta = newOidRuta;
	}
    
	public Object clone () throws CloneNotSupportedException{
	
		return super.clone();
    }

    public Integer getNumeroSecuenciaImpresion()
    {
        return numeroSecuenciaImpresion;
    }

    public void setNumeroSecuenciaImpresion(Integer numeroSecuenciaImpresion)
    {
        this.numeroSecuenciaImpresion = numeroSecuenciaImpresion;
    }

    public Boolean getIndClaseOC()
    {
        return indClaseOC;
    }

    public void setIndClaseOC(Boolean indClaseOC)
    {
        this.indClaseOC = indClaseOC;
    }

    public Long getOidTipoConcursoPrograma() {
        return oidTipoConcursoPrograma;
    }

    public void setOidTipoConcursoPrograma(Long oidTipoConcursoPrograma) {
        this.oidTipoConcursoPrograma = oidTipoConcursoPrograma;
    }

    public String getCodigoTipoProgramaConcu() {
        return codigoTipoProgramaConcu;
    }

    public void setCodigoTipoProgramaConcu(String codigoTipoProgramaConcu) {
        this.codigoTipoProgramaConcu = codigoTipoProgramaConcu;
    }

    public Long getNumeroUnidadesAtendidasTotal() {
        return numeroUnidadesAtendidasTotal;
    }

    public void setNumeroUnidadesAtendidasTotal(Long numeroUnidadesAtendidasTotal) {
        this.numeroUnidadesAtendidasTotal = numeroUnidadesAtendidasTotal;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
    }

    public Float getImporteTipoPrograma() {
        return importeTipoPrograma;
    }

    public void setImporteTipoPrograma(Float importeTipoPrograma) {
        this.importeTipoPrograma = importeTipoPrograma;
    }

    public Float getTasaImpuestoUbigeo() {
        return tasaImpuestoUbigeo;
    }

    public void setTasaImpuestoUbigeo(Float tasaImpuestoUbigeo) {
        this.tasaImpuestoUbigeo = tasaImpuestoUbigeo;
    }

    public Long getOidTasaImpuestoUbigeo() {
        return oidTasaImpuestoUbigeo;
    }

    public void setOidTasaImpuestoUbigeo(Long oidTasaImpuestoUbigeo) {
        this.oidTasaImpuestoUbigeo = oidTasaImpuestoUbigeo;
    }

    public Float getTasaImpuestoFlete() {
        return tasaImpuestoFlete;
    }

    public void setTasaImpuestoFlete(Float tasaImpuestoFlete) {
        this.tasaImpuestoFlete = tasaImpuestoFlete;
    }

    public void setOrigenChequeo(String origenChequeo) {
        this.origenChequeo = origenChequeo;
    }

    public String getOrigenChequeo() {
        return origenChequeo;
    }
    
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Boolean getIndPedidoServicio() {
        return indPedidoServicio;
    }

    public void setIndPedidoServicio(Boolean indPedidoServicio) {
        this.indPedidoServicio = indPedidoServicio;
    }

    public Boolean getIndicadorIVAasumido() {
        return indicadorIVAasumido;
    }

    public void setIndicadorIVAasumido(Boolean indicadorIVAasumido) {
        this.indicadorIVAasumido = indicadorIVAasumido;
    }

    public Long getPorcIVAasumido() {
        return porcIVAasumido;
    }

    public void setPorcIVAasumido(Long porcIVAasumido) {
        this.porcIVAasumido = porcIVAasumido;
    }

    public Float getIVAasumidoEmpresa() {
        return IVAasumidoEmpresa;
    }

    public void setIVAasumidoEmpresa(Float IVAasumidoEmpresa) {
        this.IVAasumidoEmpresa = IVAasumidoEmpresa;
    }

    public Boolean getIndicadorDireccionSeparada() {
        return indicadorDireccionSeparada;
    }

    public void setIndicadorDireccionSeparada(Boolean indicadorDireccionSeparada) {
        this.indicadorDireccionSeparada = indicadorDireccionSeparada;
    }

    public Long getIndicadorAgrupReclamos() {
        return indicadorAgrupReclamos;
    }

    public void setIndicadorAgrupReclamos(Long indicadorAgrupReclamos) {
        this.indicadorAgrupReclamos = indicadorAgrupReclamos;
    }



}