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
 *
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.math.BigDecimal;

public class Faltante implements Serializable {
    private Long oidPais;
    private Long oidSolicitud;
    private Long oidBolsaFaltantes;
    private Long oidCliente;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidZona;
    private String codigoZona;
    private Long oidPeriodo;
    // vbongiov -- 12/07/2006 -- inc DBLG500000920
    private String numeroConcurso;
    private Long oidConcurso;
    private String codigoProducto;
    private String codigoVentaFicticio;
    private Long dirigidoA;
    private Double unidadesDemandadas;
    private BigDecimal precioPublico;
    private String nombreCliente;
    private String apellidoCliente;
    private String cuentaCliente;
    private Long codigoTerritorio;
    private String codigoPeriodoInicioConcurso;
    private String codigoPeriodoFinConcurso;
    private String codigoPeriodoDespacho;
    private String codigoMensaje;
    private Boolean comunicacionEnObtencionPuntos;
    private Boolean indEnvioMensaje;
    private Long oidProducto;
    private Long oidSubacceso;
    private Long numeroPremio;
  
    //jrivas SiCC 20070242  28/5/07
    private String nombreConcurso;

    public Faltante() {
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setCodigoMensaje(String codigoMensaje) {
        this.codigoMensaje = codigoMensaje;
    }

    public String getCodigoMensaje() {
        return codigoMensaje;
    }

    public void setCodigoPeriodoDespacho(String codigoPeriodoDespacho) {
        this.codigoPeriodoDespacho = codigoPeriodoDespacho;
    }

    public String getCodigoPeriodoDespacho() {
        return codigoPeriodoDespacho;
    }

    public void setCodigoPeriodoFinConcurso(String codigoPeriodoFinConcurso) {
        this.codigoPeriodoFinConcurso = codigoPeriodoFinConcurso;
    }

    public String getCodigoPeriodoFinConcurso() {
        return codigoPeriodoFinConcurso;
    }

    public void setCodigoPeriodoInicioConcurso(String codigoPeriodoInicioConcurso) {
        this.codigoPeriodoInicioConcurso = codigoPeriodoInicioConcurso;
    }

    public String getCodigoPeriodoInicioConcurso() {
        return codigoPeriodoInicioConcurso;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoTerritorio(Long codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }

    public Long getCodigoTerritorio() {
        return codigoTerritorio;
    }

    public void setCodigoVentaFicticio(String codigoVentaFicticio) {
        this.codigoVentaFicticio = codigoVentaFicticio;
    }

    public String getCodigoVentaFicticio() {
        return codigoVentaFicticio;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setComunicacionEnObtencionPuntos(Boolean comunicacionEnObtencionPuntos) {
        this.comunicacionEnObtencionPuntos = comunicacionEnObtencionPuntos;
    }

    public Boolean isComunicacionEnObtencionPuntos() {
        return comunicacionEnObtencionPuntos;
    }

    public void setCuentaCliente(String cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public String getCuentaCliente() {
        return cuentaCliente;
    }

    public void setDirigidoA(Long dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public Long getDirigidoA() {
        return dirigidoA;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidBolsaFaltantes(Long oidBolsaFaltantes) {
        this.oidBolsaFaltantes = oidBolsaFaltantes;
    }

    public Long getOidBolsaFaltantes() {
        return oidBolsaFaltantes;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidSolicitud(Long oidSolicitud) {
        this.oidSolicitud = oidSolicitud;
    }

    public Long getOidSolicitud() {
        return oidSolicitud;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setPrecioPublico(BigDecimal precioPublico) {
        this.precioPublico = precioPublico;
    }

    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    public void setUnidadesDemandadas(Double unidadesDemandadas) {
        this.unidadesDemandadas = unidadesDemandadas;
    }

    public Double getUnidadesDemandadas() {
        return unidadesDemandadas;
    }

    public Boolean getIndEnvioMensaje() {
        return indEnvioMensaje;
    }

    public void setIndEnvioMensaje(Boolean indEnvioMensaje) {
        this.indEnvioMensaje = indEnvioMensaje;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long oidSubacceso)
    {
        this.oidSubacceso = oidSubacceso;
    }
    
        public Long getNumeroPremio()
    {
        return numeroPremio;
    }

    public void setNumeroPremio(Long numeroPremio)
    {
        this.numeroPremio = numeroPremio;
    }

  public String getNombreConcurso()
  {
    return nombreConcurso;
  }

  public void setNombreConcurso(String nombreConcurso)
  {
    this.nombreConcurso = nombreConcurso;
  }
}
