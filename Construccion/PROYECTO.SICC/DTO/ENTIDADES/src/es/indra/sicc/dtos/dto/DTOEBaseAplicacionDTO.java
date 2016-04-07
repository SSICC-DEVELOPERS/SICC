package es.indra.sicc.dtos.dto;

import java.util.ArrayList;

public class DTOEBaseAplicacionDTO extends DTOEBaseCalculoDTO  {
	ArrayList escalones;
	Integer numeroUnidadesObligatorias;
    private Long oidEscala;

	public DTOEBaseAplicacionDTO() {
	}

	public ArrayList getEscalones() {
		return escalones;
	}

	public void setEscalones(ArrayList newEscalones) {
		escalones = newEscalones;
	}

	public Integer getNumeroUnidadesObligatorias() {
		return numeroUnidadesObligatorias;
	}

	public void setNumeroUnidadesObligatorias(Integer newNumeroUnidadesObligatorias) {
		numeroUnidadesObligatorias = newNumeroUnidadesObligatorias;
	}

    public Long getOidEscala() {
        return oidEscala;
    }

    public void setOidEscala(Long newOidEscala) {
        oidEscala = newOidEscala;
    }

	
}