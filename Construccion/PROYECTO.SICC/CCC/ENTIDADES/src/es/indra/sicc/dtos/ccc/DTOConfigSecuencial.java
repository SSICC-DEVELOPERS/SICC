package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOConfigSecuencial extends DTOBelcorp  {
	Character indicadorConfigSec;

	public DTOConfigSecuencial() {
	}

	public Character getIndicadorConfigSec() {
		return indicadorConfigSec;
	}

	public void setIndicadorConfigSec(Character newIndicadorConfigSec) {
		indicadorConfigSec = newIndicadorConfigSec;
	}
}