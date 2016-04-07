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

package es.indra.sicc.dtos.mav;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOEnvioIniFinPeriodo extends DTOBelcorp {

	private Long marca;  
	private Long canal;  
	private Long periodo; 
	private ArrayList actividades;
 
  public DTOEnvioIniFinPeriodo() {
    super();
  }

  public void setMarca(Long marca)
  {
    this.marca = marca;
  }

  public Long getMarca()
  {
    return marca;
  }

  public void setCanal(Long canal)
  {
    this.canal = canal;
  }

  public Long getCanal()
  {
    return canal;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setActividades(ArrayList actividades)
  {
    this.actividades = actividades;
  }


  public ArrayList getActividades()
  {
    return actividades;
  }
  
}