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

package es.indra.sicc.logicanegocio.fac;

import java.io.Serializable;
import java.util.ArrayList;

public class CalculosImporteMoneda implements Serializable {
    public CalculosImporteMoneda() {
    }

    private ArrayList listaPosiciones=null;
    private Float baseImponiblePosicionLocal;
    private Float totalPreciosPosicionLocal; 
    private Float totalDescuentoCabeceraLocal; 
    private Float baseImponibleDescuento3Local; 
    private Float baseImponiblePrecioContableLocal; 
    private Float baseImponibleFleteLocal; 
    private Float totalBaseImponibleLocal; 
    private Float totalImpuestosLocal;
    private Float totalImporteLocal; 
    private Float baseImponiblePosicionesDocumento; 
    private Float totalPreciosPosicionDocumento; 
    private Float totalDescuentoCabeceraDocumento; 
    private Float baseImponibleDescuento3Documento; 
    private Float baseImponiblePrecioContableDocumento; 
    private Float baseImponibleFleteDocumento; 
    private Float totalBaseImponibleDocumento;
    private Float totalImpuestosDocumento;
    private Float totalImporteDocumento;  
    private Boolean indicadorImpuestosFlete;
    //se agrega por la incidencia 19102: Para retrasar la insercion de datos
    //despues de la llamada a insertarConsolidado
    private Long claveIndicadorImpuestos;

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

    public Float getBaseImponibleFleteDocumento() {
        return baseImponibleFleteDocumento;
    }

    public void setBaseImponibleFleteDocumento(Float newBaseImponibleFleteDocumento) {
        baseImponibleFleteDocumento = newBaseImponibleFleteDocumento;
    }

    public Float getBaseImponibleFleteLocal() {
        return baseImponibleFleteLocal;
    }

    public void setBaseImponibleFleteLocal(Float newBaseImponibleFleteLocal) {
        baseImponibleFleteLocal = newBaseImponibleFleteLocal;
    }

    public Float getBaseImponiblePosicionLocal() {
        return baseImponiblePosicionLocal;
    }

    public void setBaseImponiblePosicionLocal(Float newBaseImponiblePosicionLocal) {
        baseImponiblePosicionLocal = newBaseImponiblePosicionLocal;
    }

    public Float getBaseImponiblePosicionesDocumento() {
        return baseImponiblePosicionesDocumento;
    }

    public void setBaseImponiblePosicionesDocumento(Float newBaseImponiblePosicionesDocumento) {
        baseImponiblePosicionesDocumento = newBaseImponiblePosicionesDocumento;
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
    

    public Boolean getIndicadorImpuestosFlete() {
        return indicadorImpuestosFlete;
    }

    public void setIndicadorImpuestosFlete(Boolean newIndicadorImpuestosFlete) {
        indicadorImpuestosFlete = newIndicadorImpuestosFlete;
    }

    public ArrayList getListaPosiciones() {
        return listaPosiciones;
    }

    public void setListaPosiciones(ArrayList newListaPosiciones) {
        listaPosiciones = newListaPosiciones;
    }

    public Float getTotalBaseImponibleLocal() {
        return totalBaseImponibleLocal;
    }

    public void setTotalBaseImponibleLocal(Float newTotalBaseImponibleLocal) {
        totalBaseImponibleLocal = newTotalBaseImponibleLocal;
    }

    public Float getTotalDescuentoCabeceraDocumento() {
        return totalDescuentoCabeceraDocumento;
    }

    public void setTotalDescuentoCabeceraDocumento(Float newTotalDescuentoCabeceraDocumento) {
        totalDescuentoCabeceraDocumento = newTotalDescuentoCabeceraDocumento;
    }

    public Float getTotalDescuentoCabeceraLocal() {
        return totalDescuentoCabeceraLocal;
    }

    public void setTotalDescuentoCabeceraLocal(Float newTotalDescuentoCabeceraLocal) {
        totalDescuentoCabeceraLocal = newTotalDescuentoCabeceraLocal;
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

    public Float getTotalPreciosPosicionDocumento() {
        return totalPreciosPosicionDocumento;
    }

    public void setTotalPreciosPosicionDocumento(Float newTotalPreciosPosicionDocumento) {
        totalPreciosPosicionDocumento = newTotalPreciosPosicionDocumento;
    }

    public Float getTotalPreciosPosicionLocal() {
        return totalPreciosPosicionLocal;
    }

    public void setTotalPreciosPosicionLocal(Float newTotalPreciosPosicionLocal) {
        totalPreciosPosicionLocal = newTotalPreciosPosicionLocal;
    }

    public Float getTotalBaseImponibleDocumento() {
        return totalBaseImponibleDocumento;
    }

    public void setTotalBaseImponibleDocumento(Float newTotalBaseImponibleDocumento) {
        totalBaseImponibleDocumento = newTotalBaseImponibleDocumento;
    }
    
    public Long getClaveIndicadorImpuestos() {
        return claveIndicadorImpuestos;
    }

    public void setClaveIndicadorImpuestos(Long newClaveIndicadorImpuestos) {
        claveIndicadorImpuestos = newClaveIndicadorImpuestos;
    }

    
}
