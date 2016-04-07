package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOEnviarPedidosSAP extends DTOINT {
	private Long oidPeriodo;
	private Date fechaFacturacion;

	public DTOEnviarPedidosSAP() {
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long oidPeriodo) {
		this.oidPeriodo = oidPeriodo;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
}