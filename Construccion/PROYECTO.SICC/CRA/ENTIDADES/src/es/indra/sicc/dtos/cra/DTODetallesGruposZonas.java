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

import java.util.Collection;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/11/2003
 * Observaciones:     
 * @version           
 * @autor             Emilio Noziglia
 */
 
public class DTODetallesGruposZonas extends DTOAuditableSICC {

  private String codigoGrupoDetalle;
  private DTOZonas zona;
  private Long oidDetalle;
  private Long oidGrupo;
  private Long oidZona;

  public DTODetallesGruposZonas(){
    super();
  }

  public DTODetallesGruposZonas(String codigoGrupoDetalle, DTOZonas zona){
    super();
    this.codigoGrupoDetalle = codigoGrupoDetalle;
    this.zona = zona;
  }

  public String getCodigoGrupoDetalle(){
		return this.codigoGrupoDetalle;
	}

	public void setCodigoGrupoDetalle(String codigoGrupoDetalle){
		this.codigoGrupoDetalle = codigoGrupoDetalle;
	}

  public DTOZonas getZona(){
		return this.zona;
	}

	public void setZona(DTOZonas zona){
		this.zona = zona;
	}
  
  public Long getOidDetalle(){
		return this.oidDetalle;
	}

	public void setOidDetalle(Long oidDetalle){
		this.oidDetalle = oidDetalle;
	}

  public Long getOidGrupo(){
		return this.oidGrupo;
	}

	public void setOidGrupo(Long oidGrupo){
		this.oidGrupo = oidGrupo;
	}
  
  public Long getOidZona(){
		return this.oidZona;
	}

	public void setOidZona(Long oidZona){
		this.oidZona = oidZona;
	}
}
