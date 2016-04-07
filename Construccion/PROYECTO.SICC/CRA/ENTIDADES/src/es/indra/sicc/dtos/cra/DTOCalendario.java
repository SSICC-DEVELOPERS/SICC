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

import java.util.Vector;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             04/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Marcelo Jorge Maidana
 */

public class DTOCalendario extends DTOAuditableSICC{

	private Long oidPais;
  private Long oidMarca;
  private Long oidCanal;
  private Vector feriados;
  private Integer anyo;
  //Incidencia 9980
  private Boolean indSabado;
  private Boolean indDomingo;

  public DTOCalendario(){
    super();
  }

  //*******************
  //GETTERS
  //*******************

  public Long getOidPais(){
    return oidPais;
  }
  
  public Long getOidMarca(){
    return oidMarca;
  }

  public Long getOidCanal(){
    return oidCanal;
  }

  public Vector getFeriados(){
    return feriados;
  }

  public Integer getAnyo(){
    return anyo;
  }


  //*******************
  //SETTERS
  //*******************

  public void setOidPais( Long pais ){
    this.oidPais = pais;
  }
  
  public void setOidMarca( Long marca ){
    this.oidMarca = marca;
  }

  public void setOidCanal( Long canal ){
    this.oidCanal = canal;
  }
  
  public void setAnyo( Integer anyo ){
    this.anyo = anyo;
  }

  public void setFeriados( Vector feriados ){
    this.feriados = feriados;
  }

  public Boolean getIndSabado() {
    return indSabado;
  }

  public void setIndSabado(Boolean newIndSabado) {
    indSabado = newIndSabado;
  }

  public Boolean getIndDomingo() {
    return indDomingo;
  }

  public void setIndDomingo(Boolean newIndDomingo) {
    indDomingo = newIndDomingo;
  }
  
}


