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
import es.indra.sicc.util.DTOOIDs;

import java.util.Date;

public class DTOFACCierreFacturacion extends DTOBelcorp {

	private Long marca;  
	private Long canal;  
	private Long periodo;  
	private Long tipoCierre;  
	private DTOOIDs regiones;     
	private DTOOIDs zonas;
	private String codigoTipoCierre; //Añadido Incidencia 11494
    private String IDProc;
    private Long subacceso;
  private Long zona;
  
        // sapaza -- PER-SiCC-2011-0544 -- 02/08/2011    
        private Date fecha;
        private String codigoUsuario;

	public DTOFACCierreFacturacion() {
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

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public DTOOIDs getRegiones() {
		return regiones;
	}

	public void setRegiones(DTOOIDs newRegiones) {
		regiones = newRegiones;
	}

	public Long getTipoCierre() {
		return tipoCierre;
	}

	public void setTipoCierre(Long newTipoCierre) {
		tipoCierre = newTipoCierre;
	}

	public DTOOIDs getZonas() {
		return zonas;
	}

	public void setZonas(DTOOIDs newZonas) {
		zonas = newZonas;
	}

	public String getCodigoTipoCierre() {
		return codigoTipoCierre;
	}

	public void setCodigoTipoCierre(String newCodigoTipoCierre) {
		codigoTipoCierre = newCodigoTipoCierre;
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

  public Long getZona()
  {
    return zona;
  }

  public void setZona(Long zona)
  {
    this.zona = zona;
  }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }
}
