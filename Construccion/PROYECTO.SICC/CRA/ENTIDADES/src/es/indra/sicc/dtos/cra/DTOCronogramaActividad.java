/*
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.cra;

//import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.sql.Date;
import java.util.Collection;
import java.util.ArrayList;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Se importa desde version 2 y se modifica segun las necesidades
 *                    y requerimientos de la V3.
 * @version           1.0
 * @autor             Gaston Acevedo
 */

public class DTOCronogramaActividad extends DTOAuditableSICC {

  private Long oidActividad;
	private String codActividad;
	private Boolean tipoActividad;
	private String nombreActividad;
	private String TipoFacturacion;
	private Long actividadReferenciada;
    private Date fechaInicio;
	private Integer fechaMedia;
	private Date fechaFin;
	private Integer dias;
	private Integer nuevaFecha;
    private Boolean flagFija;
    
    private Collection actFueraPeriodo = new ArrayList();
    private Integer diasFinal;
    private Integer diasIntervalo;
  
    private Long region;
    private Long subgerenciaVentas;
    private Long zona;
    private Long oidCronograma;
  

	public DTOCronogramaActividad() {
		super();
	}

	public DTOCronogramaActividad(
      Long oidActividad,
      String codActividad,
			Boolean tipoActividad,
			String nombreActividad,
			String TipoFacturacion,
			Long actividadReferenciada,
			Integer fechaMedia,
			Date fechaFin,
			Integer dias,
			Integer nuevaFecha
             ) {
		super();
    this.oidActividad = oidActividad;
		this.codActividad = codActividad;
		this.tipoActividad = tipoActividad;
		this.nombreActividad = nombreActividad;
		this.TipoFacturacion = TipoFacturacion;
		this.actividadReferenciada = actividadReferenciada;
		this.fechaMedia = fechaMedia;
		this.fechaFin = fechaFin;
		this.dias = dias;
		this.nuevaFecha = nuevaFecha;
    
	}

  public Long getOidActividad(){
    return oidActividad;
  }
  public void setOidActividad(Long newValue){
    oidActividad = newValue;
  }

  public Boolean getFlagFija(){
      return this.flagFija;
  }

  public void setFlagFija(Boolean flagFija){
      this.flagFija = flagFija;
  }
    
	public String getCodActividad(){
		return this.codActividad;
	}

	public void setCodActividad( String codActividad){
		this.codActividad = codActividad;
	}

	public Boolean getTipoActividad(){
		return this.tipoActividad;
	}

	public void setTipoActividad( Boolean tipoActividad){
		this.tipoActividad = tipoActividad;
	}

	public String getNombreActividad(){
		return this.nombreActividad;
	}

	public void setNombreActividad( String nombreActividad){
		this.nombreActividad = nombreActividad;
	}

	public String getTipoFacturacion(){
		return this.TipoFacturacion;
	}

	public void setTipoFacturacion( String TipoFacturacion){
		this.TipoFacturacion = TipoFacturacion;
	}

	public Long getActividadReferenciada(){
		return this.actividadReferenciada;
	}

	public void setActividadReferenciada( Long actividadReferenciada){
		this.actividadReferenciada = actividadReferenciada;
	}

	public Integer getFechaMedia(){
		return this.fechaMedia;
	}

	public void setFechaMedia( Integer fechaMedia){
		this.fechaMedia = fechaMedia;
	}

	public Date getFechaFin(){
		return this.fechaFin;
	}

	public void setFechaFin( Date fechaFin){
		this.fechaFin = fechaFin;
	}

	public Integer getDias(){
		return this.dias;
	}

	public void setDias( Integer dias){
		this.dias = dias;
	}

	public Integer getNuevaFecha(){
		return this.nuevaFecha;
	}

	public void setNuevaFecha( Integer nuevaFecha){
		this.nuevaFecha = nuevaFecha;
	}

    public Collection getActFueraPeriodo() {
        //Definido por Gabriel Guardincerri
        return actFueraPeriodo;
    }
    
    public void setActFueraPeriodo(Collection c) {
        //Definido por Gabriel Guardincerri
        actFueraPeriodo = c;
    }

    public void addActividadFueraPeriodo(DTOCronogramaActividad act) {
        //Definido por Gabriel Guardincerri
        actFueraPeriodo.add(act);
    }

    public boolean removeActividadFueraPeriodo(DTOCronogramaActividad act) {
        //Definido por Gabriel Guardincerri
        return actFueraPeriodo.remove(act);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date newFechaInicio) {
        fechaInicio = newFechaInicio;
    }

  public Integer getDiasFinal()
  {
    return diasFinal;
  }

  public void setDiasFinal(Integer newDiasFinal)
  {
    diasFinal = newDiasFinal;
  }

  public Integer getDiasIntervalo()
  {
    return diasIntervalo;
  }

  public void setDiasIntervalo(Integer newDiasIntervalo)
  {
    diasIntervalo = newDiasIntervalo;
  }

    

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long newRegion) {
        region = newRegion;
    }

    public Long getSubgerenciaVentas() {
        return subgerenciaVentas;
    }

    public void setSubgerenciaVentas(Long newSubgerenciaVentas) {
        subgerenciaVentas = newSubgerenciaVentas;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long newZona) {
        zona = newZona;
    }

    public Long getOidCronograma() {
        return oidCronograma;
    }

    public void setOidCronograma(Long newOidCronograma) {
        oidCronograma = newOidCronograma;
    }
    
}
