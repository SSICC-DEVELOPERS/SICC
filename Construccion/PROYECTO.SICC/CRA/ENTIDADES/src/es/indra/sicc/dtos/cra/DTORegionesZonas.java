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
import java.util.Collection;
import es.indra.sicc.util.DTOBelcorp;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     
 * @version           
 * @autor             Emilio Noziglia
 */
 
public class DTORegionesZonas extends DTOAuditableSICC {

  private Long pais;
  private Long marca;
  private Long canal;
  private String region;  
  private Collection zonas;
  private Long oidRegion;
    private String descripcionRegion;

  public DTORegionesZonas(){
    super();
  }

  public DTORegionesZonas(Long pais, Long marca, Long canal, String region, Collection zonas){
    super();
    this.pais = pais;
    this.marca = marca;
    this.region = region;    
    this.zonas = zonas;
  }

  public Long getPais(){
		return this.pais;
	}

	public void setPais(Long pais){
		this.pais = pais;
	}

  public Long getMarca(){
		return this.marca;
	}

	public void setMarca(Long marca){
		this.marca = marca;
	}

  public Long getCanal(){
		return this.canal;
	}

	public void setCanal(Long canal){
		this.canal = canal;
	}

  public String getRegion(){
		return this.region;
	}

	public void setRegion(String region){
		this.region = region;
	}  

  public Collection getZonas(){
		return this.zonas;
	}

	public void setZonas(Collection zonas){
		this.zonas = zonas;
	}
  
  public Long getOidRegion(){
		return this.oidRegion;
	}

	public void setOidRegion(Long oidRegion){
		this.oidRegion = oidRegion;
	}  

    public String getDescripcionRegion()
    {
        return descripcionRegion;
    }

    public void setDescripcionRegion(String newDescripcionRegion)
    {
        descripcionRegion = newDescripcionRegion;
    }
}
