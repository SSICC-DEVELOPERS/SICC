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

public class DTOBuscarCajasChequear extends DTOBelcorp {

    private Long numeroCaja;
    private Long numeroConsolidado;
    private String codigoCliente;
    private String codigoUsuario;
    
    public DTOBuscarCajasChequear() {
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

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

}