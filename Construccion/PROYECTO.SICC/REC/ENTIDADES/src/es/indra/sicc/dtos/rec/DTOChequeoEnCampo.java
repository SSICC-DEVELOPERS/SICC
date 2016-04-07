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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOChequeoEnCampo extends DTOBelcorp  {
    public DTOChequeoEnCampo() {
    }
    
    private Long oid;
    private Long oidPeriodo;
    private String cantidadTotalChequear;
    private Long oidPeriodoInicial;
    private Long oidPeriodoFinal;
    private Long oidPeriodoReclamo;
    private Boolean consultoraNueva;
    private ArrayList listaZonas;
    private RecordSet busquedaZonas;

    public RecordSet getBusquedaZonas() {
        return busquedaZonas;
    }

    public void setBusquedaZonas(RecordSet busquedaZonas) {
        this.busquedaZonas = busquedaZonas;
    }

    public String getCantidadTotalChequear() {
        return cantidadTotalChequear;
    }

    public void setCantidadTotalChequear(String cantidadTotalChequear) {
        this.cantidadTotalChequear = cantidadTotalChequear;
    }

    public Boolean getConsultoraNueva() {
        return consultoraNueva;
    }

    public void setConsultoraNueva(Boolean consultoraNueva) {
        this.consultoraNueva = consultoraNueva;
    }

    public ArrayList getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(ArrayList listaZonas) {
        this.listaZonas = listaZonas;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public Long getOidPeriodoReclamo() {
        return oidPeriodoReclamo;
    }

    public void setOidPeriodoReclamo(Long oidPeriodoReclamo) {
        this.oidPeriodoReclamo = oidPeriodoReclamo;
    }
}