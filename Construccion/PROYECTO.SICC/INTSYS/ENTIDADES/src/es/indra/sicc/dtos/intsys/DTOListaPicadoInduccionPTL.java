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

/**
 * Sistema:		Belcorp
 * Modulo:	   	INT 
 * Fecha:		23/01/2007
 * @version		1.0
 * @autor		SPLATAS
 */

package es.indra.sicc.dtos.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaPicadoInduccionPTL extends DTOBelcorp {
    private Long numeroConsolidado;
    private Long nroFactura;
    private Long nroCaja;
    private String nroCajaPTL;
    private Boolean indChequeo;
    private String operadorIntroduccionFactura;
    private String operadorChequeoCajaFactura;
    private String tipoCaja;
    private String anaquel;
    private Long cantidadRequeridaPicar;
    private String nombrePicadorProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private Long nroTotalCajas;
    private Long nroOriginalCajasFactura;
    private Long cantidadActualPicada;   
    
    private ArrayList detallesCaja; // Coleccion de objetos DTODetalleCaja
    

    public DTOListaPicadoInduccionPTL(){ }
    
    public Long getNroOriginalCajasFactura() {
        return this.nroOriginalCajasFactura;
    }
    
    public void setNroOriginalCajasFactura(Long nroOriginalCajasFactura) {
        this.nroOriginalCajasFactura = nroOriginalCajasFactura;
    }
    
    public Long getCantidadActualPicada() {
        return this.cantidadActualPicada;
    }
    
    public void setCantidadActualPicada(Long cantidadActualPicada) {
        this.cantidadActualPicada = cantidadActualPicada;
    }  

    public Long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Long getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(Long nroCaja) {
        this.nroCaja = nroCaja;
    }

    public String getNroCajaPTL() {
        return nroCajaPTL;
    }

    public void setNroCajaPTL(String nroCajaPTL) {
        this.nroCajaPTL = nroCajaPTL;
    }

    public Boolean getIndChequeo() {
        return indChequeo;
    }

    public void setIndChequeo(Boolean indChequeo) {
        this.indChequeo = indChequeo;
    }

    public String getOperadorIntroduccionFactura() {
        return operadorIntroduccionFactura;
    }

    public void setOperadorIntroduccionFactura(String operadorIntroduccionFactura) {
        this.operadorIntroduccionFactura = operadorIntroduccionFactura;
    }

    public String getOperadorChequeoCajaFactura() {
        return operadorChequeoCajaFactura;
    }

    public void setOperadorChequeoCajaFactura(String operadorChequeoCajaFactura) {
        this.operadorChequeoCajaFactura = operadorChequeoCajaFactura;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public String getAnaquel() {
        return anaquel;
    }

    public void setAnaquel(String anaquel) {
        this.anaquel = anaquel;
    }

    public Long getCantidadRequeridaPicar() {
        return cantidadRequeridaPicar;
    }

    public void setCantidadRequeridaPicar(Long cantidadRequeridaPicar) {
        this.cantidadRequeridaPicar = cantidadRequeridaPicar;
    }

    public String getNombrePicadorProducto() {
        return nombrePicadorProducto;
    }

    public void setNombrePicadorProducto(String nombrePicadorProducto) {
        this.nombrePicadorProducto = nombrePicadorProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void limpiarDatosDetalle() throws MareException {
        this.setAnaquel(null);
        this.setCantidadRequeridaPicar(null);
        this.setNombrePicadorProducto(null);
        this.setCodigoProducto(null);
        this.setDescripcionProducto(null);
    }

    public Long getNroTotalCajas() {
        return nroTotalCajas;
    }

    public void setNroTotalCajas(Long nroTotalCajas) {
        this.nroTotalCajas = nroTotalCajas;
    }

    public void setDetallesCaja(ArrayList detallesCaja) {
        this.detallesCaja = detallesCaja;
    }

    public ArrayList getDetallesCaja() {
        return detallesCaja;
    }


    public void setNumeroConsolidado(Long numeroConsolidado) {
        this.numeroConsolidado = numeroConsolidado;
    }


    public Long getNumeroConsolidado() {
        return numeroConsolidado;
    }

}