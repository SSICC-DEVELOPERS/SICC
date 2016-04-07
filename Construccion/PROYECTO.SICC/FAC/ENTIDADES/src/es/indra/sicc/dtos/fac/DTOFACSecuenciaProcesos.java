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

public class DTOFACSecuenciaProcesos extends DTOBelcorp{

    public DTOFACSecuenciaProcesos() {
    }

    //private Long pais;   eliminado por la incidencia 8672  
    private Long tipoSolicitud;     
    private Integer secuencia;     
    private String grupoProcesos;     
    private String codigoProceso;     
    private Boolean indicadorEjecucionEnLinea; //Incidencia BELC300008616
    private String nombrePrograma;     
    private String claseEjecucion;
	private Long oidGrupoProcesos;  // Añadido por incidencia 8725	
	private Long oidProceso; 		// Añadido por incidencia 8725
	private String businessID;		// Añadido por incidencia 10119

    public String getClaseEjecucion() {
        return claseEjecucion;
    }

    public void setClaseEjecucion(String newClaseEjecucion) {
        claseEjecucion = newClaseEjecucion;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(String newCodigoProceso) {
        codigoProceso = newCodigoProceso;
    }

    public String getGrupoProcesos() {
        return grupoProcesos;
    }

    public void setGrupoProcesos(String newGrupoProcesos) {
        grupoProcesos = newGrupoProcesos;
    }

    public Boolean getIndicadorEjecucionEnLinea() {
        return indicadorEjecucionEnLinea;
    }

    public void setIndicadorEjecucionEnLinea(Boolean newIndicadorEjecucionEnLinea) {
        indicadorEjecucionEnLinea = newIndicadorEjecucionEnLinea;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String newNombrePrograma) {
        nombrePrograma = newNombrePrograma;
    }


    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer newSecuencia) {
        secuencia = newSecuencia;
    }

    public Long getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(Long newTipoSolicitud) {
        tipoSolicitud = newTipoSolicitud;
    }

	public Long getOidGrupoProcesos() {
		return oidGrupoProcesos;
	}

	public void setOidGrupoProcesos(Long newOidGrupoProcesos) {
		oidGrupoProcesos = newOidGrupoProcesos;
	}

	public Long getOidProceso() {
		return oidProceso;
	}

	public void setOidProceso(Long newOidProceso) {
		oidProceso = newOidProceso;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String newBusinessID) {
		businessID = newBusinessID;
	}
}