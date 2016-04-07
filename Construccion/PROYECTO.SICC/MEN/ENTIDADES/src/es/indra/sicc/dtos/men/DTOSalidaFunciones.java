package es.indra.sicc.dtos.men;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSalidaFunciones extends DTOAuditableSICC  {
	private Long IdFuncion;
	private String nombreFuncion;
	private Integer indicadorNivel;
	private String indicadorRastreo;
	private Boolean activa;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

	public Long getIdFuncion() {
		return IdFuncion;
	}

	public void setIdFuncion(Long newIdFuncion) {
		IdFuncion = newIdFuncion;
	}

	public String getNombreFuncion() {
		return nombreFuncion;
	}

	public void setNombreFuncion(String newNombreFuncion) {
		nombreFuncion = newNombreFuncion;
	}

	public Integer getIndicadorNivel() {
		return indicadorNivel;
	}

	public void setIndicadorNivel(Integer newIndicadorNivel) {
		indicadorNivel = newIndicadorNivel;
	}

	public String getIndicadorRastreo() {
		return indicadorRastreo;
	}

	public void setIndicadorRastreo(String newIndicadorRastreo) {
		indicadorRastreo = newIndicadorRastreo;
	}

	public Boolean isActiva() {
		return activa;
	}

	public void setActiva(Boolean newActiva) {
		activa = newActiva;
	}
}