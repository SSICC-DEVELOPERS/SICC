/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOFACCalculosImpuestosSalida extends DTOBelcorp {
    public DTOFACCalculosImpuestosSalida() {
    }

    private Float baseImponibleDescuento3Local;         
    private Float baseImponiblePrecioContableLocal;     
    private Float totalBaseImponibleLocal;              
    private Float totalImpuestosLocal;                  
    private Float totalImporteLocal;                    
    private Float baseImponibleDescuento3Documento;     
    private Float baseImponiblePrecioContableDocumento; 
    private Float totalBaseImponibleDocumento;          
    private Float totalImpuestosDocumento;              
    private Float totalImporteDocumento;     
    //se agrega por la incidencia 19102: Para retrasar la insercion de datos
    //despues de la llamada a insertarConsolidado
    private ArrayList datosAcumuladosImpuestos;

    public Float getBaseImponibleDescuento3Documento() {
        return baseImponibleDescuento3Documento;
    }

    public void setBaseImponibleDescuento3Documento(Float newBaseImponibleDescuento3Documento) {
        baseImponibleDescuento3Documento = newBaseImponibleDescuento3Documento;
    }

    public Float getBaseImponibleDescuento3Local() {
        return baseImponibleDescuento3Local;
    }

    public void setBaseImponibleDescuento3Local(Float newBaseImponibleDescuento3Local) {
        baseImponibleDescuento3Local = newBaseImponibleDescuento3Local;
    }

    public Float getBaseImponiblePrecioContableDocumento() {
        return baseImponiblePrecioContableDocumento;
    }

    public void setBaseImponiblePrecioContableDocumento(Float newBaseImponiblePrecioContableDocumento) {
        baseImponiblePrecioContableDocumento = newBaseImponiblePrecioContableDocumento;
    }

    public Float getBaseImponiblePrecioContableLocal() {
        return baseImponiblePrecioContableLocal;
    }

    public void setBaseImponiblePrecioContableLocal(Float newBaseImponiblePrecioContableLocal) {
        baseImponiblePrecioContableLocal = newBaseImponiblePrecioContableLocal;
    }

    public Float getTotalBaseImponibleDocumento() {
        return totalBaseImponibleDocumento;
    }

    public void setTotalBaseImponibleDocumento(Float newTotalBaseImponibleDocumento) {
        totalBaseImponibleDocumento = newTotalBaseImponibleDocumento;
    }

    public Float getTotalBaseImponibleLocal() {
        return totalBaseImponibleLocal;
    }

    public void setTotalBaseImponibleLocal(Float newTotalBaseImponibleLocal) {
        totalBaseImponibleLocal = newTotalBaseImponibleLocal;
    }

    public Float getTotalImporteDocumento() {
        return totalImporteDocumento;
    }

    public void setTotalImporteDocumento(Float newTotalImporteDocumento) {
        totalImporteDocumento = newTotalImporteDocumento;
    }

    public Float getTotalImporteLocal() {
        return totalImporteLocal;
    }

    public void setTotalImporteLocal(Float newTotalImporteLocal) {
        totalImporteLocal = newTotalImporteLocal;
    }

    public Float getTotalImpuestosDocumento() {
        return totalImpuestosDocumento;
    }

    public void setTotalImpuestosDocumento(Float newTotalImpuestosDocumento) {
        totalImpuestosDocumento = newTotalImpuestosDocumento;
    }

    public Float getTotalImpuestosLocal() {
        return totalImpuestosLocal;
    }

    public void setTotalImpuestosLocal(Float newTotalImpuestosLocal) {
        totalImpuestosLocal = newTotalImpuestosLocal;
    }
    
    public ArrayList getDatosAcumuladosImpuestos() {
        return datosAcumuladosImpuestos;
    }

    public void setDatosAcumuladosImpuestos(ArrayList newDatosAcumuladosImpuestos) {
        datosAcumuladosImpuestos = newDatosAcumuladosImpuestos;
    }

}