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

package es.indra.sicc.dtos.app;

import es.indra.sicc.util.DTOBelcorp;

public class DTOSolicCabecSecu extends DTOBelcorp {

	private Long oid;  
	private Long oidRuta;
	private Long numSecuenciaFacturacionDiaria;
	private String secuenciaRutaTerritorio;
	private Long numSecuenciaZonasRutas;
    private Long oidCliente;
    private Boolean indicadorUpdateZona = new Boolean(false);
    private Boolean indicadorInsertCliente = new Boolean(false);
    private Long oidRutaNueva;
    private Long numeroSecuenciaNueva;

	public DTOSolicCabecSecu() {
		super();
	}

	public Long getNumSecuenciaFacturacionDiaria() {
		return numSecuenciaFacturacionDiaria;
	}

	public void setNumSecuenciaFacturacionDiaria(Long newNumSecuenciaFacturacionDiaria) {
		numSecuenciaFacturacionDiaria = newNumSecuenciaFacturacionDiaria;
	}

	public Long getNumSecuenciaZonasRutas() {
		return numSecuenciaZonasRutas;
	}

	public void setNumSecuenciaZonasRutas(Long newNumSecuenciaZonasRutas) {
		numSecuenciaZonasRutas = newNumSecuenciaZonasRutas;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidRuta() {
		return oidRuta;
	}

	public void setOidRuta(Long newOidRuta) {
		oidRuta = newOidRuta;
	}

	public String getSecuenciaRutaTerritorio() {
		return secuenciaRutaTerritorio;
	}

	public void setSecuenciaRutaTerritorio(String newSecuenciaRutaTerritorio) {
		secuenciaRutaTerritorio = newSecuenciaRutaTerritorio;
	}

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Boolean getIndicadorUpdateZona() {
        return indicadorUpdateZona;
    }

    public void setIndicadorUpdateZona(Boolean indicadorUpdateZona) {
        this.indicadorUpdateZona = indicadorUpdateZona;
    }

    public Boolean getIndicadorInsertCliente() {
        return indicadorInsertCliente;
    }

    public void setIndicadorInsertCliente(Boolean indicadorInsertCliente) {
        this.indicadorInsertCliente = indicadorInsertCliente;
    }

    public Long getOidRutaNueva() {
        return oidRutaNueva;
    }

    public void setOidRutaNueva(Long oidRutaNueva) {
        this.oidRutaNueva = oidRutaNueva;
    }

    public Long getNumeroSecuenciaNueva() {
        return numeroSecuenciaNueva;
    }

    public void setNumeroSecuenciaNueva(Long numeroSecuenciaNueva) {
        this.numeroSecuenciaNueva = numeroSecuenciaNueva;
    }
}