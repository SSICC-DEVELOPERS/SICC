package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Comparable;

public class DTOElementoPlantilla extends DTOAuditableSICC implements Comparable {

	private Long tipoSolicitud;
	private Long region;
	private Long zona;
	private Integer secuencia;

	public DTOElementoPlantilla() {
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer newSecuencia) {
		secuencia = newSecuencia;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}

  public int compareTo(Object o) {
      DTOElementoPlantilla dtoElementoPlantilla = (DTOElementoPlantilla) o; 
      if (getSecuencia() == null || dtoElementoPlantilla.getSecuencia() == null) { 
          throw new IllegalArgumentException("No es posible comparar los dos elementos, porque no tienen ambos el atributo secuencia"); 
      } 

      return secuencia.compareTo(dtoElementoPlantilla.getSecuencia());
  }
}