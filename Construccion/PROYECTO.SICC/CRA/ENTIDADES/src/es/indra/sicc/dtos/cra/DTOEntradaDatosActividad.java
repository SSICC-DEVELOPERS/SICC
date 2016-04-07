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

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/06/2003
 * Observaciones:     Importado desde Version 2 y modificado segun requerimientos
 *                    generales de la Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 */

public class DTOEntradaDatosActividad extends DTOAuditableSICC {

	private Long codigoPais;
	private Long codigoMarca;
	private Long codigoCanal;
	private Long codigoActividad;
	private String nombreActividad;
	private Boolean tipoActividad;
	private Long codigoActividadRef;
    private Integer codigoAreaResponsable;
	private Boolean ebelNoticias;
    private Vector procesosAsignados;
  private Integer diasDesplazamiento;
    private String laboral;

	public DTOEntradaDatosActividad() {
		super();
	}


	public DTOEntradaDatosActividad(Long codigoPais,
			Long codigoMarca,
			Long codigoCanal,
			Long codigoActividad,
			String  nombreActividad,
			Boolean tipoActividad,
			Long codigoActividadRef,
			Integer codigoAreaResponsable,
			Boolean ebelNoticias,
			Vector procesosAsignados,
      Integer diasDesplazamiento) {
		super();
		this.codigoPais = codigoPais;
		this.codigoMarca = codigoMarca;
		this.codigoCanal = codigoCanal;
		this.codigoActividad = codigoActividad;
		this.nombreActividad = nombreActividad;
		this.tipoActividad = tipoActividad;
		this.codigoActividadRef = codigoActividadRef;
		this.codigoAreaResponsable = codigoAreaResponsable;
		this.ebelNoticias = ebelNoticias;
		this.procesosAsignados = procesosAsignados;
		this.diasDesplazamiento = diasDesplazamiento;
	}

	public Long getCodigoPais(){
		return this.codigoPais;
	}

	public void setCodigoPais(Long codigoPais){
		this.codigoPais = codigoPais;
	}

	public Long getCodigoMarca(){
		return this.codigoMarca;
	}

	public void setCodigoMarca( Long codigoMarca){
		this.codigoMarca = codigoMarca;
	}

	public Long getCodigoCanal(){
		return this.codigoCanal;
	}

	public void setCodigoCanal( Long codigoCanal){
		this.codigoCanal = codigoCanal;
	}

	public Long getCodigoActividad(){
		return this.codigoActividad;
	}

	public void setCodigoActividad( Long codigoActividad){
		this.codigoActividad = codigoActividad;
	}

	public String getNombreActividad(){
		return this.nombreActividad;
	}

	public void setNombreActividad( String nombreActividad){
		this.nombreActividad = nombreActividad;
	}

	public Boolean getTipoActividad(){
		return this.tipoActividad;
	}

	public void setTipoActividad( Boolean tipoActividad){
		this.tipoActividad = tipoActividad;
	}

	public Long getCodigoActividadRef(){
		return this.codigoActividadRef;
	}

	public void setCodigoActividadRef( Long codigoActividadRef){
		this.codigoActividadRef = codigoActividadRef;
	}

	public Integer getCodigoAreaResponsable(){
        return codigoAreaResponsable;
	}

	public void setCodigoAreaResponsable( Integer newCodigoAreaResponsable){
        codigoAreaResponsable = newCodigoAreaResponsable;
	}

	public Boolean getEbelNoticias(){
		return this.ebelNoticias;
	}

	public void setEbelNoticias( Boolean ebelNoticias){
		this.ebelNoticias = ebelNoticias;
	}

	public Vector getProcesosAsignados(){
        return procesosAsignados;
	}

	public void setProcesosAsignados( Vector newProcesosAsignados){
        procesosAsignados = newProcesosAsignados;
	}

  public Integer getDiasDesplazamiento()
  {
    return diasDesplazamiento;
  }

  public void setDiasDesplazamiento(Integer newDiasDesplazamiento)
  {
    diasDesplazamiento = newDiasDesplazamiento;
  }

    public String getLaboral() {
        return laboral;
    }

    public void setLaboral(String newLaboral) {
        laboral = newLaboral;
    }

}
