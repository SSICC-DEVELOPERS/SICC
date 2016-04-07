package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOProblemaSolucion extends DTOAuditableSICC  {

        private Long tipoProblema;
        private String descripcionProblema;
        private Boolean solucion;
        private String negocio;
        private Long oid;
	private String descripcionSolucion;
	private Long tipoSolucion;
       

    public String getDescripcionProblema() {
		return descripcionProblema;
    }

    public void setDescripcionProblema(String newDescripcionProblema) {
		descripcionProblema = newDescripcionProblema;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String newNegocio) {
        negocio = newNegocio;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public void setSolucion(Boolean newSolucion) {
        solucion = newSolucion;
    }

    public Long getTipoProblema() {
		return tipoProblema;
    }

    public void setTipoProblema(Long newTipoProblema) {
		tipoProblema = newTipoProblema;
    }

	public String getDescripcionSolucion() {
		return descripcionSolucion;
	}

	public void setDescripcionSolucion(String newDescripcionSolucion) {
		descripcionSolucion = newDescripcionSolucion;
	}

	public Long getTipoSolucion() {
		return tipoSolucion;
	}

	public void setTipoSolucion(Long newTipoSolucion) {
		tipoSolucion = newTipoSolucion;
	}

}