/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       02/08/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */
package es.indra.sicc.dtos.ped;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTipoSolicitudOperacion extends DTOBelcorp {
	protected Long oidMarca;
	protected Long oidCanal;
	protected Long oidTipoCliente;
	protected Long oidOperacion;

	public DTOTipoSolicitudOperacion() {}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Long getOidOperacion() {
		return oidOperacion;
	}

	public void setOidOperacion(Long newOidOperacion) {
		oidOperacion = newOidOperacion;
	}
}