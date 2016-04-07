package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOModificarCliente extends DTOAuditableSICC {
	DTOCliente datosCliente;
	Long[] identificacionesQuitadas;
  Long[] tiposQuitados;
	Long[] marcasQuitadas; 
	Long[] direccionesQuitadas;
	Long[] clasificacionesQuitadas;
	Long[] vinculosQuitados; 
	Long[] preferenciasQuitadas; 
	Long[] observacionesQuitadas;
	Long[] comunicacionesQuitadas;
	Long[] tarjetasQuitadas; 
	Long[] problemasQuitados;
	Long[] psicografiasQuitadas; 

	public Long[] getClasificacionesQuitadas() {
		return clasificacionesQuitadas;
	}

	public void setClasificacionesQuitadas(Long[] newClasificacionesQuitadas) {
		clasificacionesQuitadas = newClasificacionesQuitadas;
	}

  public Long[] getTiposQuitados() {
		return tiposQuitados;
	}

	public void setTiposQuitados(Long[] newTiposQuitados) {
		tiposQuitados = newTiposQuitados;
	}

	public Long[] getComunicacionesQuitadas() {
		return comunicacionesQuitadas;
	}

	public void setComunicacionesQuitadas(Long[] newComunicacionesQuitadas) {
		comunicacionesQuitadas = newComunicacionesQuitadas;
	}

	public DTOCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DTOCliente newDatosCliente) {
		datosCliente = newDatosCliente;
	}

	public Long[] getDireccionesQuitadas() {
		return direccionesQuitadas;
	}

	public void setDireccionesQuitadas(Long[] newDireccionesQuitadas) {
		direccionesQuitadas = newDireccionesQuitadas;
	}

	public Long[] getIdentificacionesQuitadas() {
		return identificacionesQuitadas;
	}

	public void setIdentificacionesQuitadas(Long[] newIdentificacionesQuitadas) {
		identificacionesQuitadas = newIdentificacionesQuitadas;
	}

	public Long[] getMarcasQuitadas() {
		return marcasQuitadas;
	}

	public void setMarcasQuitadas(Long[] newMarcasQuitadas) {
		marcasQuitadas = newMarcasQuitadas;
	}

	public Long[] getObservacionesQuitadas() {
		return observacionesQuitadas;
	}

	public void setObservacionesQuitadas(Long[] newObservacionesQuitadas) {
		observacionesQuitadas = newObservacionesQuitadas;
	}

	public Long[] getPreferenciasQuitadas() {
		return preferenciasQuitadas;
	}

	public void setPreferenciasQuitadas(Long[] newPreferenciasQuitadas) {
		preferenciasQuitadas = newPreferenciasQuitadas;
	}

	public Long[] getProblemasQuitados() {
		return problemasQuitados;
	}

	public void setProblemasQuitados(Long[] newProblemasQuitados) {
		problemasQuitados = newProblemasQuitados;
	}

	public Long[] getPsicografiasQuitadas() {
		return psicografiasQuitadas;
	}

	public void setPsicografiasQuitadas(Long[] newPsicografiasQuitadas) {
		psicografiasQuitadas = newPsicografiasQuitadas;
	}



	public Long[] getTarjetasQuitadas() {
		return tarjetasQuitadas;
	}

	public void setTarjetasQuitadas(Long[] newTarjetasQuitadas) {
		tarjetasQuitadas = newTarjetasQuitadas;
	}

	public Long[] getVinculosQuitados() {
		return vinculosQuitados;
	}

	public void setVinculosQuitados(Long[] newVinculosQuitados) {
		vinculosQuitados = newVinculosQuitados;
	}
	

}