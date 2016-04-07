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

import java.util.Date;
import java.util.ArrayList;

public class DTOGenerarConsolidado extends DTOBelcorp {

    public DTOGenerarConsolidado() {
    }

    private ArrayList listaSolicitudes;    
    private ArrayList secuencia;     
    private Date fechaFacturacion;  
    private String numeroLoteFacturacion;     
    private Character indicadorSecuenciacion;     
    private String IDProceso; 
	private Long IDSpool;
    private String codCaja;
    private Boolean indicadorImpuestosIncluidos;

    public String getIDProceso() {
        return IDProceso;
    }

    public void setIDProceso(String newIDProceso) {
        IDProceso = newIDProceso;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date newFechaFacturacion) {
        fechaFacturacion = newFechaFacturacion;
    }

    public Character getIndicadorSecuenciacion() {
        return indicadorSecuenciacion;
    }

    public void setIndicadorSecuenciacion(Character newIndicadorSecuenciacion) {
        indicadorSecuenciacion = newIndicadorSecuenciacion;
    }

    public ArrayList getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList newListaSolicitudes) {
        listaSolicitudes = newListaSolicitudes;
    }

    public String getNumeroLoteFacturacion() {
        return numeroLoteFacturacion;
    }

    public void setNumeroLoteFacturacion(String newNumeroLoteFacturacion) {
        numeroLoteFacturacion = newNumeroLoteFacturacion;
    }

    public ArrayList getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(ArrayList newSecuencia) {
        secuencia = newSecuencia;
    }

	public Long getIDSpool() {
		return IDSpool;
	}

	public void setIDSpool(Long newIDSpool) {
		IDSpool = newIDSpool;
	}
    
    public String getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(String newCodCaja) {
        codCaja = newCodCaja;
    }
    
    public Boolean getIndicadorImpuestosIncluidos() {
        return indicadorImpuestosIncluidos;
    }

    public void setindicadorImpuestosIncluidos(Boolean newIndicadorImpuestosIncluidos) {
        indicadorImpuestosIncluidos = newIndicadorImpuestosIncluidos;
    }
    
    
}