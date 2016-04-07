package es.indra.sicc.dtos.mav;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarCargaBP extends DTOBelcorp  {
	private Long oidCanal;
	private Long oidMarca;
	private Long oidActividadMAV;
	private Long oidPeriodo;
	private Long oidTipoCliente;

	public DTOBuscarCargaBP() {
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidActividadMAV() {
		return oidActividadMAV;
	}

	public void setOidActividadMAV(Long newOidActividadMAV) {
		oidActividadMAV = newOidActividadMAV;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}
}