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
 * 
 * @author: Carlos Leal
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.util.ArrayList;


public class ConcursoVariablesVenta implements Serializable {
    private Long oidConcurso;
    private Boolean activas;
    private Boolean ingreso;
    private Boolean reingreso;
    private Boolean egresos;
    private Boolean entregadas;
    private Boolean recibidas;
    private Boolean capitalizacion;
    private Boolean activasFinales;
    private Boolean actividad;
    private Boolean numeroPedidos;
    private Boolean precioPromedioUnitario;
    private Boolean promedioVentaPedido;
    private Boolean promedioUnidadesPedido;
    private Boolean promedioOrdenesPedido;
    private Boolean retencion;
    private Boolean ventaEstadisticable;
    private Long oidTipoDeterminacionMeta;
    private Boolean rotacion;
    private Boolean indProductosExigidos;
    private Long[] oidAccesos;
    private Periodo periodoDesde;
    private Periodo periodoHasta;
    private ArrayList periodosControl;
    private ArrayList ambitosGerograficos;

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Boolean getActivas() {
        return activas;
    }

    public void setActivas(Boolean activas) {
        this.activas = activas;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public Boolean getReingreso() {
        return reingreso;
    }

    public void setReingreso(Boolean reingreso) {
        this.reingreso = reingreso;
    }

    public Boolean getEgresos() {
        return egresos;
    }

    public void setEgresos(Boolean egresos) {
        this.egresos = egresos;
    }

    public Boolean getEntregadas() {
        return entregadas;
    }

    public void setEntregadas(Boolean entregadas) {
        this.entregadas = entregadas;
    }

    public Boolean getRecibidas() {
        return recibidas;
    }

    public void setRecibidas(Boolean recibidas) {
        this.recibidas = recibidas;
    }

    public Boolean getCapitalizacion() {
        return capitalizacion;
    }

    public void setCapitalizacion(Boolean capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public Boolean getActivasFinales() {
        return activasFinales;
    }

    public void setActivasFinales(Boolean activasFinales) {
        this.activasFinales = activasFinales;
    }

    public Boolean getActividad() {
        return actividad;
    }

    public void setActividad(Boolean actividad) {
        this.actividad = actividad;
    }

    public Boolean getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(Boolean numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public Boolean getPrecioPromedioUnitario() {
        return precioPromedioUnitario;
    }

    public void setPrecioPromedioUnitario(Boolean precioPromedioUnitario) {
        this.precioPromedioUnitario = precioPromedioUnitario;
    }

    public Boolean getPromedioVentaPedido() {
        return promedioVentaPedido;
    }

    public void setPromedioVentaPedido(Boolean promedioVentaPedido) {
        this.promedioVentaPedido = promedioVentaPedido;
    }

    public Boolean getPromedioUnidadesPedido() {
        return promedioUnidadesPedido;
    }

    public void setPromedioUnidadesPedido(Boolean promedioUnidadesPedido) {
        this.promedioUnidadesPedido = promedioUnidadesPedido;
    }

    public Boolean getPromedioOrdenesPedido() {
        return promedioOrdenesPedido;
    }

    public void setPromedioOrdenesPedido(Boolean promedioOrdenesPedido) {
        this.promedioOrdenesPedido = promedioOrdenesPedido;
    }

    public Boolean getRetencion() {
        return retencion;
    }

    public void setRetencion(Boolean retencion) {
        this.retencion = retencion;
    }

    public Boolean getVentaEstadisticable() {
        return ventaEstadisticable;
    }

    public void setVentaEstadisticable(Boolean ventaEstadisticable) {
        this.ventaEstadisticable = ventaEstadisticable;
    }

    public Long getOidTipoDeterminacionMeta() {
        return oidTipoDeterminacionMeta;
    }

    public void setOidTipoDeterminacionMeta(Long oidTipoDeterminacionMeta) {
        this.oidTipoDeterminacionMeta = oidTipoDeterminacionMeta;
    }

    public Boolean getRotacion() {
        return rotacion;
    }

    public void setRotacion(Boolean rotacion) {
        this.rotacion = rotacion;
    }

    public Boolean getIndProductosExigidos() {
        return indProductosExigidos;
    }

    public void setIndProductosExigidos(Boolean indProductosExigidos) {
        this.indProductosExigidos = indProductosExigidos;
    }

    public void setOidAccesos(Long[] oidAccesos) {
        this.oidAccesos = oidAccesos;
    }

    public Long[] getOidAccesos() {
        return oidAccesos;
    }

    public Periodo getPeriodoDesde() {
        return periodoDesde;
    }

    public void setPeriodoDesde(Periodo periodoDesde) {
        this.periodoDesde = periodoDesde;
    }

    public Periodo getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodoHasta(Periodo periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    public ArrayList getPeriodosControl() {
        return periodosControl;
    }

    public void setPeriodosControl(ArrayList periodosControl) {
        this.periodosControl = periodosControl;
    }

    public ArrayList getAmbitosGerograficos() {
        return ambitosGerograficos;
    }

    public void setAmbitosGerograficos(ArrayList ambitosGerograficos) {
        this.ambitosGerograficos = ambitosGerograficos;
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param Periodo periodoControl
    * @version 1.00 09/06/2005
    * @author: Carlos Leal
    * Descripcion: este método retorna el periodo de control anterior al 
    * periodo recibido por parametro.
    */
    public Periodo getPeriodoControlAnterior(Periodo periodoControl, Periodo PeriodoDesde) {
        UtilidadesLog.info("ConcursoVariablesVenta.getPeriodoControlAnte "
            + "rior(Periodo periodoControl, Periodo periodoControl):Entrada");
       
        int sizeArrayList = periodosControl!=null?periodosControl.size():0;

        for (int i = 0; i < sizeArrayList; i++) {
            if (((Periodo) periodosControl.get(i)).equals(periodoControl)) {
                UtilidadesLog.info("ConcursoVariablesVenta.getPeriodoControl "
                    +"Anterior(Periodo periodoControl, Periodo periodoControl):Salida");
                if (i!=0){                    
                    return ((Periodo) periodosControl.get(i - 1));
                } else {
                    return PeriodoDesde;
                }
            }
        }
        
        UtilidadesLog.info("ConcursoVariablesVenta.getPeriodoControlAnterior( "
            +"Periodo periodoControl):Salida");

        return PeriodoDesde;
    }
}
