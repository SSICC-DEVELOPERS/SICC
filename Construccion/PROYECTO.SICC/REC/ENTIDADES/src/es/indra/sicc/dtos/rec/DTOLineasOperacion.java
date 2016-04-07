/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOLineasOperacion extends DTOBelcorp  {
    public DTOLineasOperacion() {
    }
    
    private Long oidLineaOperacion;
    private Integer numeroUnidadesADevolver; // Cambiado de Integer a Long BELC300015967
    private Long oidSolicitudCabecera;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidSubAcceso;
    private Long oidPeriodoReclamo;
    private Long oidCabeceraReclamo;
    private Long numeroAtencion;
    private Boolean esperarMercaderia;
    private Boolean devuelveFisico;
    private BigDecimal precioUnitario;
    private Integer unidadesReclamadas; // Añadido por la BELC300016020
    private Long indEntregaMercaderia;
    private Integer numeroOperacion;
    private Integer numeroUnidadesDevueltas;
    
    public Boolean getDevuelveFisico() {
        return devuelveFisico;
    }

    public void setDevuelveFisico(Boolean devuelveFisico) {
        this.devuelveFisico = devuelveFisico;
    }

    public Boolean getEsperarMercaderia() {
        return esperarMercaderia;
    }

    public void setEsperarMercaderia(Boolean esperarMercaderia) {
        this.esperarMercaderia = esperarMercaderia;
    }

    public Long getNumeroAtencion() {
        return numeroAtencion;
    }

    public void setNumeroAtencion(Long numeroAtencion) {
        this.numeroAtencion = numeroAtencion;
    }

    public Integer getNumeroUnidadesADevolver() {
        return numeroUnidadesADevolver;
    }

    public void setNumeroUnidadesADevolver(Integer numeroUnidadesADevolver) {
        this.numeroUnidadesADevolver = numeroUnidadesADevolver;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidCabeceraReclamo() {
        return oidCabeceraReclamo;
    }

    public void setOidCabeceraReclamo(Long oidCabeceraReclamo) {
        this.oidCabeceraReclamo = oidCabeceraReclamo;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidLineaOperacion() {
        return oidLineaOperacion;
    }

    public void setOidLineaOperacion(Long oidLineaOperacion) {
        this.oidLineaOperacion = oidLineaOperacion;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidPeriodoReclamo() {
        return oidPeriodoReclamo;
    }

    public void setOidPeriodoReclamo(Long oidPeriodoReclamo) {
        this.oidPeriodoReclamo = oidPeriodoReclamo;
    }

    public Long getOidSolicitudCabecera() {
        return oidSolicitudCabecera;
    }

    public void setOidSolicitudCabecera(Long oidSolicitudCabecera) {
        this.oidSolicitudCabecera = oidSolicitudCabecera;
    }

    public Long getOidSubAcceso() {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long oidSubAcceso) {
        this.oidSubAcceso = oidSubAcceso;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getUnidadesReclamadas() {
        return unidadesReclamadas;
    }

    public void setUnidadesReclamadas(Integer unidadesReclamadas) {
        this.unidadesReclamadas = unidadesReclamadas;
    }
    
    public Long getIndEntregaMercaderia(){
        return indEntregaMercaderia;
    }
    
    public void setIndEntregaMercaderia(Long indEntregaMercaderia){
        this.indEntregaMercaderia = indEntregaMercaderia;
    }
    
    public Integer getNumeroOperacion(){
        return this.numeroOperacion;
    }

    public void setNumeroOperacion(Integer numeroOperacion){
        this.numeroOperacion = numeroOperacion;
    }
    
    
    public Integer getNumeroUnidadesDevueltas(){
        return numeroUnidadesDevueltas;
    }
    
    public void setNumeroUnidadesDevueltas(Integer numeroUnidadesDevueltas){
        this.numeroUnidadesDevueltas = numeroUnidadesDevueltas;
    }
}

