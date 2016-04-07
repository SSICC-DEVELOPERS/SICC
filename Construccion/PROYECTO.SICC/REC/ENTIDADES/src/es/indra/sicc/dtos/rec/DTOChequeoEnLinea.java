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

public class DTOChequeoEnLinea extends DTOBelcorp  {
    public DTOChequeoEnLinea() {
    }
    
    private Long oidPeriodo;
    private Long oidSubgerenciaVentas;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Long oidPeriodoInicial;
    private Long oidPeriodoFinal;
    private Integer cantidadMinima;
    private Boolean consultoraNueva;

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Boolean getConsultoraNueva() {
        return consultoraNueva;
    }

    public void setConsultoraNueva(Boolean consultoraNueva) {
        this.consultoraNueva = consultoraNueva;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodoFinal() {
        return oidPeriodoFinal;
    }

    public void setOidPeriodoFinal(Long oidPeriodoFinal) {
        this.oidPeriodoFinal = oidPeriodoFinal;
    }

    public Long getOidPeriodoInicial() {
        return oidPeriodoInicial;
    }

    public void setOidPeriodoInicial(Long oidPeriodoInicial) {
        this.oidPeriodoInicial = oidPeriodoInicial;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidSeccion() {
        return oidSeccion;
    }

    public void setOidSeccion(Long oidSeccion) {
        this.oidSeccion = oidSeccion;
    }

    public Long getOidSubgerenciaVentas() {
        return oidSubgerenciaVentas;
    }

    public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas) {
        this.oidSubgerenciaVentas = oidSubgerenciaVentas;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }
}