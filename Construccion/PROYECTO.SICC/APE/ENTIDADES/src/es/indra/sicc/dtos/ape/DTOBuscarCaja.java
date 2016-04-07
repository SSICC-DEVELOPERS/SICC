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
 *
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarCaja extends DTOBelcorp {

    private Long numeroCaja;
    private Long numeroConsolidado;
    private String ordenVisualChequeo;
    private Long oidOrdenVisual;
    
    public DTOBuscarCaja() {
    }

    public void setNumeroCaja(Long numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public Long getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroConsolidado(Long numeroConsolidado) {
        this.numeroConsolidado = numeroConsolidado;
    }

    public Long getNumeroConsolidado() {
        return numeroConsolidado;
    }
        
    public void setOrdenVisualChequeo(String ordenVisualChequeo) {
        this.ordenVisualChequeo = ordenVisualChequeo;
    }

    public String getOrdenVisualChequeo() {
        return ordenVisualChequeo;
    }    
    
    public void setOidOrdenVisual(Long oidOrdenVisual) {
        this.oidOrdenVisual = oidOrdenVisual;
    }

    public Long getOidOrdenVisual() {
        return oidOrdenVisual;
    }
}