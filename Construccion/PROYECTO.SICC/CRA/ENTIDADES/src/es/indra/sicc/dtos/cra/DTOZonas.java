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

package es.indra.sicc.dtos.cra;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Emilio Noziglia
 */
public class DTOZonas extends DTOAuditableSICC {
    private java.lang.Long pais;
    private java.lang.Long marca;
    private java.lang.Long canal;
    private String subgerenciaVentas;
    private String region;
    private String codigoZona;
    private String codigoGerente;
    private Long codigoEstadoZona;
    private Integer activa;
    private Integer borrado;
    private String nse1;
    private String nse2;
    private String nse3;        
    private java.lang.Long oidZona;
    private Long oidRegion;
    private Long oidSubgerenciaVentas;
    private String descZona;
        
    public DTOZonas() {
        super();
    }

    public DTOZonas(java.lang.Long pais, java.lang.Long marca, java.lang.Long canal, String subgerenciaVentas, String region, String codigoZona, String codigoGerente, Long codigoEstadoZona, Integer activa, Integer borrado, String nse1, String nse2, String nse3) {
        super();
        this.pais = pais;
        this.marca = marca;
        this.canal = canal;
        this.subgerenciaVentas = subgerenciaVentas;
        this.region = region;
        this.codigoZona = codigoZona;
        this.codigoGerente = codigoGerente;
        this.codigoEstadoZona = codigoEstadoZona;
        this.activa = activa;
        this.borrado = borrado;
        this.nse1 = nse1;
        this.nse2 = nse2;
        this.nse3 = nse3;        
    }

    public java.lang.Long getPais() {
        return this.pais;
    }

    public void setPais(java.lang.Long pais) {
        this.pais = pais;
    }

    public java.lang.Long getMarca() {
        return this.marca;
    }

    public void setMarca(java.lang.Long marca) {
        this.marca = marca;
    }

    public java.lang.Long getCanal() {
        return this.canal;
    }

    public void setCanal(java.lang.Long canal) {
        this.canal = canal;
    }

    public String getSubgerenciaVentas() {
        return this.subgerenciaVentas;
    }

    public void setSubgerenciaVentas(String subgerenciaVentas) {
        this.subgerenciaVentas = subgerenciaVentas;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoZona() {
        return this.codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getCodigoGerente() {
        return this.codigoGerente;
    }

    public void setCodigoGerente(String codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    public Long getCodigoEstadoZona() {
        return this.codigoEstadoZona;
    }

    public void setCodigoEstadoZona(Long codigoEstadoZona) {
        this.codigoEstadoZona = codigoEstadoZona;
    }

    public Integer getActiva() {
        return this.activa;
    }

    public void setActiva(Integer activa) {
        this.activa = activa;
    }

    public Integer getBorrado() {
        return this.borrado;
    }

    public void setBorrado(Integer borrado) {
        this.borrado = borrado;
    }

    public String getNse1() {
        return this.nse1;
    }

    public void setNse1(String nse1) {
        this.nse1 = nse1;
    }
    public String getNse2() {
        return this.nse2;
    }

    public void setNse2(String nse2) {
        this.nse2 = nse2;
    }
    public String getNse3() {
        return this.nse3;
    }

    public void setNse3(String nse3) {
        this.nse3 = nse3;
    }    

    public java.lang.Long getOidZona() {
        return this.oidZona;
    }

    public void setOidZona(java.lang.Long oidZona) {
        this.oidZona = oidZona;
    }
    public java.lang.Long getOidRegion() {
        return this.oidRegion;
    }

    public void setOidRegion(java.lang.Long oidRegion) {
        this.oidRegion = oidRegion;
    }
    public java.lang.Long getOidSubgerenciaVentas() {
        return this.oidSubgerenciaVentas;
    }

    public void setOidSubgerenciaVentas(java.lang.Long oidSubgerenciaVentas) {
        this.oidSubgerenciaVentas = oidSubgerenciaVentas;
    }    

    public String getDescZona()
    {
      return descZona;
    }

    public void setDescZona(String newDescZona)
    {
      descZona = newDescZona;
    }
}