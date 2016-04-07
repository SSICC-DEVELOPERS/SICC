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
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTODatosCaja extends DTOBelcorp {

    private Long numeroConsolidado;
    private Long numeroCaja;
    private Long numeroTotalCajas;
    private String estado;
    private Long oidEtiqueta;
    private String codigoUsuario;
    private ArrayList detalles;
    
    public DTODatosCaja() {
    }

    public void setNumeroConsolidado(Long numeroConsolidado) {
        this.numeroConsolidado = numeroConsolidado;
    }

    public Long getNumeroConsolidado() {
        return numeroConsolidado;
    }

    public void setNumeroCaja(Long numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public Long getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroTotalCajas(Long numeroTotalCajas) {
        this.numeroTotalCajas = numeroTotalCajas;
    }

    public Long getNumeroTotalCajas() {
        return numeroTotalCajas;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setOidEtiqueta(Long oidEtiqueta) {
        this.oidEtiqueta = oidEtiqueta;
    }

    public Long getOidEtiqueta() {
        return oidEtiqueta;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setDetalles(ArrayList detalles) {
        this.detalles = detalles;
    }

    public ArrayList getDetalles() {
        return detalles;
    }

}