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
import java.util.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOTipoOfertaExcluido extends DTOSiccPaginacion{
    Long oid;
    Long oidPais;
    Long oidCanal;
    Long oidTipoOferta;
    Date fechaDesde;
    Date fechaHasta;
    Long indicadorSituacion;

    public DTOTipoOfertaExcluido() {
        super();
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Long getIndicadorSituacion() {
        return indicadorSituacion;
    }

    public void setIndicadorSituacion(Long indicadorSituacion) {
        this.indicadorSituacion = indicadorSituacion;
    }
}
