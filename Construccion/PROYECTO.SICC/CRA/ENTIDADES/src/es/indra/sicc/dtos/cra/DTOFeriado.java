/**
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
import java.sql.Date;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             12/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Marcelo Jorge Maidana
 */

public class DTOFeriado extends DTOAuditableSICC{

  private Date diaFeriado;
  private Integer anio;
  private Boolean indicadorFestivo;
  private Boolean indicadorNoLaborable;
  private Long oid;
  private Long oidGrupoZona;
  private Long oidActividad;

  public DTOFeriado(){
    super();
  }

  public Date getDiaFeriado(){
    return this.diaFeriado;
  }

  public void setDiaFeriado( Date date ){
    this.diaFeriado = date;
  }

  public Integer getAnio(){
    return anio;
  }

  public void setAnio( Integer anio ){
    this.anio = anio;
  }

  public Boolean getIndicadorFestivo(){
    return this.indicadorFestivo;
  }

  public void setIndicadorFestivo( Boolean indicadorFestivo ){
    this.indicadorFestivo = indicadorFestivo;
  }

  public Boolean getIndicadorNoLaborable(){
    return this.indicadorNoLaborable;
  }

  public void setIndicadorNoLaborable( Boolean indicadorNoLaborable ){
    this.indicadorNoLaborable = indicadorNoLaborable;
  }

  public Long getOid(){
    return this.oid;
  }

  public void setOid( Long oid ){
    this.oid = oid;
  }

  public Long getOidGrupoZona(){
    return this.oidGrupoZona;
  }

  public void setOidGrupoZona( Long oidGrupoZona ){
    this.oidGrupoZona = oidGrupoZona;
  }

  public Long getOidActividad(){
    return oidActividad;
  }

  public void setOidActividad( Long oidActividad ){
    this.oidActividad = oidActividad;
  }
  
}

