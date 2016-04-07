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
 */
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;


public class DTODetalleCaja extends DTOBelcorp { // SO:
    private String nroCajaPTL; // 1:
    private Boolean indChequeo; // 31:
    private String operadorIntroduccionFactura; // 32:
    private String operadorChequeoCajaFactura; // 33:
    private String indicadorCajasAceptadas; // 34:
    private Long numeroTotalCajas; // 35:
    private Long nroActualCajasUsadas; // 36:
    private Long nroCaja; // 37:
    private String tipoCaja; // 38:
    private ArrayList detallesCajaProducto; // Coleccion de objetos DTODetalleCajaProducto (los SS:)
    
    public DTODetalleCaja() {
    }

    public void setNroCajaPTL(String nroCajaPTL) {
        this.nroCajaPTL = nroCajaPTL;
    }

    public String getNroCajaPTL() {
        return nroCajaPTL;
    }

    public void setIndChequeo(Boolean indChequeo) {
        this.indChequeo = indChequeo;
    }

    public Boolean getIndChequeo() {
        return indChequeo;
    }

    public void setOperadorIntroduccionFactura(String operadorIntroduccionFactura) {
        this.operadorIntroduccionFactura = operadorIntroduccionFactura;
    }

    public String getOperadorIntroduccionFactura() {
        return operadorIntroduccionFactura;
    }

    public void setOperadorChequeoCajaFactura(String operadorChequeoCajaFactura) {
        this.operadorChequeoCajaFactura = operadorChequeoCajaFactura;
    }

    public String getOperadorChequeoCajaFactura() {
        return operadorChequeoCajaFactura;
    }

    public void setIndicadorCajasAceptadas(String indicadorCajasAceptadas) {
        this.indicadorCajasAceptadas = indicadorCajasAceptadas;
    }

    public String getIndicadorCajasAceptadas() {
        return indicadorCajasAceptadas;
    }

    public void setNumeroTotalCajas(Long numeroTotalCajas) {
        this.numeroTotalCajas = numeroTotalCajas;
    }

    public Long getNumeroTotalCajas() {
        return numeroTotalCajas;
    }

    public void setNroActualCajasUsadas(Long nroActualCajasUsadas) {
        this.nroActualCajasUsadas = nroActualCajasUsadas;
    }

    public Long getNroActualCajasUsadas() {
        return nroActualCajasUsadas;
    }

    public void setNroCaja(Long nroCaja) {
        this.nroCaja = nroCaja;
    }

    public Long getNroCaja() {
        return nroCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setDetallesCajaProducto(ArrayList detallesCajaProducto) {
        this.detallesCajaProducto = detallesCajaProducto;
    }

    public ArrayList getDetallesCajaProducto() {
        return detallesCajaProducto;
    }

}