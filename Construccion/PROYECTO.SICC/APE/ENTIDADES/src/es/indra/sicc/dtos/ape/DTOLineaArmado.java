/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class DTOLineaArmado extends DTOSiccPaginacion {
    private Long oid;
    private Long codigoLinea;
    private String descripcion;
    //private Boolean imprimirListaPicado; //ciglesias incidencia 356
    private Long longitudNumeroEtiqueta;
    private Boolean lineaAFP;
    private BigDecimal porcentajeVariacionEstimado;
    private Timestamp fechaHoraRevisionAlarma;
    //private String formatoEtiqueta;//ciglesias incidencia 374
    private Long numeroEtiquetasAFP;
    private Boolean valorDefecto;
    private Long tipoSolicitudConsolidado;
    private Long[] usuarioAlarmaLinea;
    private DTOProgramaCubicaje programaCubicaje;
    private DTOConfiguracionCentroDistribucion centroDistribucion;
    private DTOSistemaEtiquetado sistemaEtiquetado;
    
    
    public DTOLineaArmado() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setCodigoLinea(Long codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public Long getCodigoLinea() {
        return codigoLinea;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

/* ciglesias incidencia 356
    public void setImprimirListaPicado(Boolean imprimirListaPicado) {
        this.imprimirListaPicado = imprimirListaPicado;
    }

    public Boolean getImprimirListaPicado() {
        return imprimirListaPicado;
    }
*/
    public void setLongitudNumeroEtiqueta(Long longitudNumeroEtiqueta) {
        this.longitudNumeroEtiqueta = longitudNumeroEtiqueta;
    }

    public Long getLongitudNumeroEtiqueta() {
        return longitudNumeroEtiqueta;
    }

    public void setLineaAFP(Boolean lineaAFP) {
        this.lineaAFP = lineaAFP;
    }

    public Boolean getLineaAFP() {
        return lineaAFP;
    }

    public void setPorcentajeVariacionEstimado(BigDecimal porcentajeVariacionEstimado) {
        this.porcentajeVariacionEstimado = porcentajeVariacionEstimado;
    }

    public BigDecimal getPorcentajeVariacionEstimado() {
        return porcentajeVariacionEstimado;
    }

    public void setFechaHoraRevisionAlarma(Timestamp fechaHoraRevisionAlarma) {
        this.fechaHoraRevisionAlarma = fechaHoraRevisionAlarma;
    }

    public Timestamp getFechaHoraRevisionAlarma() {
        return fechaHoraRevisionAlarma;
    }
/* ciglesias incidencia 374
    public void setFormatoEtiqueta(String formatoEtiqueta) {
        this.formatoEtiqueta = formatoEtiqueta;
    }

    public String getFormatoEtiqueta() {
        return formatoEtiqueta;
    }
*/
    public void setNumeroEtiquetasAFP(Long numeroEtiquetasAFP) {
        this.numeroEtiquetasAFP = numeroEtiquetasAFP;
    }

    public Long getNumeroEtiquetasAFP() {
        return numeroEtiquetasAFP;
    }

    public void setValorDefecto(Boolean valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    public Boolean getValorDefecto() {
        return valorDefecto;
    }

    public void setTipoSolicitudConsolidado(Long tipoSolicitudConsolidado) {
        this.tipoSolicitudConsolidado = tipoSolicitudConsolidado;
    }

    public Long getTipoSolicitudConsolidado() {
        return tipoSolicitudConsolidado;
    }

    public void setUsuarioAlarmaLinea(Long[] usuarioAlarmaLinea) {
        this.usuarioAlarmaLinea = usuarioAlarmaLinea;
    }

    public Long[] getUsuarioAlarmaLinea() {
        return usuarioAlarmaLinea;
    }

    public void setProgramaCubicaje(DTOProgramaCubicaje programaCubicaje) {
        this.programaCubicaje = programaCubicaje;
    }

    public DTOProgramaCubicaje getProgramaCubicaje() {
        return programaCubicaje;
    }

    public void setCentroDistribucion(DTOConfiguracionCentroDistribucion centroDistribucion) {
        this.centroDistribucion = centroDistribucion;
    }

    public DTOConfiguracionCentroDistribucion getCentroDistribucion() {
        return centroDistribucion;
    }

    public void setSistemaEtiquetado(DTOSistemaEtiquetado sistemaEtiquetado) {
        this.sistemaEtiquetado = sistemaEtiquetado;
    }

    public DTOSistemaEtiquetado getSistemaEtiquetado() {
        return sistemaEtiquetado;
    }
    
}