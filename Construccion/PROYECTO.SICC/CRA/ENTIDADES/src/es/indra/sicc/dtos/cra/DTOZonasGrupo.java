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

import java.util.ArrayList;
import java.util.Collection;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Importado desde Version 2 y modificado segun requerimientos
 *                    generales de la Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 * */

public class DTOZonasGrupo extends DTOAuditableSICC {

	private Long Zona;
    //Definido por Gabriel Guardincerri
    private Collection acts = new ArrayList();
    //Definido por Gabriel Guardincerri
    private Long codGrupoZona;
  private String codZona;
  private String descZona;
    
    


	public DTOZonasGrupo() {
		super();
	}


	public DTOZonasGrupo(Long Zona) {
		super();
		this.Zona = Zona;
	}

	public Long getZona(){
		return this.Zona;
	}

	public void setZona( Long Zona){
		this.Zona = Zona;
	}

    public Collection getDTOCronogramaActividades() {
        //Definido por Gabriel Guardincerri
        return acts;
    }

    public Collection getActs() {
        //Definido por Gabriel Guardincerri
        return acts;
    }

    public void setDTOCronogramaActividades(Collection acts) {
        //Definido por Gabriel Guardincerri
        this.acts = acts;
    }
    
    public void addDTOCronogramaActividad(DTOCronogramaActividad act) {
        //Definido por Gabriel Guardincerri
        acts.add(act);
    }

    public boolean removeDTOCronogramaActividad(DTOCronogramaActividad act) {
        //Definido por Gabriel Guardincerri
        return acts.remove(act);
    }

    public Long getCodGrupoZona() {
        return codGrupoZona;
    }

    public void setCodGrupoZona(Long codGrupoZona) {
        this.codGrupoZona = codGrupoZona;
    }

  public String getCodZona()
  {
    return codZona;
  }

  public void setCodZona(String newCodZona)
  {
    codZona = newCodZona;
  }

  public String getDescZona()
  {
    return descZona;
  }

  public void setDescZona(String newDescZona)
  {
    descZona = newDescZona;
  }
}
