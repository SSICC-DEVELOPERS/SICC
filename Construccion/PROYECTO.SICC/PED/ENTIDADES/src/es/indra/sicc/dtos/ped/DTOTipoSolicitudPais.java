package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOTipoSolicitudPais extends DTOSiccPaginacion {
	private Long oid;
	private Integer numPorLote;
	private Integer alarmaNumUnidades;
	private Boolean sujetoFlete;
	private Boolean permiteUnionSolicitudes;
	private Boolean reservaStock;
	private Boolean permiteReversion;
	private Boolean indPedidoPrueba;
	private Boolean indComisionable;
	private Boolean indPedGtZona;
	private Boolean indCambioVentaBEL;
	private Boolean indVentaSAB14;
	private Long sociedad;
	private Long formaPago;
	private Long tipoDocumentoLegal;
	private Long moneda;
	private Long actividad;
	private Long tipoMovReserva;
	private Long tipoMovAsigna;
	private Long tipoMovFacturacion;
	private Long tipoSolicitud;
	private Long tipoConsolidado;
	private String glosa;
	private Long almacen;

	public DTOTipoSolicitudPais() {
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Integer getNumPorLote() {
		return numPorLote;
	}

	public void setNumPorLote(Integer newNumPorLote) {
		numPorLote = newNumPorLote;
	}

	public Integer getAlarmaNumUnidades() {
		return alarmaNumUnidades;
	}

	public void setAlarmaNumUnidades(Integer newAlarmaNumUnidades) {
		alarmaNumUnidades = newAlarmaNumUnidades;
	}

	public Boolean getSujetoFlete() {
		return sujetoFlete;
	}

	public void setSujetoFlete(Boolean newSujetoFlete) {
		sujetoFlete = newSujetoFlete;
	}

	public Boolean getPermiteUnionSolicitudes() {
		return permiteUnionSolicitudes;
	}

	public void setPermiteUnionSolicitudes(Boolean newPermiteUnionSolicitudes) {
		permiteUnionSolicitudes = newPermiteUnionSolicitudes;
	}

	public Boolean getReservaStock() {
		return reservaStock;
	}

	public void setReservaStock(Boolean newReservaStock) {
		reservaStock = newReservaStock;
	}

	public Boolean getPermiteReversion() {
		return permiteReversion;
	}

	public void setPermiteReversion(Boolean newPermiteReversion) {
		permiteReversion = newPermiteReversion;
	}

	public Boolean getIndPedidoPrueba() {
		return indPedidoPrueba;
	}

	public void setIndPedidoPrueba(Boolean newIndPedidoPrueba) {
		indPedidoPrueba = newIndPedidoPrueba;
	}

	public Boolean getIndComisionable() {
		return indComisionable;
	}

	public void setIndComisionable(Boolean newIndComisionable) {
		indComisionable = newIndComisionable;
	}

	public Boolean getIndPedGtZona() {
		return indPedGtZona;
	}

	public void setIndPedGtZona(Boolean newIndPedGtZona) {
		indPedGtZona = newIndPedGtZona;
	}

	public Boolean getIndCambioVentaBEL() {
		return indCambioVentaBEL;
	}

	public void setIndCambioVentaBEL(Boolean newIndCambioVentaBEL) {
		indCambioVentaBEL = newIndCambioVentaBEL;
	}

	public Boolean getIndVentaSAB14() {
		return indVentaSAB14;
	}

	public void setIndVentaSAB14(Boolean newIndVentaSAB14) {
		indVentaSAB14 = newIndVentaSAB14;
	}

	public Long getSociedad() {
		return sociedad;
	}

	public void setSociedad(Long newSociedad) {
		sociedad = newSociedad;
	}

	public Long getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Long newFormaPago) {
		formaPago = newFormaPago;
	}

	public Long getTipoDocumentoLegal() {
		return tipoDocumentoLegal;
	}

	public void setTipoDocumentoLegal(Long newTipoDocumentoLegal) {
		tipoDocumentoLegal = newTipoDocumentoLegal;
	}

	public Long getMoneda() {
		return moneda;
	}

	public void setMoneda(Long newMoneda) {
		moneda = newMoneda;
	}

	public Long getActividad() {
		return actividad;
	}

	public void setActividad(Long newActividad) {
		actividad = newActividad;
	}

	public Long getTipoMovReserva() {
		return tipoMovReserva;
	}

	public void setTipoMovReserva(Long newTipoMovReserva) {
		tipoMovReserva = newTipoMovReserva;
	}

	public Long getTipoMovAsigna() {
		return tipoMovAsigna;
	}

	public void setTipoMovAsigna(Long newTipoMovAsigna) {
		tipoMovAsigna = newTipoMovAsigna;
	}

	public Long getTipoMovFacturacion() {
		return tipoMovFacturacion;
	}

	public void setTipoMovFacturacion(Long newTipoMovFacturacion) {
		tipoMovFacturacion = newTipoMovFacturacion;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getTipoConsolidado() {
		return tipoConsolidado;
	}

	public void setTipoConsolidado(Long newTipoConsolidado) {
		tipoConsolidado = newTipoConsolidado;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String newGlosa) {
		glosa = newGlosa;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Long newAlmacen) {
		almacen = newAlmacen;
	}
}