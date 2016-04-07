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
import java.sql.Date;

public class DTOSeleccionarCaja extends DTOBelcorp {
    
    private Long oidEtiqueta;
    private String codigoCliente;
    private String nombreCliente;
    private Long numeroConsolidado;
    private Long numeroCaja;
    private Date fechaCreacion;
    
    public DTOSeleccionarCaja() {
    }

    public void setOidEtiqueta(Long oidEtiqueta) {
        this.oidEtiqueta = oidEtiqueta;
    }

    public Long getOidEtiqueta() {
        return oidEtiqueta;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
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

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
}