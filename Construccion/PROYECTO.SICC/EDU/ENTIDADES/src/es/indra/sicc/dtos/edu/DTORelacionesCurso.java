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
 
package es.indra.sicc.dtos.edu;

public class DTORelacionesCurso extends es.indra.sicc.util.DTOBelcorp {

    private Long oidMarca;
    private Long oidCanal;
    private Long oidTipoCurso;
    private Long oidAcceso;
    private Long oidClasificacion;
    private Long oidTipoCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoClasificacion;
    private Long oidSubgerencia;
    private Long oidCapacitador;
    private Long oidFrecuencia;
    private Long oidPais;
    private Long oidPeriodoFinComparativo;
    private Long oidPeriodoIniComparativo;
    private Long oidPeriodoIngreso;
    private Long oidPeriodoIniConstancia;
    private Long oidPeriodoFinConstancia;
    private Long oidPlantilla;
    private Long oidRegalo;
    private Long oidTerritorio;
    private Long oidZona;
    private Long oidRegion;
    private Long oidSeccion;
    private Long oidStatusCliente;
    private Long oidMomentoEntrega;
    /*************************   AGREGA MAE-015   *************************/
    private Long oidClienteCapacitador;
    private String codClienteCapacitador;
    private Long oidSubtipoClienteCapacitador;
    private String descSubtipoClienteCapacitador;
    private Long oidTipoClasificacionCapacitador;
    /***********************   FIN AGREGA MAE-015  ***********************/


    public DTORelacionesCurso() {
        super();
    }

    public Long getOidMarca() {
        return this.oidMarca;
    }

    public void setOidMarca(Long newOidMarca) {
        this.oidMarca = newOidMarca;
  }

    public Long getOidCanal() {
        return this.oidCanal;
    }

    public void setOidCanal(Long newOidCanal) {
        this.oidCanal = newOidCanal;
    }

    public Long getOidTipoCurso() {
        return this.oidTipoCurso;
    }

    public void setOidTipoCurso(Long newOidTipoCurso) {
        this.oidTipoCurso = newOidTipoCurso;
    }

    public Long getOidAcceso() {
        return this.oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso) {
        this.oidAcceso = newOidAcceso;
    }

    public Long getOidClasificacion() {
        return this.oidClasificacion;
    }

    public void setOidClasificacion(Long newOidClasificacion) {
        this.oidClasificacion = newOidClasificacion;
    }

    public Long getOidTipoCliente() {
        return this.oidTipoCliente;
    }

    public void setOidTipoCliente(Long newOidTipoCliente) {
        this.oidTipoCliente = newOidTipoCliente;
    }

    public Long getOidSubtipoCliente() {
        return this.oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        this.oidSubtipoCliente = newOidSubtipoCliente;
    }

    public Long getOidTipoClasificacion() {
        return this.oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        this.oidTipoClasificacion = newOidTipoClasificacion;
    }

    public Long getOidSubgerencia() {
        return this.oidSubgerencia;
    }

    public void setOidSubgerencia(Long newOidSubgerencia) {
        this.oidSubgerencia = newOidSubgerencia;
    }

    public Long getOidCapacitador() {
        return this.oidCapacitador;
    }

    public void setOidCapacitador(Long newOidCapacitador) {
        this.oidCapacitador = newOidCapacitador;
    }

    public Long getOidFrecuencia() {
        return this.oidFrecuencia;
    }

    public void setOidFrecuencia(Long newOidFrecuencia) {
        this.oidFrecuencia = newOidFrecuencia;
    }

    public Long getOidPais() {
        return this.oidPais;
    }

    public void setOidPais(Long newOidPais) {
        this.oidPais = newOidPais;
    }

    public Long getOidPeriodoFinComparativo() {
        return this.oidPeriodoFinComparativo;
    }

    public void setOidPeriodoFinComparativo(Long newOidPeriodoFinComparativo) {
        this.oidPeriodoFinComparativo = newOidPeriodoFinComparativo;
    }

    public Long getOidPeriodoIniComparativo() {
        return this.oidPeriodoIniComparativo;
    }

    public void setOidPeriodoIniComparativo(Long newOidPeriodoIniComparativo) {
        this.oidPeriodoIniComparativo = newOidPeriodoIniComparativo;
    }

    public Long getOidPeriodoIngreso() {
        return this.oidPeriodoIngreso;
    }

    public void setOidPeriodoIngreso(Long newOidPeriodoIngreso) {
        this.oidPeriodoIngreso = newOidPeriodoIngreso;
    }

    public Long getOidPeriodoIniConstancia() {
        return this.oidPeriodoIniConstancia;
    }

    public void setOidPeriodoIniConstancia(Long newOidPeriodoIniConstancia) {
        this.oidPeriodoIniConstancia = newOidPeriodoIniConstancia;
    }

    public Long getOidPeriodoFinConstancia() {
        return this.oidPeriodoFinConstancia;
    }

    public void setOidPeriodoFinConstancia(Long newOidPeriodoFinConstancia) {
        this.oidPeriodoFinConstancia = newOidPeriodoFinConstancia;
    }

    public Long getOidPlantilla() {
        return this.oidPlantilla;
    }

    public void setOidPlantilla(Long newOidPlantilla) {
        this.oidPlantilla = newOidPlantilla;
    }

    public Long getOidRegalo() {
        return this.oidRegalo;
    }

    public void setOidRegalo(Long newOidRegalo) {
        this.oidRegalo = newOidRegalo;
    }

    public Long getOidTerritorio() {
        return this.oidTerritorio;
    }

    public void setOidTerritorio(Long newOidTerritorio) {
        this.oidTerritorio = newOidTerritorio;
    }

    public Long getOidZona() {
        return this.oidZona;
    }

    public void setOidZona(Long newOidZona) {
        this.oidZona = newOidZona;
    }

    public Long getOidRegion() {
        return this.oidRegion;
    }

    public void setOidRegion(Long newOidRegion) {
        this.oidRegion = newOidRegion;
    }

    public Long getOidSeccion() {
        return this.oidSeccion;
    }

    public void setOidSeccion(Long newOidSeccion) {
        this.oidSeccion = newOidSeccion;
    }

    public Long getOidStatusCliente() {
        return oidStatusCliente;
    }

    public void setOidStatusCliente(Long newOidStatusCliente) {
        oidStatusCliente = newOidStatusCliente;
    }

    public Long getOidMomentoEntrega() {
        return oidMomentoEntrega;
    }

    public void setOidMomentoEntrega(Long newOidMomentoEntrega) {
        oidMomentoEntrega = newOidMomentoEntrega;
    }
    
    /*************************   AGREGA MAE-015   *************************/
    public Long getOidClienteCapacitador() {
        return oidClienteCapacitador;
    }

    public void setOidClienteCapacitador(Long newOidClienteCapacitador) {
        oidClienteCapacitador = newOidClienteCapacitador;
    }

    public String getCodClienteCapacitador() {
        return codClienteCapacitador;
    }

    public void setCodClienteCapacitador(String newCodClienteCapacitador) {
        codClienteCapacitador = newCodClienteCapacitador;
    }
    
    public Long getOidSubtipoClienteCapacitador() {
        return oidSubtipoClienteCapacitador;
    }

    public void setOidSubtipoClienteCapacitador(Long newOidSubtipoClienteCapacitador) {
        oidSubtipoClienteCapacitador = newOidSubtipoClienteCapacitador;
    }
    
    public String getDescSubtipoClienteCapacitador() {
        return descSubtipoClienteCapacitador;
    }

    public void setDescSubtipoClienteCapacitador(String newDescSubtipoClienteCapacitador) {
        descSubtipoClienteCapacitador = newDescSubtipoClienteCapacitador;
    }
    
    public Long getOidTipoClasificacionCapacitador() {
        return oidTipoClasificacionCapacitador;
    }

    public void setOidTipoClasificacionCapacitador(Long newOidTipoClasificacionCapacitador) {
        oidTipoClasificacionCapacitador = newOidTipoClasificacionCapacitador;
    }
    /***********************   FIN AGREGA MAE-015  ***********************/
}