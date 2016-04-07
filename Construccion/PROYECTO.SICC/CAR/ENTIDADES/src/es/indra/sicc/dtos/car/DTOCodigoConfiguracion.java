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
package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;
import java.math.BigDecimal;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
public class DTOCodigoConfiguracion  extends DTOSiccPaginacion{
	private Long oidCodConf;
	private String codConf;
	private Long nivelRiesgo;
	private Long grupoSolicitud;
	private Boolean valDiasDeuda;
	private Integer diasDeudaVenPerm;
	private Boolean valLineaCredito;
	private Date fechaVigenciaDesde;
	private Date fechaVigenciaHasta;
	private Long indicadorValidacion;
	private Float porcentajeValidacion;
	private Boolean valMontoMaximo;
	private BigDecimal montoMaximoPermitido;
	private Boolean valporcentajeMaximo;
	private Float porcentajeMaximoPermitido;
	private Integer numDiasAdicionales;
	private RecordSet asignaciones;
    private Long oidTipoSolPED;

	public DTOCodigoConfiguracion() {
	}

	public Long getOidCodConf() {
		return oidCodConf;
	}

	public void setOidCodConf(Long newOidCodConf) {
		oidCodConf = newOidCodConf;
	}

	public String getCodConf() {
		return codConf;
	}

	public void setCodConf(String newCodConf) {
		codConf = newCodConf;
	}

	public Long getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(Long newNivelRiesgo) {
		nivelRiesgo = newNivelRiesgo;
	}

	public Long getGrupoSolicitud() {
		return grupoSolicitud;
	}

	public void setGrupoSolicitud(Long newGrupoSolicitud) {
		grupoSolicitud = newGrupoSolicitud;
	}

	public Boolean getValDiasDeuda() {
		return valDiasDeuda;
	}

	public void setValDiasDeuda(Boolean newValDiasDeuda) {
		valDiasDeuda = newValDiasDeuda;
	}

	public Integer getDiasDeudaVenPerm() {
		return diasDeudaVenPerm;
	}

	public void setDiasDeudaVenPerm(Integer newDiasDeudaVenPerm) {
		diasDeudaVenPerm = newDiasDeudaVenPerm;
	}

	public Boolean getValLineaCredito() {
		return valLineaCredito;
	}

	public void setValLineaCredito(Boolean newValLineaCredito) {
		valLineaCredito = newValLineaCredito;
	}

	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(Date newFechaVigenciaDesde) {
		fechaVigenciaDesde = newFechaVigenciaDesde;
	}

	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(Date newFechaVigenciaHasta) {
		fechaVigenciaHasta = newFechaVigenciaHasta;
	}

	public Long getIndicadorValidacion() {
		return indicadorValidacion;
	}

	public void setIndicadorValidacion(Long newIndicadorValidacion) {
		indicadorValidacion = newIndicadorValidacion;
	}

	public Float getPorcentajeValidacion() {
		return porcentajeValidacion;
	}

	public void setPorcentajeValidacion(Float newPorcentajeValidacion) {
		porcentajeValidacion = newPorcentajeValidacion;
	}

	public Boolean getValMontoMaximo() {
		return valMontoMaximo;
	}

	public void setValMontoMaximo(Boolean newValMontoMaximo) {
		valMontoMaximo = newValMontoMaximo;
	}

	public BigDecimal getMontoMaximoPermitido() {
		return montoMaximoPermitido;
	}

	public void setMontoMaximoPermitido(BigDecimal newMontoMaximoPermitido) {
		montoMaximoPermitido = newMontoMaximoPermitido;
	}

	public Boolean getValporcentajeMaximo() {
		return valporcentajeMaximo;
	}

	public void setValporcentajeMaximo(Boolean newValporcentajeMaximo) {
		valporcentajeMaximo = newValporcentajeMaximo;
	}

	public Float getPorcentajeMaximoPermitido() {
		return porcentajeMaximoPermitido;
	}

	public void setPorcentajeMaximoPermitido(Float newPorcentajeMaximoPermitido) {
		porcentajeMaximoPermitido = newPorcentajeMaximoPermitido;
	}

	public Integer getNumDiasAdicionales() {
		return numDiasAdicionales;
	}

	public void setNumDiasAdicionales(Integer newNumDiasAdicionales) {
		numDiasAdicionales = newNumDiasAdicionales;
	}

	public RecordSet getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(RecordSet newAsignaciones) {
		asignaciones = newAsignaciones;
	}

    public Long getOidTipoSolPED() {
        return oidTipoSolPED;
    }

    public void setOidTipoSolPED(Long newOidTipoSolPED) {
        oidTipoSolPED = newOidTipoSolPED;
    }
}