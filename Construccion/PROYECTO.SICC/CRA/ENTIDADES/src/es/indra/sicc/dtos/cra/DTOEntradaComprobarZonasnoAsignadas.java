/*
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

package es.indra.sicc.dtos.cra;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOBelcorp;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 * @version           1.0
 * @autor             Diego Javier Grigna
 */

public class DTOEntradaComprobarZonasnoAsignadas extends DTOAuditableSICC {


    private Long pais;
    private Long marca;
    private Long canal;
    private Integer codigoGrupo;
    private String nombreGrupo;
    private String tipoFacturacion;
    private String grupoZonas;
    private Long region;
    private String zonas;
    private Long oidGrupoZona;

	public DTOEntradaComprobarZonasnoAsignadas() {
		super();
	}

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Integer getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(Integer newCodigoGrupo) {
        codigoGrupo = newCodigoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String newNombreGrupo) {
        nombreGrupo = newNombreGrupo;
    }

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String newTipoFacturacion) {
        tipoFacturacion = newTipoFacturacion;
    }

    public String getGrupoZonas() {
        return grupoZonas;
    }

    public void setGrupoZonas(String newGrupoZonas) {
        grupoZonas = newGrupoZonas;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long newRegion) {
        region = newRegion;
    }

    public String getZonas() {
        return zonas;
    }

    public void setZonas(String newZonas) {
        zonas = newZonas;
    }
    public Long getOidGrupoZona() {
        return this.oidGrupoZona;
    }

    public void setOidGrupoZona(Long oidGrupoZona) {
        this.oidGrupoZona = oidGrupoZona;
    }
}

