package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOEstadoMAV  extends DTOAuditableSICC{
	private Long oidEstadoMAV;
	private Vector descripcion;
	private Vector estadosMAE;
	private Boolean activo;
	private Boolean noActivo;


	public DTOEstadoMAV() {
	}

	public Long getOidEstadoMAV() {
		return oidEstadoMAV;
	}

	public void setOidEstadoMAV(Long newOidEstadoMAV) {
		oidEstadoMAV = newOidEstadoMAV;
	}

	public Vector getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Vector newDescripcion) {
		descripcion = newDescripcion;
	}

	public Vector getEstadosMAE() {
		return estadosMAE;
	}

	public void setEstadosMAE(Vector newEstadosMAE) {
		estadosMAE = newEstadosMAE;
	}
	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean newActivo) {
		activo = newActivo;
	}

	public Boolean getNoActivo() {
		return noActivo;
	}

	public void setNoActivo(Boolean newNoActivo) {
		noActivo = newNoActivo;
	}
	
}