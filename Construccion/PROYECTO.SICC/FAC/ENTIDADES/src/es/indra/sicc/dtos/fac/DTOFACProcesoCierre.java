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

public class DTOFACProcesoCierre extends DTOBelcorp {

	private Long oid;  
	private Long tipoCierre;  
	private String proceso;   
	private Integer numeroOrdenEjecucion;  
	private String programa;  
	private Long marca;  
	private Long canal;  
	private Long zona; 
	private Long periodo;   
	private Long region;
	private String IDProc;
	private Long subacceso;
	private Boolean indReevaluacion;
    private Long oidProcesoPrecedencia;
    private Date fechaFacturacion;
	
	public DTOFACProcesoCierre() {
		super();
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Integer getNumeroOrdenEjecucion() {
		return numeroOrdenEjecucion;
	}

	public void setNumeroOrdenEjecucion(Integer newNumeroOrdenEjecucion) {
		numeroOrdenEjecucion = newNumeroOrdenEjecucion;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String newProceso) {
		proceso = newProceso;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String newPrograma) {
		programa = newPrograma;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Long getTipoCierre() {
		return tipoCierre;
	}

	public void setTipoCierre(Long newTipoCierre) {
		tipoCierre = newTipoCierre;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}

    public String getIDProc() {
        return IDProc;
    }

    public void setIDProc(String IDProc) {
        this.IDProc = IDProc;
    }

    public Long getSubacceso()
    {
        return subacceso;
    }

    public void setSubacceso(Long subacceso)
    {
        this.subacceso = subacceso;
    }

  public void setIndReevaluacion(Boolean indReevaluacion) {
    this.indReevaluacion = indReevaluacion;
  }

  public Boolean getIndReevaluacion() {
    return indReevaluacion;
  }

    public Long getOidProcesoPrecedencia()
    {
        return oidProcesoPrecedencia;
    }

    public void setOidProcesoPrecedencia(Long oidProcesoPrecedencia)
    {
        this.oidProcesoPrecedencia = oidProcesoPrecedencia;
    }

    public Date getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion)
    {
        this.fechaFacturacion = fechaFacturacion;
    }
  
}